package ui;

import java.util.Scanner;

public abstract class AbstractUi {
	protected String getInputedString() {
		Scanner scan = new Scanner(System.in);
		return scan.nextLine();//입력된 문장을 리턴
	}
	abstract public void show();
}
