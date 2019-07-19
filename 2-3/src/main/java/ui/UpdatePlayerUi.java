package ui;

import org.apache.commons.lang3.StringUtils;

import dao.PlayerDao;
import dao.TeamDao;
import model.Player;
import model.Team;

public class UpdatePlayerUi extends AbstractUi {
	private PlayerDao playerDao;
	private TeamDao teamDao;
	public void setPlayerDao(PlayerDao playerDao) {
		this.playerDao = playerDao;
	}
	public void setTeamDao(TeamDao teamDao) {
		this.teamDao = teamDao;
	}
	protected void showMenu(String wanted) {
		System.out.println("==============================");
		System.out.printf("%s를 입력하고 Enter를 누르세요.",wanted);
		System.out.println("아무것도 입력하지 않고 Enter를 누르면 " + "메뉴로 돌아갑니다.");
	}
	protected Player getPlayer() {
		final String playerId = "선수ID";
		showMenu(playerId);
		String id = this.getInputedString();
		if(StringUtils.isEmpty(id)) {
			return null;
		}else if(Utility.isNumeric(id, "선수ID")) {
			Player player = playerDao.getPlayer(Integer.valueOf(id));
			if(player == null) {
				System.out.printf("%s 번호의 선수는 없습니다.",id);
				return getPlayer();
			}
			return player;
		}
		return getPlayer();
	}
	protected String getName(Player player) {//바꿀 선수의 이름 입력
		final String playerName = "선수명";
		showMenu(playerName);
		System.out.printf("변경전:%s%n",player.getName());
		String name = this.getInputedString();//이름을 입력받음
		if(StringUtils.isEmpty(name)) {
			return null;
		}
		if(name.length() < 128) {
			return name;
		}
		return getName(player);
	}
	protected Team getTeam(Player player) {//바꿀 선수의 팀 ID 입력
		final String teamId = "팀ID";
		showMenu(teamId);
		System.out.printf("변경전:%d %s%n",player.getTeam().getTeam_id(), player.getTeam().getName());
		String id = this.getInputedString();
		if(StringUtils.isEmpty(id)) {
			return null;
		}
		if(Utility.isNumeric(id, "팀ID")) {
			Team team = teamDao.getTeam(Integer.valueOf(id));
			if(team == null) {
				System.out.printf("%s인 팀은 없습니다.%n",id);
				return getTeam(player);
			}
			return team;
		}
		return getTeam(player);
	}
	@Override
	public void show() {
		Player player = this.getPlayer();
		if(player == null) return;//메서드 종료
		String name = this.getName(player);
		if(StringUtils.isNotEmpty(name)) player.setName(name);
		Team team = this.getTeam(player);
		if(team != null) {
			player.setTeam(team);//새로운 팀으로 설정
			player.setTeam_id(team.getTeam_id());
		}
		this.playerDao.updatePlayer(player);//DB에서 update
		System.out.printf("%s인 선수를, 선수명 %s, 팀 %s로 변경합니다.%n",player.getPlayer_id(),player.getName(),player.getTeam().getName());
	}

}
