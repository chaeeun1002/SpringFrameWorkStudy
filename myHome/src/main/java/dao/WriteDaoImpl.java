package dao;

import java.util.Calendar;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Bbs;
@Repository
public class WriteDaoImpl implements WriteDao {
	
	@Autowired
	private SqlSession session;
	
	public Integer getMaxId() {
		Integer seqno = session.selectOne("mappers.mymapper.getMaxBbsId");
		if(seqno == null) {
			seqno = 0;
		}
		return seqno;
	}

	public void insertBBS(Bbs bbs) {
		bbs.setSeqno(getMaxId()+1);
		Calendar today = Calendar.getInstance();
		int year = today.get(Calendar.YEAR);
		int month = today.get(Calendar.MONTH)+1;
		int date = today.get(Calendar.DATE);
		String bbsDate = year+"/"+month+"/"+date;
		bbs.setBbs_date(bbsDate);
		session.insert("mappers.mymapper.putBBS",bbs);
	}

}
