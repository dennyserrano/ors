package ph.gov.deped.web.admin;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ph.gov.deped.data.dto.ColumnElement;
import ph.gov.deped.data.dto.ds.Dataset;
import ph.gov.deped.service.data.api.DatasetService;
import ph.gov.deped.service.data.api.ExportService;
import ph.gov.deped.service.data.api.ExportType;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by PSY on 2014/09/30.
 */
@Controller
@RequestMapping("/export")
public class ExportDataController {
    
    private static final Logger log = LogManager.getLogger(ExportDataController.class);
    
    private static final ExportType DEFAULT_EXPORT_TYPE = ExportType.XLSX;

    private DatasetService datasetService;

    private ExportService exportService;

    public @Autowired void setDatasetService(DatasetService datasetService) {
        this.datasetService = datasetService;
    }

    public @Autowired void setExportService(ExportService exportService) {
        this.exportService = exportService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public void export(@RequestParam("dataset") String dataset, HttpSession httpSession, HttpServletResponse response) throws Exception {
        Dataset ds = new ObjectMapper().readValue(dataset, Dataset.class);
        List<List<ColumnElement>> data = new ArrayList<>();
        try {
            data = datasetService.getData(ds, false);
        }
        catch (Exception ex) {
            log.error("Unable to generate exported data.");
            log.throwing(ex);
        }

        ExportType exportType = DEFAULT_EXPORT_TYPE; // TODO Should be user defined from request; constant for now.
        String filename = exportService.export(httpSession.getId(), data, exportType);

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
