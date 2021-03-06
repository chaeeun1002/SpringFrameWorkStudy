package logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.EntryDao;
import dao.LoginDao;
import model.User;

@Service
public class LoginCatalogImpl implements LoginCatalog {

	@Autowired
	private LoginDao loginDao;
	@Autowired
	private EntryDao entryDao;
	
	public String getPwd(String id) {
		return this.loginDao.getPassword(id);
	}

	public Integer getIdCnt(String id) {
		return this.loginDao.getIdCount(id);
	}

	public void putUser(User user) {
		this.entryDao.entryUser(user);
	}

}
