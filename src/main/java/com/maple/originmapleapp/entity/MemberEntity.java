package com.maple.originmapleapp.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Getter
@Builder
@Table(name = "member") // 테이블 매핑
@NoArgsConstructor( access = AccessLevel.PROTECTED)// 기본생성자 자동 생성 및 접근 제한
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키 생성을 DB에 위임
    int memberIndex;
    String memberId;
    @Column(nullable = false) // not null 조건
    String memberName;
    @Column(nullable = false)
    String memberRole;
    @Column(nullable = false)
    String memberPw;
    @Column(nullable = false ,unique = true) // not null 조건 unique 옵션
    String memberEmail;
    @Column(nullable = false)
    @ColumnDefault("N") // default 옵션
    String memberIsBlack;
    @CreationTimestamp
    Date memberDate;
    @UpdateTimestamp
    Date memberModDate;
    @UpdateTimestamp
    Date memberBlackDate;
    @Column(nullable = false)
    String memberProviderType;

    public MemberEntity(int memberIndex, String memberId, String memberName, String memberRole, String memberPw, String memberEmail, String memberIsBlack, Date memberDate, Date memberModDate, Date memberBlackDate, String memberProviderType) {
        this.memberIndex = memberIndex;
        this.memberId = memberId;
        this.memberName = memberName;
        this.memberRole = memberRole;
        this.memberPw = memberPw;
        this.memberEmail = memberEmail;
        this.memberIsBlack = memberIsBlack;
        this.memberDate = memberDate;
        this.memberModDate = memberModDate;
        this.memberBlackDate = memberBlackDate;
        this.memberProviderType = memberProviderType;
    }
}
