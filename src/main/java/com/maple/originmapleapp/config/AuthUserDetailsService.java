package com.maple.originmapleapp.config;

import com.maple.originmapleapp.dao.AuthDao;
import com.maple.originmapleapp.dto.MemberDto;
import com.maple.originmapleapp.entity.MemberEntity;
import com.maple.originmapleapp.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AuthUserDetailsService implements UserDetailsService {
    // 로그인 프로세스가 실행시 AuthUserDetailsService 가 낚아챔
    @Autowired
    AuthService authService;

    @Override
    public UserDetails loadUserByUsername(String memberId) throws UsernameNotFoundException{
        Optional<MemberEntity> findOne = authService.login(memberId);

        MemberEntity memberEntity = findOne.orElseThrow(() -> new UsernameNotFoundException("존재하지 않는 회원입니다."));

        return User.builder()
                .username(memberEntity.getMemberEmail())
                .password(memberEntity.getMemberPw())
                .roles(memberEntity.getMemberRole())
                .build();
    }
}
