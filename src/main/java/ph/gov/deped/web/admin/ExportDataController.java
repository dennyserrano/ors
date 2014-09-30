package ph.gov.deped.web.admin;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ph.gov.deped.data.dto.ds.Dataset;
import ph.gov.deped.service.meta.api.MetadataService;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by PSY on 2014/09/30.
 */
@Controller
@RequestMapping("/export")
public class ExportDataController {

    private static final Logger log = LogManager.getLogger(ExportDataController.class);

    private final String tmpDir = System.getProperty("java.io.tmpdir");

    private MetadataService metadataService;

    public @Autowired void setMetadataService(MetadataService metadataService) {
        this.metadataService = metadataService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public void export(String dataset, HttpServletResponse response) throws Exception {
        Dataset ds = new ObjectMapper().readValue(dataset, Dataset.class);
        List<Map<String, Serializable>> data = metadataService.preview(ds);
        String filenameStr = tmpDir + File.separator + RandomStringUtils.randomAlphanumeric(5) + ".csv";
        File csvFile = new File(filenameStr);
        if (!csvFile.exists()) {
            try {
                csvFile.createNewFile();
            }
            catch (IOException ex) {
                log.error("Unable to create CSV file [{}].", ex);
                log.catching(ex);
                throw ex;
            }
        }
        try (BufferedWriter out = new BufferedWriter(new FileWriter(csvFile))) {
            data.forEach(row -> {
                String line = row.entrySet().stream()
                        .map(String::valueOf)
                        .reduce((val1, val2) -> val1 + "," + val2)
                        .get();
                write(out, line);
            });
        }

        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; filename=export.csv");

        try (FileInputStream fis = new FileInputStream(csvFile);
             OutputStream os = response.getOutputStream()) {
            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
        }
    }

    private void write(BufferedWriter out, String line) throws RuntimeException {
        try {
            out.write(line);
        }
        catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
