package com.hackathon3.back_server.member.domain.account;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import lombok.*;

import com.hackathon3.back_server.member.domain.member.Member;
import com.hackathon3.back_server.member.domain.stock.Stock;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Account {

	@Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

	// 계좌 번호
	private String accountNumber;

	// 회원 ID
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
	
    // 보유 주식
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "account",cascade = CascadeType.ALL)
    private List<Stock> stocks = new ArrayList<>();
    
}
