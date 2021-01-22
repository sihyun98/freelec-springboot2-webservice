package com.hackathon3.back_server.member.controller.dto.stock;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.hackathon3.back_server.member.domain.account.Account;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class StockSearchResponseDto {

	private String code;

	// ����
	private String stockName;
	
	// �򰡾�
	private int money;
	
    // ���ͷ�
	private double yield;
}
