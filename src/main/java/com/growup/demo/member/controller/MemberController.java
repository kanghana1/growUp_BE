package com.growup.demo.member.controller;

import com.growup.demo.member.domain.Member;
import com.growup.demo.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.growup.demo.member.dto.MemberRequestDto.*;
import static com.growup.demo.member.dto.MemberResponseDto.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/members")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/signup")
    public Member signup(SignupRequestDto requestDto) {
        MemberSignupResponseDto member = memberService.save(requestDto);
        return null;
    }

}
