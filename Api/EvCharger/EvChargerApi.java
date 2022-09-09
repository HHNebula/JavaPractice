package data.evcharger.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import data.evcharger.vo.EvChargerInfo;

public class EvChargerApi {

	public void run() {

		/* Service Encoding Key */
		String serviceKey = "ServiceKey";

		/* Request Parameter */
		int pageNo = 1; /* 페이지 번호 */
		int numOfRows = 10; /* 한 페이지 결과 수 (최소 10, 최대 9999) */
		int zcode = 11; /* 시도 코드 (행정구역코드 앞 2자리) */

		/* 1단계 Request URL 생성 */
		StringBuilder urlBuilder = new StringBuilder(
				"http://apis.data.go.kr/B552584/EvCharger/getChargerInfo"); /* URL */

		try { // Request URL 에 Request Parameter 추가
			urlBuilder.append("?serviceKey=" + serviceKey);
			urlBuilder.append("&pageNo=" + pageNo);
			urlBuilder.append("&numOfRows=" + numOfRows);
			urlBuilder.append("&zcode=" + zcode);
			System.out.println(urlBuilder.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

		/* 1단게 종료 */

		// ====================================================================== //

		/* 2단계 위 urlBuilder 로 connection */
		URL url = null;
		HttpURLConnection conn = null;

		try {
			url = new URL(urlBuilder.toString()); // URL 객체 생성
			conn = (HttpURLConnection) url.openConnection(); // URLConnection 객체를 HttpURLConnection 객체로 캐스팅
			conn.setRequestMethod("GET"); // HTTP URL Request Method - 기본 값은 GET
			conn.setRequestProperty("Content-type", "application/json"); // Key - Value - 일반 요청 속성
			System.out.println("Response code: " + conn.getResponseCode()); // 서버에서 보낸 HTTP 싱태 코드를 반환
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (ProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		/* 2단게 종료 */

		// ====================================================================== //

		/* 3단계 요청에 대한 응답 처리 */
		BufferedReader rd = null;
		try {

			/* 응답 코드가 정상인 경우 */
			if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
				/* 결과를 받아들일 스트림 */
				rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			} else {
				/* 오류를 받아들일 스트림 */
				rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
			}

			Document doc = parseXML(conn.getInputStream()); // HttpURLConnection 객체를 Document화
			NodeList descNodes = doc.getElementsByTagName("item"); // item Tag 단위 Node 저장
			List<EvChargerInfo> list = new ArrayList<EvChargerInfo>(); // 데이터담을 객체 컬렉션 선언

			// 받아온 item Tag 블럭 단위의 데이터 수량 만큼 반복
			for (int i = 0; i < descNodes.getLength(); i++) {

				EvChargerInfo data = new EvChargerInfo(); // 객체 생성
				Node item = descNodes.item(i); // 노드 리스트 내 i 번째 노드를 참조

				// 첫번째 item 으로 초기화 // item != null 일 때 반복 // n 에 다음 노드 저장
				for (Node n = item.getFirstChild(); n != null; n = n.getNextSibling()) {
					String nodeName = n.getNodeName(); // <statNm>
					String nodeText = n.getTextContent(); // 종묘 공영주차장

					switch (nodeName) {
					case "statNm":
						data.setStatNm(nodeText);
						break;
					case "statId":
						data.setStatId(nodeText);
						break;
					case "chgerId":
						data.setChgerId(nodeText);
						break;
					case "chgerType":
						data.setChgerType(nodeText);
						break;
					case "addr":
						data.setAddr(nodeText);
						break;
					case "lat":
						data.setLat(nodeText);
						break;
					case "lng":
						data.setLng(nodeText);
						break;
					case "useTime":
						data.setUseTime(nodeText);
						break;
					case "busiId":
						data.setBusiId(nodeText);
						break;
					case "busiNm":
						data.setBusiNm(nodeText);
						break;
					case "busiCall":
						data.setBusiCall(nodeText);
						break;
					case "stat":
						data.setStat(nodeText);
						break;
					case "statUpdDt":
						data.setStatUpdDt(nodeText);
						break;
					case "powerType":
						data.setPowerType(nodeText);
						break;
					case "zcode":
						data.setZcode(nodeText);
						break;
					case "parkingFree":
						data.setParkingFree(nodeText);
						break;
					case "note":
						data.setNote(nodeText);
						break;
					case "lastTsdt":
						data.setLastTsdt(nodeText);
						break;
					case "lastTedt":
						data.setLastTedt(nodeText);
						break;
					case "nowTsdt":
						data.setNowTsdt(nodeText);
						break;
					case "output":
						data.setOutput(nodeText);
						break;
					case "method":
						data.setMethod(nodeText);
						break;
					case "zscode":
						data.setZscode(nodeText);
						break;
					case "kind":
						data.setKind(nodeText);
						break;
					case "kindDetail":
						data.setKindDetail(nodeText);
						break;
					case "limitYn":
						data.setLimitYn(nodeText);
						break;
					case "delYn":
						data.setDelYn(nodeText);
						break;
					case "delDetail":
						data.setDelDetail(nodeText);
						break;
					}

					list.add(data);

				}

			}

			// Object to String
			for (EvChargerInfo d : list) {
				System.out.println(d);
			}

		} catch (ProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally { // 자원 반환

			try {
				rd.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			conn.disconnect();
		}

	}

	/* XML Data 변환 Method */
	private Document parseXML(InputStream stream) {
		DocumentBuilderFactory objDocumentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder objDocumentBuilder = null;
		Document result = null;
		try {
			objDocumentBuilder = objDocumentBuilderFactory.newDocumentBuilder();
			result = objDocumentBuilder.parse(stream);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) { // Simple API for XML
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;
	}

}
