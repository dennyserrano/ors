package ph.gov.deped.web.admin;

import com.bits.sql.AggregateTypes;
import com.ejb.stateless.interfaces.QueueServiceBeanRemote;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ph.gov.deped.data.dto.ColumnElement;
import ph.gov.deped.data.dto.ds.Dataset;
import ph.gov.deped.data.dto.ds.Element;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by PSY on 2014/09/30.
 */
@Controller
@RequestMapping("/export")
@ControllerAdvice
public class ExportDataController {
    
    private static final Logger log = LogManager.getLogger(ExportDataController.class);
    
    @Autowired
    private QueueServiceBeanRemote qsb;
    
//    private static final ExportType DEFAULT_EXPORT_TYPE = ExportType.XLSX;
    
//    @Autowired
//    @Qualifier("BulkExcelExportServiceImpl")
//    private ExportService exportService;

    @ExceptionHandler(Exception.class)
    public String handle(HttpServletRequest req, Exception ex){
    	return "user/error";
    }
    @RequestMapping(method = RequestMethod.POST)
    public void export(@RequestParam("dataset") String dataset, HttpSession httpSession, HttpServletResponse response) throws Exception {
    	
        Dataset ds = new ObjectMapper().readValue(dataset, Dataset.class);
        String filename=null;

//        XStream xs=new XStream();
//    	xs.toXML(ds, new FileOutputStream("/home/denny/dataset.xml"));
        
        //TODO improve
        if(ds.getAggregateBy()!=null)
    	{
    		
    		ArrayList<Element> al= new ArrayList<Element>(ds.getElements());
    		for(Element e:ds.getAggregateBy().getElements())
    		{
    			e.setAggregate(AggregateTypes.GROUP.getAggregate());
    			al.add(e);
    		}
    		ds.setElements(al);
    	}
        
        try {
              //datasetService.getData(ds, false);
//            exportService.export("", data, ExportType.XLSX);
        	log.info("Exporting::::::");
            filename="";//exportService.export(ds);
            
            if(filename==null)
            	return;
        }
        catch (Exception ex) {
            log.error("Unable to generate exported data.");
            log.throwing(ex);
            throw new RuntimeException(ex);
        }

//        ExportType exportType = DEFAULT_EXPORT_TYPE; // TODO Should be user defined from request; constant for now.

        response.setContentType("");
        response.setHeader("Content-Disposition", "attachment; filename=export."); //exportType.getExtension());
        
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
