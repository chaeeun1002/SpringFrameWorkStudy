package ui;

import java.util.Scanner;

public abstract class AbstractUi {
		abstract public void show();
		protected String getInputedString() {
			Scanner scan = new Scanner(System.in);
			String input = null;
			try {
				input = scan.nextLine();
			}catch(Exception e) {
				System.out.println("콘솔에서 입력을"+"받지 못했습니다.");
			}
			return input;
		}
}
