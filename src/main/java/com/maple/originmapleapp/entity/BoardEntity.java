package com.maple.originmapleapp.entity;

import com.maple.originmapleapp.dto.BoardDto;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Getter
@Builder
@Table(name = "board") // 테이블 매핑
@NoArgsConstructor ( access = AccessLevel.PROTECTED)// 기본생성자 자동 생성 및 접근 제한
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // 기본키 생성을 DB에 위임
    int boardIndex;
    @Column(nullable = false) // not null 조건
    String boardGrpIndex;
    @Column(nullable = false)
    String boardTitle;
    @Column(nullable = false)
    String boardContent;
    @Column(nullable = false)
    String boardMember;
    int boardViewCount;
    int boardReport;
    int boardLike;
    @Column(nullable = false)
    Date boardDate;
    Date boardModDate;

    // @Builder 를 사용하기위한 생성자
    public BoardEntity(int boardIndex, String boardGrpIndex, String boardTitle, String boardContent, String boardMember, int boardViewCount, int boardReport, int boardLike, Date boardDate, Date boardModDate) {
        this.boardIndex = boardIndex;
        this.boardGrpIndex = boardGrpIndex;
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
        this.boardMember = boardMember;
        this.boardViewCount = boardViewCount;
        this.boardReport = boardReport;
        this.boardLike = boardLike;
        this.boardDate = boardDate;
        this.boardModDate = boardModDate;
    }




}
