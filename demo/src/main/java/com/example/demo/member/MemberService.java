package com.example.demo.member;


import com.example.demo.member.dto.MemberCreateRequest;
import com.example.demo.member.dto.MemberUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    //@Transactional
    public Long createMember(MemberCreateRequest request) {
        // 로그인 아이디를 받아와서 존재하는지 체크
        Member existingMember = memberRepository.findByLoginId(request.getLoginId());
        if (existingMember != null) {
            throw new RuntimeException("이미 존재하는 로그인 아이디입니다." + request.getLoginId());
        }
        Member member = new Member(
                request.getLoginId(),
                request.getPwd(),
                request.getPhoneNumber(),
                request.getAddress()
        );
        memberRepository.save(member);
        return member.getId();
    }

    //@Transactional(readOnly = true)
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }
    //@Transactional(readOnly = ture)
    public Member getMemberById(Long id) {
        Member member = memberRepository.findById(id);
        if (member == null) {
            throw new RuntimeException("회원을 찾을 수 없습니다. ");
        }
        return member;
    }
    //@Transactional
    public void updateMember(Long id, MemberUpdateRequest request) {
        Member member = memberRepository.findById(id);
        if (member == null) {
            throw new RuntimeException("회원을 찾을 수 없습니다. ");
        }
        member.updateInfo(request.getPwd(), request.getPhoneNumber(), request.getAddress());
    }
    //@Transactional
    public void deleteMember(Long id) {
        Member member = memberRepository.findById(id);
        if (member == null) {
            throw new RuntimeException("회원을 찾을 수 없습니다. ");
        }
        memberRepository.deleteById(id);
    }
}
