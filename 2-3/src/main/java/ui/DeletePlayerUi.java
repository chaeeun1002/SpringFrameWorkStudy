package ui;

import org.apache.commons.lang3.StringUtils;

import dao.PlayerDao;
import model.Player;

public class DeletePlayerUi extends AbstractUi {
	private PlayerDao playerDao;
	public void setPlayerDao(PlayerDao playerDao) {
		this.playerDao = playerDao;
	}
	protected void showMenu() {
		System.out.println("=========================");
		System.out.println("선수 ID를 입력하고 Enter를 누르세요.");
		System.out.println("아무것도 입력하지 않고 Enter를 누르면 " + "메뉴로 돌아갑니다.");
	}
	@Override
	public void show() {
		showMenu();
		String id = this.getInputedString();//선수 ID를 입력받음
		if(StringUtils.isEmpty(id)) {
			return;
		}else if(Utility.isNumeric(id, "선수ID")) {
			Player player = playerDao.getPlayer(Integer.valueOf(id));
			if(player == null) {//검색된 선수가 없는 경우
				System.out.printf("%d인 번호의 선수는 없습니다.",id);
				show();
			}else {//검색된 선수가 있는 경우
				playerDao.deletePlayer(Integer.parseInt(id));//DB에서 삭제
				System.out.printf("%s 번호의 선수를 삭제합니다.%n",id);
			}
		}else {
			show();
		}
	}

}
