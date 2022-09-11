package com.kh.practice.token.controller;

import java.util.StringTokenizer;

public class TokenController {

	public TokenController() {

	}

	public String afterToken(String str) {
		StringTokenizer st = new StringTokenizer(str);
		String result = "";
		while (st.hasMoreTokens()) {
			result += st.nextToken();
		}
		return result;
	}

	public String firstCap(String input) {
		String result = (input.charAt(0) + "").toUpperCase();
		for (int i = 1; i < input.length(); i++) {
			result += input.charAt(i) + "";
		}
		return result;
	}

	public int findChar(String input, char one) {
		int count = 0;
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == one) {
				count++;
			}
		}
		return count;
	}

}
