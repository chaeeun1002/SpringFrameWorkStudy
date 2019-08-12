package logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ReadDao;
import dao.WriteDao;
import model.Bbs;
import model.Condition;
import model.Writing;

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

	public void updateWriting(Writing writing) {
		this.writeDao.updateWriting(writing);
	}

	public void deleteWriting(Writing writing) {
		this.writeDao.deleteWriting(writing);
	}

	public Writing getWritingById(Integer id) {
		return this.writeDao.getWritingById(id);
	}

	public void insertWriting(Writing writing) {
		this.writeDao.insertWriting(writing);
	}

	public Integer getMaxWritingId() {
		return this.writeDao.getMaxWritingId();
	}

	public List<Writing> getWriting(Condition c) {
		return this.writeDao.getWriting(c);
	}

}
