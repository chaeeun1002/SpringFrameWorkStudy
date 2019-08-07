package dao;

import model.Bbs;

public interface WriteDao {
	//게시글을 위한 메서드
	Integer getMaxId();
	void insertBBS(Bbs bbs);
}
