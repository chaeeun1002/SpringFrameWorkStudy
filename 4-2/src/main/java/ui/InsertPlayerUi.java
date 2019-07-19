package ui;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import dao.PlayerDao;
import dao.TeamDao;
import model.Player;
import model.Team;

public class InsertPlayerUi extends AbstractUi {
	private PlayerDao playerDao;
	private TeamDao teamDao;
	public void setPlayerDao(PlayerDao playerDao) {
		this.playerDao = playerDao;
	}
	public void setTeamDao(TeamDao teamDao) {
		this.teamDao = teamDao;
	}
	public void showMenu(String str) {
		System.out.println("==========================");
		System.out.println();
		System.out.printf("%s를 입력하고 Enter를 누르세요.",str);
		System.out.println("아무것도 입력하지 않고 Enter를 누르면 "+"메뉴로 돌아갑니다.");
	}
	protected void showTeamField(Player p) {
		showMenu("팀 번호");
		String id = this.getInputedString();
		if(StringUtils.isEmpty(id)) return;
		else {
			Team team = teamDao.getTeam(Integer.valueOf(id));
			p.setTeam(team);
			showPlayerID(p,team);
		}
	}
	protected void showPlayerID(Player p, Team t) {
		showMenu("선수 번호");
		String id = this.getInputedString();
		if(StringUtils.isEmpty(id)) return;
		else {
			p.setPlayer_id(Integer.valueOf(id));
			playerDao.insertPlayer(p);
			System.out.printf("팀 %s에 %s 선수를 등록했습니다.\n",t.getName(),p.getName());
		}
	}
	@Transactional(propagation=Propagation.REQUIRED)
	public void show() {
		showMenu("선수 이름");
		String name = this.getInputedString();
		if(StringUtils.isEmpty(name)) return;
		else {
			Player player = new Player();
			player.setName(name);
			showTeamField(player);
		}
	}

}
