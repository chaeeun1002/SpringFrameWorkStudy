package ui;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import dao.PlayerDao;
import model.Player;
import model.PlayerTeam;
import model.Team;

public class SelectPlayerUi extends AbstractUiTemplate {
	private PlayerDao playerDao;
	private UpdatePlayerUi updatePlayerUi;
	private DeletePlayerUi deletePlayerUi;
	public void setPlayerDao(PlayerDao playerDao) {
		this.playerDao = playerDao;
	}
	public void setUpdatePlayerUi(UpdatePlayerUi updatePlayerUi) {
		this.updatePlayerUi = updatePlayerUi;
	}
	public void setDeletePlayerUi(DeletePlayerUi deletePlayerUi) {
		this.deletePlayerUi = deletePlayerUi;
	}
	public void showHeader() {
		System.out.println("======================");
		System.out.println("선수 명단   선수 목록");
		System.out.println();
	}
	
	protected Integer getTeamId() {
		System.out.println("목록을 출력하려는 팀의 ID를 입력하고,"+"Enter를 누르세요");
		String teamId = this.getInputedString();
		if(StringUtils.isNotEmpty(teamId) && StringUtils.isNumeric(teamId)) {
			return Integer.valueOf(teamId);
		}
		return getTeamId();
	}
	
	protected void showPlayerList(List<PlayerTeam> playerList) {
		showHeader();
		if(!playerList.isEmpty()) {
			PlayerTeam playerTeam = playerList.get(0);
			Player player = new Player();
			player.setPlayer_id(playerTeam.getPlayer_id());
			player.setName(playerTeam.getPlayer_name());
			Team team = new Team();
			team.setTeam_id(playerTeam.getTeam_id());
			team.setName(playerTeam.getTeamName());
			player.setTeam(team);
			System.out.printf("팀 명 : %s%n ",player.getTeam().getName());
		}
		System.out.println("ID   이름");
		for(PlayerTeam player : playerList) {
			System.out.printf("%d %s%n",player.getPlayer_id(), player.getPlayer_name());
		}
	}

	@Override
	public void show() {
		showHeader();
		Integer teamId = getTeamId();
		showPlayerList(this.playerDao.getPlayerList(teamId));
		System.out.println("Enter를 누르세요.");
		this.getInputedString();
		super.show();
	}
	
	@Override
	protected void showMenu() {
		showHeader();
		System.out.println("1. 선수 정보 변경");
		System.out.println("2. 선수 삭제");
		System.out.println("3. 메뉴로 돌아가기");
		System.out.println();
		System.out.println("번호를 입력하고 Enter를 누르세요.");
	}
	@Override
	protected int getMaxMenuNumber() {
		// TODO Auto-generated method stub
		return 3;
	}
	@Override
	protected int getMinMenuNumber() {
		// TODO Auto-generated method stub
		return 1;
	}
	@Override
	protected void execute(int num) {
		switch(num) {
		case 1: updatePlayerUi.show(); break;
		case 2: deletePlayerUi.show(); break;
		default : return;
		}
	}

}
