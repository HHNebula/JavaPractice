package com.information.controller; // 기능

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.information.model.Hospital;

public class HospitalInfoController {

	private List<Hospital> list = new ArrayList<Hospital>();

	public void inputData() {

		// hospitaldata.csv 파일 불러오기
		// 불러올 파일의 경로 만들기
		String path = HospitalInfoController.class.getResource("/").getPath();
		// /C:/workspace/java/Hospital/bin/ ("/") 의 뜻은 최상위 폴더 > ( bin folder )
		File data = new File(path + "/hospitaldata.csv"); // > 위 경로 안의 hospital.csv 파일

		// 문자열로 저장되어 있어 Reader를 이용하고 받아오는 속도를 향상시키기 위해 StirngBuffer 사용
		StringBuffer stringBuffer = new StringBuffer(); // > 문자열을 읽을 보조 스트림

		// hospitaldata.csv 파일을 BufferedReader 로 읽기
		// 각 데이터를 라인별로 받아서 StringBuffer 에 저장하여 관리
		// try () < 괄호안에 참조형 변수를 넣으면 finally 문장을 써서 닫을 필요가 없음
		try (BufferedReader bufferReader = new BufferedReader(new FileReader(data));) {

			// BufferReader 에서 한줄 씩 꺼내서 StringBuffer 에 한줄 씩 넣음
			String readedLine = "";
			while ((readedLine = bufferReader.readLine()) != null) {
				stringBuffer.append(readedLine + "\n"); // > 개행문자를 넣어서 한줄 씩 삽입
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		// 개행문자를 기준으로 한줄 씩 잘라서 String[] 자료형으로 반환
		String[] datas = stringBuffer.toString().split("\n");
		// split() 메서드는 Sting[] 형으로 return

		for (String str : datas) {
			// 1줄을 받아서 ", 를 @ 으로 변환 후 남은 " 를 삭제함
			String[] detail = str.replace("\",", "@").replace("\"", "").split("@");
			// 1줄의 Data 항목별로 다시 배열에 저장

			// 첫 라인은 모두 문자를 가지고 있으므로 정수형 doctorCount 멤버변수에 값을 저장할 경우 예외가 발생됨
			// 그 예외를 처리하기 위한 try / catch 문
			int count = 0;
			try { // 정수형으로 변환 실패 시
				count = Integer.parseInt(detail[16]);
			} catch (NumberFormatException e) {
				// 건너 뜀
			}

			list.add(new Hospital(detail[3], detail[1], detail[5], detail[7], detail[10], detail[11], detail[12],
					detail[13], count));

		}

		list.remove(0); // 첫번째 줄은 삭제함

	}

	public void printHospital() {

		System.out.printf("%-10s %-20s %-10s %-10s %-30s %-10s %-30s %-10s %-4s\n", "종류", "병원명", "시도명", "시군구명", "주소",
				"전화번호", "병원사이트", "개설일자", "총의사수");

		for (int i = 0; i < list.size(); i++) {
			System.out.printf("%-10s %-20s %-10s %-10s %-30s %-10s %-30s %-10s %-4s\n", list.get(i).getCategory(),
					list.get(i).getHospitalName(), list.get(i).getStateCode(), list.get(i).getCityCode(),
					list.get(i).getAddress(), list.get(i).getPhone(), list.get(i).getSite(), list.get(i).getOpenDate(),
					list.get(i).getDoctorCount());

		}

	}

}
