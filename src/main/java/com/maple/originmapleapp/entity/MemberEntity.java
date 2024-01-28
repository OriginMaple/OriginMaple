package com.maple.originmapleapp.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@Table(name = "member") // 테이블 매핑
@NoArgsConstructor( access = AccessLevel.PROTECTED)// 기본생성자 자동 생성 및 접근 제한
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키 생성을 DB에 위임
    private int memberIndex;
    private String memberId;
    @Column(nullable = false) // not null 조건
    private String memberName;
    private String memberRole;
    @Column(nullable = false)
    private String memberPw;
    @Column(nullable = false ,unique = true) // not null 조건 unique 옵션
    private String memberEmail;
    private String memberIsBlack;
    @CreationTimestamp
    private LocalDateTime memberDate;
    @UpdateTimestamp
    private LocalDateTime memberModDate;
    @UpdateTimestamp
    private LocalDateTime memberBlackDate;
    @Column(nullable = false)
    private String memberProviderType;

    public MemberEntity(int memberIndex, String memberId, String memberName, String memberRole, String memberPw, String memberEmail, String memberIsBlack, LocalDateTime memberDate, LocalDateTime memberModDate, LocalDateTime memberBlackDate, String memberProviderType) {
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

    @PrePersist
    public void prePersist() {
        LocalDateTime now = LocalDateTime.now();
        this.memberDate = now;
        this.memberModDate = now;
        this.memberBlackDate = now;

        // 해당 내용은 추후 수정 필요
        if(memberRole == null){
            this.memberRole = "N";
        }
        // 해당 내용은 추후 수정 필요
        if(memberProviderType == null){
            this.memberProviderType = "N";
        }

    }

}
