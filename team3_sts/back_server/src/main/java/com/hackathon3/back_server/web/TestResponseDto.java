package com.hackathon3.back_server.web;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TestResponseDto {

	private String code;
	private String message;
	
//	@Builder
//	public TestResponseDto(String code, String message) {
//		this.code = code;
//		this.message = message;
//	}

}
