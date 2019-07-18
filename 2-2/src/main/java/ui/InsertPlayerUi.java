package ui;

import org.apache.commons.lang3.StringUtils;

import dao.PlayerDao;
import dao.TeamDao;
import model.Player;
import model.Team;

public class InsertPlayerUi extends AbstractUi {
	// 멤버 등록, 멤버의 팀을 선택
	private TeamDao teamDao;
	private PlayerDao playerDao;

	public void setTeamDao(TeamDao teamDao) {
		this.teamDao = teamDao;
	}

	public void setPlayerDao(PlayerDao playerDao) {
		this.playerDao = playerDao;
	}

	@Override
	public void show() {
		final String playerName = "선수명";
		showMenu(playerName);
		String name = this.getInputedString();
		// 멤버이름이 유효한지 검사
		if (StringUtils.isEmpty(name)) {
			return;// 이름이 공백이면 메서드 종료
		} else if (Utility.isSmallLength(name, "멤버이름", 50)) {
			Player player = new Player();
			player.setName(name);
			// 팀선택 메서드 호출
			showTeamField(player);
		} else {
			show();
		}
	}

	protected void showTeamField(Player p) {
		showMenu("팀번호");
		String id = this.getInputedString();
		if (StringUtils.isEmpty(id)) {
			return;// 메서드 종료
		} else if (Utility.isNumeric(id, "팀번호")) {
			Team team = this.teamDao.getTeam(Integer.valueOf(id));
			if (team == null) {
				System.out.printf("입력한 %s인 " + "팀은 존재하지 않습니다.", id);
				showTeamField(p);// 현 메서드 다시 호출
			} else {
				p.setTeam_id(Integer.valueOf(id));
				// 멤버번호 설정 메서드 호출
				showPlayerId(p, team);
			}
		}
	}

	protected void showPlayerId(Player p, Team team) {
		final String playerId = "선수ID";
		showMenu(playerId);
		String id = this.getInputedString();
		if (StringUtils.isEmpty(id)) {
			return;
		} else if (Utility.isNumeric(id, "멤버 번호")) {
			p.setPlayer_id(Integer.valueOf(id));
			playerDao.insertPlayer(p);
			System.out.printf("팀 %s에 %s 멤버를 " + "등록했습니다.", team.getName(), p.getName());
		}
	}

	protected void showMenu(String str) {
		System.out.println("==============================");
		System.out.printf("%s 를 입력하고 " + "Enter를 누르세요.\n", str);
		System.out.println("아무것도 입력하지 않고" + "Enter를 누르면 메뉴로 돌아갑니다.");
	}
}
