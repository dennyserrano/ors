package ph.gov.deped.web.admin;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ph.gov.deped.data.dto.ds.Dataset;
import ph.gov.deped.service.data.api.DatasetService;

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

    private DatasetService datasetService;

    public @Autowired void setDatasetService(DatasetService datasetService) {
        this.datasetService = datasetService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public void export(String dataset, HttpServletResponse response) throws Exception {
        Dataset ds = new ObjectMapper().readValue(dataset, Dataset.class);
        List<List<Serializable>> data = datasetService.getData(ds, false);
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
            for (int row = 0; row < data.size(); row++) {
                List<Serializable> values = data.get(row);
                StringBuilder line = new StringBuilder();
                for (int col = 0; col < values.size(); col++) {
                    line.append(values.get(col));
                    if (col < values.size() - 1) {
                        line.append(",");
                    }
                }
                write(out, line.toString());
            }
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
            os.flush();
        }
    }

    private void write(BufferedWriter out, String line) throws RuntimeException {
        try {
            out.write(line);
            out.write("\n");
        }
        catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
