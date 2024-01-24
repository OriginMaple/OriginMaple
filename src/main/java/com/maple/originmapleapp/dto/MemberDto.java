package com.maple.originmapleapp.dto;

import com.maple.originmapleapp.entity.BoardEntity;
import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor (access = AccessLevel.PROTECTED)// 파라미터 없는 생성자 자동생성
public class MemberDto {

    int memberId;
    String memberName;
    String memberRole;
    String memberPw;
    String memberEmail;
    String memberIsBlack;
    Date memberDate;
    Date memberBlackDate;
    String memberProviderType;

}
