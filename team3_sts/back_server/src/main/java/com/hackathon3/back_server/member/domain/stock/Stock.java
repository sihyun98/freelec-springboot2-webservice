package com.hackathon3.back_server.member.domain.stock;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.hackathon3.back_server.member.domain.account.Account;
import com.hackathon3.back_server.member.domain.member.Member;

public class Stock {
	
	@Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

	// ����
	private String stockName;

	// ���� ID
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;
	
	// �򰡾�
	private int money;
	
    // ���ͷ�
	private double yield;
}
