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

	// ȸ�� ID
	private String userId;
	
	// ����
    private int birth;

    // ������
    @Enumerated(EnumType.STRING)
    private Job job;
    
    // ���� ����
    @Enumerated(EnumType.STRING)
    private MyType mytype;
    
    // ����
    private int salary;
    
    // ���
    private int property;

    // ���� ����
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "member",cascade = CascadeType.ALL)
    private List<Account> accounts = new ArrayList<>();
}
