package ph.gov.deped.web.admin;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ph.gov.deped.config.OrsSettings;

import com.file.ejb.remote.interfaces.FileServiceRemote;


@Controller
@ControllerAdvice
@RequestMapping("/download")
public class DownloadController {

	
	@Autowired
	private FileServiceRemote fileService;
	
	@Autowired
	private OrsSettings orsProp;
	
	@RequestMapping(method=RequestMethod.GET)
	public void download(@RequestParam("k")String key,HttpServletResponse response)
	{
		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		response.setHeader("Content-Disposition", "attachment; filename=export." + "xlsx");
		response.setContentType("text/csv");
		String fileName=fileService.getFileName(key);
		
		if(fileName==null)
			throw new RuntimeException();//return error page
		
		
		try {
			InputStream is=new FileInputStream(orsProp.getDownloadBaseUrl()+fileName);
			
			IOUtils.copy(is, response.getOutputStream());
			response.flushBuffer();
		} catch (FileNotFoundException e) {
			// Show error page/no file error page
			e.printStackTrace();
		} catch (IOException e) {
			// show error page/ no file error page
			e.printStackTrace();
		}
	}
	
}
