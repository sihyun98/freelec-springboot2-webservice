package com.hackathon3.back_server.apis;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.ByteArrayOutputStream;



import org.json.JSONObject;

//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;

import com.hackathon3.back_server.web.TestResponseDto;

@RestController
public class StocksController {
	
	@GetMapping("/api/stocks/kospi/lists")
	public String getstocklist() {
		
		String result = "";
		String s = "";
		try {
			String marketcode = "kospi";
			String apikey = "l7xxc460c2c4fca442ebaef0e2d8977dc043"; // ½ÃÇö apikey
			
			String addr = "https://sandbox-apigw.koscom.co.kr/v2/market/stocks/"
					+ marketcode
					+ "/lists"
					+ "?apikey="
					+ apikey;
			
			URL url = new URL(addr);	
			
			HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();
			urlconnection.setRequestMethod("GET");
			
			BufferedReader br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(), "UTF-8"));
			
			String returnLine;
			while((returnLine = br.readLine()) != null) {
				result += returnLine;
			}
			urlconnection.disconnect();
			
//			JSONParser jsonParse = new JSONParser();
//			JSONObject obj = (JSONObject)jsonParse.parse(jsonString);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return result;
	}

}
