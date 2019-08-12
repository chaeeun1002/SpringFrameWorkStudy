package controller;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Calendar;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import logic.WriteCatalog;
import model.Writing;

@Controller
public class WriteController {

	@Autowired
	private WriteCatalog writeCatalog;
	
	@RequestMapping(value = "/write/writeForm.html", method = RequestMethod.GET)
	public ModelAndView writeForm(HttpSession session) {
		String id = (String) session.getAttribute("loginUser");
		ModelAndView mav = new ModelAndView("home/template");
		if (id == null) {// 로그인 하지 않은 경우
			mav.addObject("BODY", "writeFormLogin.jsp");
		} else {// 로그인 한 경우
			mav.addObject("BODY", "writeForm.jsp");
			mav.addObject(new Writing());// 객체 주입(form:form)
		}
		return mav;
	}

	@RequestMapping(value="/write/write.html", method=RequestMethod.POST)
	public ModelAndView write(@Valid Writing writing, BindingResult bindingResult, HttpSession session) {
		if(bindingResult.hasErrors()) {
			ModelAndView mav = new ModelAndView();
			mav.addObject("BODY","writeForm.jsp");
			mav.getModel().putAll(bindingResult.getModel());
			return mav;
		}
		MultipartFile multiFile = writing.getImage();
		String fileName = null; String path = null;
		OutputStream os = null;
		if(multiFile != null) {//업로드 이미지를 선택한 경우
			fileName = multiFile.getOriginalFilename();
			ServletContext context = session.getServletContext();
			path = context.getRealPath("/upload"+fileName);
			try {
				os = new FileOutputStream(path);
				BufferedInputStream bis = new BufferedInputStream(multiFile.getInputStream());
				byte[] buffer = new byte[8196];//8k 크키 메모리 선언
				int read = 0;
				while((read=bis.read(buffer))>0) {
					os.write(buffer,0,read);//파일에 출력(즉,업로드)
				}
				if(os != null) os.close();
			}catch(Exception e) {
				
			}
			writing.setImage_name(fileName);
		}
		//DB에 삽입
		Integer maxId = writeCatalog.getMaxWritingId();
		if(maxId == null) maxId = 0;//글번호 설정
		if(writing.getParent_id() == null) {//원글인 경우
			writing.setParent_id(0);
			writing.setOrder_no(0);
		}else {//답글인 경우
			
		}
		writing.setWriting_id(maxId+1);//글번호 1증가
		Calendar today = Calendar.getInstance();
		int year = today.get(Calendar.YEAR);
		int month = today.get(Calendar.MONTH)+1;
		int date = today.get(Calendar.DATE);
		String registerDate = year+"/"+month+"/"+date;
		writing.setRegister_date(registerDate);
		this.writeCatalog.insertWriting(writing);
		ModelAndView mav = new ModelAndView("home/template");
		mav.addObject("BODY","writeResult.jsp?SEQNO="+(maxId+1));
		return mav;
	}

}
