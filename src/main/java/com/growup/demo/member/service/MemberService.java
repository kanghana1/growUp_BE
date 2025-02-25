package com.growup.demo.member.service;

import com.growup.demo.member.dao.MemberRepository;
import com.growup.demo.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.growup.demo.member.dto.MemberRequestDto.*;
import static com.growup.demo.member.dto.MemberResponseDto.*;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository repository;

    public MemberSignupResponseDto save(SignupRequestDto requestDto) {
        if (isExistEmail(requestDto.getEmail())) {
            throw new RuntimeException();
        }

        Member member = Member.builder()
                .memberId(requestDto.getMemberId())
                .memberName(requestDto.getName())
                .email(requestDto.getEmail())
                .password(requestDto.getPassword())
                .isCouple(false)
                .build();

        repository.save(member);
        return MemberSignupResponseDto.builder()
                .idx(member.getIdx())
                .memberName(member.getMemberName())
                .isSuccess(true)
                .build();
    }

    public MemberUpdateNameResponseDto updateMemberName(UpdateNameRequestDto requestDto) {
        Member member = findBymemberId(requestDto.getMemberId());

        member.updateMemberName(requestDto.getMemberNewName());
        return MemberUpdateNameResponseDto.builder()
                .idx(member.getIdx())
                .memberName(member.getMemberName())
                .isSuccess(true)
                .build();
    }

    public MemberUpdateInfoResponseDto updatememberInfo(UpdateInfoRequestDto requestDto) {
        Member member = findBymemberId(requestDto.getMemberId());
        member.updateMemberName(requestDto.getMemberNewName());
        member.updatePassword(requestDto.getMemberNewPw());
        member.updateEmail(requestDto.getMemberNewEmail());
        return MemberUpdateInfoResponseDto.builder()
                .idx(member.getIdx())
                .memberName(member.getMemberName())
                .memberPassword(member.getPassword())
                .memberEmail(member.getEmail())
                .isSuccess(true)
                .build();
    }

    public MemberInfoResponseDto getmemberInfo(String memberId) {
        Member member = findBymemberId(memberId);
        return MemberInfoResponseDto.builder()
                .idx(member.getIdx())
                .memberId(memberId)
                .memberName(member.getMemberName())
                .memberEmail(member.getEmail())
                .isCouple(member.getIsCouple())
                .build();
    }

    public MemberDeleteResponseDto deletemember(String memberId) {
        repository.deleteMemberByMemberId(memberId);
        return MemberDeleteResponseDto.builder()
                .isSuccess(true)
                .build();
    }
    private boolean isExistEmail(String email) {
        return repository.existsByEmail(email);
    }

    private Member findBymemberId(String memberId) {
        return repository.findByMemberId(memberId)
                .orElseThrow(() -> new RuntimeException());
    }
}
