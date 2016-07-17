package com.vaizn.utils;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class FormaterUtils {

	/**
	 * 格式化数字小数位
	 * @param number
	 * @param digits 要格式化的小数位数
	 */
	public static double doubleFormat(double number, int digits) {
		DecimalFormat df = (DecimalFormat)NumberFormat.getInstance();
		df.setMaximumFractionDigits(digits);
		return Double.parseDouble(df.format(number));
	}
}
