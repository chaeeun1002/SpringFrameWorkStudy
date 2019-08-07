package logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ReadDao;
import dao.WriteDao;
import model.Bbs;
import model.Condition;

@Service
public class WriteCatalogImpl implements WriteCatalog {

	@Autowired
	private WriteDao writeDao;
	@Autowired
	private ReadDao readDao;
	
	public Integer getMaxBbsId() {
		return this.writeDao.getMaxId();
	}

	public void putBbs(Bbs bbs) {
		this.writeDao.insertBBS(bbs);
	}

	public List<Bbs> readBbs(Condition c) {
		return this.readDao.readBbs(c);
	}

	public Integer getBbsCount() {
		return this.readDao.getBbsCount();
	}

	public Bbs getBbsDetail(Integer id) {
		return this.readDao.getBbsDetail(id);
	}

}
