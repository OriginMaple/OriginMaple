package com.maple.originmapleapp.service;

import com.maple.originmapleapp.entity.MemberEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface AuthService {
    Optional<MemberEntity> login(String meberId);

    MemberEntity signup(MemberEntity memberEntity);
}
