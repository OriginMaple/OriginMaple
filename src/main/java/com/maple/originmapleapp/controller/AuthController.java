package com.maple.originmapleapp.controller;


import com.maple.originmapleapp.dto.MemberDto;
import com.maple.originmapleapp.dto.JwtToken;
import com.maple.originmapleapp.dto.response.DefaultResponse;
import com.maple.originmapleapp.entity.MemberEntity;
import com.maple.originmapleapp.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@CrossOrigin
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    public AuthController(AuthService authService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.authService = authService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    @GetMapping("/login")
    public String login(){
        return "auth/login";
    }

    @GetMapping("/signup")
    public String signup(){
        return "auth/signup";
    }

    @GetMapping("/admin")
    public String admin(){
        return "/";
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


