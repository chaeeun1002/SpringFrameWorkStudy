package ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MenuUi extends AbstractUiTemplate {
	private SelectTeamUi selectTeamUi;
	private InsertPlayerUi insertPlayerUi;
	public void setInsertPlayerUi(InsertPlayerUi insertPlayerUi) {
		this.insertPlayerUi = insertPlayerUi;
	}
	public void setSelectTeamUi(SelectTeamUi selectTeamUi) {
		this.selectTeamUi = selectTeamUi;
	}
	public static void main(String[] args) {
		//환경설정파일에서 MenuUi를 불러온다.
		//show()메서드를 호출한다.
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		MenuUi menu = (MenuUi)ctx.getBean("menuUi");
		while(true) {
			menu.show();
		}
	}
	@Override
	protected void showMenu() {
		System.out.println("===================="
				+ "");
		System.out.println();
		System.out.println(" 1. 종료");
		System.out.println(" 2. 팀목록 보기");
		System.out.println(" 3. 멤버 추가");
		System.out.println("");
		System.out.println("번호를 입력한 후 "+"Enter를 누르세요");
	}

	@Override
	protected int getMaxMenuNumber() {
		return 3;
	}

	@Override
	protected int getMinMenuNumber() {
		return 1;
	}

	@Override
	protected void execute(int num) {
		switch(num) {
		case 1: System.out.println("종료되었습니다.");
				System.exit(0);//강제종료
				break;
		case 2: selectTeamUi.show();
				break;
		case 3: insertPlayerUi.show();
				break;
		}
	}

}
