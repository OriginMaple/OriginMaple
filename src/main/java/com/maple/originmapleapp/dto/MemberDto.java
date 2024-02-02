package com.maple.originmapleapp.dto;

import com.maple.originmapleapp.entity.BoardEntity;
import com.maple.originmapleapp.entity.MemberEntity;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor (access = AccessLevel.PROTECTED)// 파라미터 없는 생성자 자동생성
public class MemberDto {
    int memberIndex;
    String memberId;
    String memberName;
    String memberRole;
    String memberPw;
    String memberEmail;
    String memberIsBlack;
//    Date memberDate;
//    Date memberModDate;
//    Date memberBlackDate;
    String memberProviderType;


    public MemberEntity toEntity(){
        return MemberEntity.builder()
                .memberIndex(memberIndex)
                .memberId(memberId)
                .memberName(memberName)
                .memberRole(memberRole)
                .memberPw(memberPw)
                .memberEmail(memberEmail)
                .memberIsBlack(memberIsBlack)
//                .memberDate(memberDate)
//                .memberModDate(memberModDate)
//                .memberBlackDate(memberBlackDate)
                .memberProviderType(memberProviderType)
                .build();
    }
}
