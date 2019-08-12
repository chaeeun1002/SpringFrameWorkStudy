package logic;

import java.util.List;

import model.Bbs;
import model.Condition;
import model.Writing;

public interface WriteCatalog {
	Integer getMaxBbsId();
	void putBbs(Bbs bbs);
	
	List<Bbs> readBbs(Condition c);
	Integer getBbsCount();
	Bbs getBbsDetail(Integer id);
	
	void updateWriting(Writing writing);//게시글 수정
	void deleteWriting(Writing writing);//게시글 삭제
	Writing getWritingById(Integer id);//글번호로 글정보 검색
	void insertWriting(Writing writing);//게시글 저장
	Integer getMaxWritingId();//최대 글번호 검색
	List<Writing> getWriting(Condition c);//글목록 검색
}
