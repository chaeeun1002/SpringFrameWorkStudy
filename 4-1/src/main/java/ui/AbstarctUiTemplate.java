package ui;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

public abstract class AbstarctUiTemplate extends AbstractUi {
	abstract protected void showMenu();
	abstract protected int getMaxMenuNumber();
	abstract protected int getMinMenuNumber();
	protected boolean isValidNumber(String str) {
		if(StringUtils.isBlank(str)) return false;
		if(!StringUtils.isNumeric(str)) return false;
		int num = NumberUtils.toInt(str);
		if(getMinMenuNumber() <= num && num <= getMaxMenuNumber()) return true;
		return false;
	}
	abstract protected void execute(int number);
	@Override
	public void show() {
		showMenu();
		String inputedString = getInputedString();
		if(isValidNumber(inputedString)) {
			execute(NumberUtils.toInt(inputedString));
		}
	}

}
