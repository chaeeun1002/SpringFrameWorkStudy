package ui;

import java.util.List;

import dao.PlayerDao;
import model.Player;

public class SelectPlayerUi extends AbstarctUiTemplate {
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

	@Override
	protected void showMenu() {
		System.out.println("==========ORM 프로젝트==========");
		System.out.println("1. 선수 갱신");
		System.out.println("2. 선수 삭제");
		System.out.println("3. 돌아가기");
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
	protected void execute(int number) {
		switch(number) {
		case 1: updatePlayerUi.show();
				break;
		case 2: deletePlayerUi.show();
				break;
		default : return;
		}
	}
	
	protected Integer getTeamId() {
		System.out.println("목록을 표시하려는 팀번호를 입력하고"+"Enter를 누르세요.");
		String teamId = this.getInputedString();
		return Integer.valueOf(teamId);
	}
	protected void showPlayerList(List<Player> list) {
		System.out.println("=============================");
		System.out.println();
		if(! list.isEmpty()) {
			Player player = list.get(0);
			System.out.printf("팀명:%s\n",player.getTeam().getName());
		}
		System.out.println("ID              선수");
		for(Player player : list) {//확장된 for문
			System.out.printf("%d %s\n",player.getPlayer_id(),player.getName());
		}
	}
	public void show() {
		Integer teamId = getTeamId();
		showPlayerList(this.playerDao.getPlayerList(teamId));
		System.out.println("Enter를 누르세요.");
		this.getInputedString();
		super.show();
	}

}
