package com.maple.originmapleapp.service;

import com.maple.originmapleapp.config.jwt.JwtToken;
import com.maple.originmapleapp.dto.MemberDto;
import com.maple.originmapleapp.entity.MemberEntity;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {
    MemberEntity signup(MemberDto memberDto);
}
