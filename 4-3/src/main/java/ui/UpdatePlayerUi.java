package ui;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import dao.PlayerDao;
import dao.TeamDao;
import model.Player;
import model.Team;

public class UpdatePlayerUi extends AbstractUi {
	private TeamDao teamDao;
	private PlayerDao playerDao;
	public void setTeamDao(TeamDao teamDao) {
		this.teamDao = teamDao;
	}
	public void setPlayerDao(PlayerDao playerDao) {
		this.playerDao = playerDao;
	}
	protected void showMenu(String str) {
		System.out.println("=========================");
		System.out.printf("%s를 입력하고 Enter를 누르세요.",str);
		System.out.println("아무것도 입력하지 않고 Enter를 누르면"+"메뉴로 돌아갑니다.");
	}
	protected String getName(Player p) {
		showMenu("선수 이름");
		System.out.printf("기존값 : %s\n",p.getName());
		String name = this.getInputedString();
		if(StringUtils.isEmpty(name)) return null;
		return name;
	}
	protected Team getTeam(Player p) {
		showMenu("팀 번호");
		String id = this.getInputedString();
		System.out.printf("기존값:%s %s\n",p.getTeam().getTeam_id(),p.getTeam().getName());
		if(StringUtils.isEmpty(id)) return null;
		Team team = teamDao.getTeam(Integer.valueOf(id));
		if(team == null) {
			System.out.printf("%s인 번호의 팀은 없습니다.",id);
			return getTeam(p);
		}else {
			return team;
		}
	}
	protected Player getPlayer() {
		showMenu("선수 번호");
		String id = this.getInputedString();
		if(StringUtils.isEmpty(id)) return null;
		else {
			Player player = playerDao.getPlayer(Integer.valueOf(id));
			if(player == null) {
				System.out.printf("%s인 번호의 선수는 존재하지 않습니다.",id);
				return getPlayer();
			}else {
				return player;
			}
		}
	}
	@Transactional(propagation=Propagation.REQUIRED)
	public void show() {
		Player player = getPlayer();
		if(player == null) return;
		String name = getName(player);
		if(! StringUtils.isEmpty(name)) {
			player.setName(name);
		}
		Team team = getTeam(player);
		if(team != null) player.setTeam(team);
		playerDao.updatePlayer(player);//선수정보 변경
		System.out.printf("%s인 번호의 선수를, 이름 %s, 팀 %s로"+"변경했습니다.\n",player.getPlayer_id(),player.getName(),player.getTeam().getName());
	}

}
