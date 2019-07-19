package ui;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

public abstract class AbstractUiTemplate extends AbstractUi {
	abstract protected void showMenu();

	abstract protected int getMaxMenuNumber();

	abstract protected int getMinMenuNumber();

	abstract protected void execute(int num);

	protected boolean isValidNumber(String str) {
		if (StringUtils.isBlank(str)) {// 공란인지 검사
			return false;
		}
		if (!StringUtils.isNumeric(str)) {// 숫자형태의 문자열인지 검사
			return false;
		}
		int num = NumberUtils.toInt(str);// Integer.parseInt 와 같은 역할
		if (getMinMenuNumber() <= num && num <= getMaxMenuNumber()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void show() {
		showMenu();
		String inputedString = getInputedString();
		if (isValidNumber(inputedString)) {// 사용자가 입력한 데이터가 유효한 데이터인지 판단
			execute(NumberUtils.toInt(inputedString));// return값이 true일때 메뉴 동작
		}

	}
}
