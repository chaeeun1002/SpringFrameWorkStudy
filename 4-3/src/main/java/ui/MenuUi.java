package ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MenuUi extends AbstarctUiTemplate {
	private SelectTeamUi selectTeamUi;
	private InsertPlayerUi insertPlayerUi;
	private SelectPlayerUi selectPlayerUi;
	public void setSelectPlayerUi(SelectPlayerUi selectPlayerUi) {
		this.selectPlayerUi = selectPlayerUi;
	}

	public void setInsertPlayerUi(InsertPlayerUi insertPlayerUi) {
		this.insertPlayerUi = insertPlayerUi;
	}

	public void setSelectTeamUi(SelectTeamUi selectTeamUi) {
		this.selectTeamUi = selectTeamUi;
	}

	@Override
	protected void showMenu() {
		System.out.println("==========ORM 프로젝트==========");
		System.out.println("1. 종료");
		System.out.println("2. 팀 목록");
		System.out.println("3. 선수 등록");
		System.out.println("4. 상품 목록");
		System.out.println("5. 선수 목록");
		System.out.println();
		System.out.println("번호를 입력하고 Enter를 누르세요.");
	}

	@Override
	protected int getMaxMenuNumber() {
		return 5;
	}

	@Override
	protected int getMinMenuNumber() {
		return 1;
	}

	@Override
	protected void execute(int number) {
		switch(number) {
		case 1: System.out.println("시스템이 종료되었습니다.");
				System.exit(0);
				break;
		case 2: this.selectTeamUi.show();
				break;	
		case 3: this.insertPlayerUi.show();
				break;
		case 5: this.selectPlayerUi.show();
				break;
		}
	}
	public static void main(String[] args) {  
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		MenuUi menuUi = (MenuUi)ctx.getBean("menuUi");
		while(true) {
			menuUi.show();
		}
	}

}
