package logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.LoginDao;

@Service
public class LoginCatalogImpl implements LoginCatalog {

	@Autowired
	private LoginDao loginDao;
	
	public String getPwd(String id) {
		return this.loginDao.getPassword(id);
	}

	public Integer getIdCnt(String id) {
		return this.loginDao.getIdCount(id);
	}

}
