package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import logic.WriteCatalog;
import model.Bbs;
import model.Condition;

@Controller
public class ReadController {
	
	@Autowired
	private WriteCatalog writeCatalog;
	
	@RequestMapping(value="/read/read.html", method=RequestMethod.GET)
	public ModelAndView readBbs(Integer pageNo) {
		 ModelAndView mav = new ModelAndView("home/template");
		 //페이지 갯수를 찾는다.
		 Integer cnt = writeCatalog.getBbsCount();
		 if(cnt == null) cnt = 0; 
		 int startRow = 0; int endRow = 0; int pageCnt = 0; 
		 int currentPage = 0;
		 if(pageNo == null) currentPage = 1;
		 else currentPage = pageNo;
		 if(cnt > 0) {//글의 갯수가 0보다 큰 경우
			 pageCnt = cnt / 5;
			 if(cnt % 5 > 0) pageCnt++;//페이지 갯수 계산
			 startRow = (currentPage - 1) * 5 + 1;
			 endRow = currentPage * 5;
			 if(endRow > cnt) endRow = cnt;
		 }
		 Condition c = new Condition();
		 c.setStartRow(startRow);
		 c.setEndRow(endRow);
		 //다섯개의 게시글을 찾는다.(조건 검색)
		 List<Bbs> bbsList = writeCatalog.readBbs(c);
		 //검색된 결과를 mav에 저장.
		 mav.addObject("BBS_LIST",bbsList);//검색된 게시글 저장
		 mav.addObject("COUNT",pageCnt);//페이지 갯수 저장
		 mav.addObject("BODY","bbsListView.jsp");
		 return mav;
	}
	
}
