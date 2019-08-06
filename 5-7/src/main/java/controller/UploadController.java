package controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import model.Writing;

@Controller
public class UploadController {
	@RequestMapping
	public void read(String file, HttpSession session,
		HttpServletResponse response) throws Exception {
		ServletContext context = session.getServletContext();
		String path = context.getRealPath("/upload");
		File filePath = new File(path+"/"+file);//File媛앹껜 �깮�꽦
		response.setContentType("application/octet-stream");
		//釉뚮씪�슦���뿉�꽌 泥섎━�맆 �뙆�씪�쓽 �삎�깭瑜� �꽕�젙(octet-stream�� 紐⑤뱺�뙆�씪�쓣 �쓽誘�)
		response.setHeader("Content-Disposition", "attachment");
		//釉뚮씪�슦���뿉�꽌 �뙆�씪 �떎�슫濡쒕뱶 李쎌뿴由� �꽕�젙
		FileInputStream fis=new FileInputStream(filePath);
		BufferedInputStream bis=new BufferedInputStream(fis);
		ServletOutputStream sos = response.getOutputStream();
		BufferedOutputStream bos=new BufferedOutputStream(sos);
		byte[] buffer = new byte[2048];//2k硫붾え由� �꽕�젙
		int input = 0;
		while( (input = bis.read(buffer))>0) {
			bos.write(buffer,0,input);
			bos.flush();
		}
		if(bos != null) bos.close();
		if(sos != null) sos.close();
		if(bis != null) bis.close();
		if(fis != null) fis.close();
	}
	
	
	@RequestMapping(value="/upload/write.html",
			method=RequestMethod.POST)
	public ModelAndView upload(Writing writing, 
			HttpSession session) {
		MultipartFile multiFile = writing.getImage();
		String fileName = multiFile.getOriginalFilename();
		String path = null; OutputStream os = null;
		if( !fileName.equals("")) {//�뙆�씪�씠 �꽑�깮�맂 寃쎌슦
			ServletContext context=session.getServletContext();
			path = context.getRealPath("/upload/"+fileName);
			try {
				os = new FileOutputStream(path);
				BufferedInputStream bis = new BufferedInputStream(
						multiFile.getInputStream());
				byte[] buffer = new byte[8196];
				int read = 0;
				while((read = bis.read(buffer)) > 0) {
					os.write(buffer,0,read);
				}
				if(os != null) os.close();
			}catch(Exception e) {				
			}
			writing.setImage_name(fileName);//�씠誘몄��뙆�씪 �씠由� �꽕�젙
		}
		return list(writing);
	}
	
	@RequestMapping(value="/upload/list.html",
				method=RequestMethod.GET)
	public ModelAndView list(Writing writing) {
		ModelAndView mav = new ModelAndView("list");
		mav.addObject("upload_file",writing);
		return mav;
	}
	
	@RequestMapping(value="/upload/form.html",
			method=RequestMethod.GET)
	public ModelAndView form() {
		ModelAndView mav = new ModelAndView("uploadForm");
		mav.addObject("writing",new Writing());
		return mav;
	}
}












