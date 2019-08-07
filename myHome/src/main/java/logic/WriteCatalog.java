package logic;

import java.util.List;

import model.Bbs;
import model.Condition;

public interface WriteCatalog {
	Integer getMaxBbsId();
	void putBbs(Bbs bbs);
	
	List<Bbs> readBbs(Condition c);
	Integer getBbsCount();
	Bbs getBbsDetail(Integer id);
}
