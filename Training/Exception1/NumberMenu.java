package com.kh.practice.numRange.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.kh.practice.numRange.controller.NumberController;
import com.kh.practice.numRange.exception.NumRangeException;

public class NumberMenu {

	public void menu() throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("정수 1 : ");
		int num1 = Integer.parseInt(br.readLine());
		System.out.print("정수 2 : ");
		int num2 = Integer.parseInt(br.readLine());

		try {
			boolean isTrue = new NumberController().checkDouble(num1, num2);
			System.out.println(num1 + "은(는) " + num2 + "의 배수인가 ? " + isTrue);
		} catch (NumRangeException e) {
			e.printStackTrace();
		} finally {
			br.close();
		}

	}

}
