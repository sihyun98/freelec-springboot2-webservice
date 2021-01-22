package com.hackathon3.back_server.member.domain.member;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import lombok.*;

import com.hackathon3.back_server.member.domain.Job;
import com.hackathon3.back_server.member.domain.MyType;
import com.hackathon3.back_server.member.domain.account.Account;


@Getter
@Setter
@NoArgsConstructor
public class Member {
	
	@Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

	// 회원 ID
	private String userId;
	
	// 생년
    private int birth;

    // 직업군
    @Enumerated(EnumType.STRING)
    private Job job;
    
    // 투자 성향
    @Enumerated(EnumType.STRING)
    private MyType mytype;
    
    // 연봉
    private int salary;
    
    // 재산
    private int property;

    // 보유 계좌
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "member",cascade = CascadeType.ALL)
    private List<Account> accounts = new ArrayList<>();
}
