package com.maple.originmapleapp.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 기본반환 타입으로 사용할 수 있는 반환 Dto
@Data
@NoArgsConstructor (access = AccessLevel.PROTECTED)

public class DefaultResponse<T> {
    private int code; // 1(성공), -1(실패)
    private String message;
    private T data;

    public DefaultResponse(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public DefaultResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
