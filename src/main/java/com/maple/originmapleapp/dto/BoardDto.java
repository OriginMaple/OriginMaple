package com.maple.originmapleapp.dto;

import com.maple.originmapleapp.entity.BoardEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor (access = AccessLevel.PROTECTED)
public class BoardDto {
    int boardIndex;
    String boardGrpIndex;
    String boardTitle;
    String boardContent;
    String boardMember;
    int boardViewCount;
    int boardReport;
    int boardLike;
    Date boardDate;
    Date boardModDate;

    public BoardEntity toEntity(BoardDto boardDto){
        return BoardEntity.builder()
                .boardIndex(boardIndex)
                .boardGrpIndex(boardGrpIndex)
                .boardTitle(boardTitle)
                .boardContent(boardContent)
                .boardMember(boardMember)
                .boardViewCount(boardViewCount)
                .boardReport(boardReport)
                .boardLike(boardLike)
                .boardDate(boardDate)
                .boardModDate(boardModDate)
                .build();
    }
}
