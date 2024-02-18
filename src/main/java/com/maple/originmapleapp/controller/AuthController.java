package com.maple.originmapleapp.controller;


import com.maple.originmapleapp.dto.MemberDto;
import com.maple.originmapleapp.dto.response.DefaultResponse;
import com.maple.originmapleapp.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@CrossOrigin
@RequiredArgsConstructor
//@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    @GetMapping("/auth/login")
    public String login(){
        return "auth/login";
    }

    @GetMapping("/auth/signup")
    public String signup(){
        return "auth/signup";
    }

    @GetMapping("/auth/admin")
    public String admin(){
        return "admin/admin";
    }

    // 회원가입
    @PostMapping("/auth/signup.process")
    public ResponseEntity<DefaultResponse<Object>> signUp(@RequestBody MemberDto memberDto){
            try {
                authService.signup(memberDto);
                return new ResponseEntity<>(new DefaultResponse<>(1,"성공"),HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(new DefaultResponse<>(-1, e.getMessage() ),HttpStatus.BAD_REQUEST);
            }
        }
    }


