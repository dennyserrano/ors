package ph.gov.deped.web.admin;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ph.gov.deped.data.dto.ds.Dataset;
import ph.gov.deped.service.data.api.DatasetService;
import ph.gov.deped.service.data.api.ExportService;
import ph.gov.deped.service.data.api.ExportType;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.List;

/**
 * Created by PSY on 2014/09/30.
 */
@Controller
@RequestMapping("/export")
public class ExportDataController {

    private DatasetService datasetService;

    private ExportService exportService;

    public @Autowired void setDatasetService(DatasetService datasetService) {
        this.datasetService = datasetService;
    }

    public @Autowired void setExportService(ExportService exportService) {
        this.exportService = exportService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public void export(@RequestParam("dataset") String dataset, HttpServletResponse response) throws Exception {
        Dataset ds = new ObjectMapper().readValue(dataset, Dataset.class);
        List<List<Serializable>> data = datasetService.getData(ds, false);

        ExportType exportType = ExportType.XLSX; // TODO Should be user defined from request; constant for now.
        String filename = exportService.export(data, exportType);

        response.setContentType(exportType.getContentType());
        response.setHeader("Content-Disposition", "attachment; filename=export." + exportType.getExtension());

        try (FileInputStream fis = new FileInputStream(new File(filename));
            OutputStream os = response.getOutputStream()) {
            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.flush();
        }
    }
}
