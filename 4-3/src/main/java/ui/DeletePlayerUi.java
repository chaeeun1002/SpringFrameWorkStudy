package ui;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import dao.PlayerDao;
import model.Player;

public class DeletePlayerUi extends AbstractUi {
	private PlayerDao playerDao;
	public void setPlayerDao(PlayerDao playerDao) {
		this.playerDao = playerDao;
	}
	protected void showMenu() {
		System.out.println("=========================");
		System.out.println("선수 번호를 입력하고 Enter를 누르세요.");
		System.out.println("아무것도 입력하지 않고 Enter를 누르면"+"메뉴로 돌아갑니다.");
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void show() {
		showMenu();
		String id = this.getInputedString();
		if(StringUtils.isEmpty(id)) return;
		else {
			Player player = playerDao.getPlayer(Integer.valueOf(id));
			if(player == null) {
				System.out.printf("%s인 번호의 선수는 존재하지 않습니다.\n",id);
			}else {
				this.playerDao.deletePlayer(player);
				System.out.printf("%s번호의 선수를 삭제하였습니다.\n",id);
			}
		}
	}

}
