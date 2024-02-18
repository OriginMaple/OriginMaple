package com.maple.originmapleapp.service.impl;


import com.maple.originmapleapp.dto.MemberDto;
import com.maple.originmapleapp.entity.MemberEntity;
import com.maple.originmapleapp.repository.AuthRepository;
import com.maple.originmapleapp.service.AuthService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthRepository authRepository;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;



    public MemberEntity signup (MemberDto memberDto){
        Boolean isExist = authRepository.existsBymemberEmail(memberDto.getMemberEmail());

        if(isExist){
            return null;
        }

        memberDto.setMemberPw(bCryptPasswordEncoder.encode(memberDto.getMemberPw()));

        MemberEntity toEntity = memberDto.toEntity();

        return authRepository.save(toEntity);
    }
}
