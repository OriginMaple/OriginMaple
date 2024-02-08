package com.maple.originmapleapp.service.impl;


import com.maple.originmapleapp.config.jwt.JwtToken;
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

    @Transactional
    @Override
    public JwtToken login(MemberDto memberDto) {

        MemberEntity memberEntity = memberDto.toEntity();
        String memnerId =memberEntity.getMemberId();
        String memberPw = memberEntity.getMemberPw();

        // 1. username + password 를 기반으로 Authentication 객체 생성
        // 이때 authentication 은 인증 여부를 확인하는 authenticated 값이 false
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                memnerId, memberPw
//                memberName,memberPw
        );

        // 2. 실제 검증. authenticate() 메서드를 통해 요청된 Member 에 대한 검증 진행
        // authenticate 메서드가 실행될 때 CustomUserDetailsService 에서 만든 loadUserByUsername 메서드 실행
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        System.out.println(authentication);
        return null;
//        return jwtTokenProvider.generateToken(authentication);
    }

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
