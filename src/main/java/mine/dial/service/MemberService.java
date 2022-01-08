package mine.dial.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mine.dial.domain.Member;
import mine.dial.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class MemberService {

    private final MemberRepository memberRepository;

    public void join(Member member) {

        //validateDuplicateMember(member);
        memberRepository.save(member);

    }

    @Transactional(readOnly = true)
    private void validateDuplicateMember(Member member) {

        List<Member> members = memberRepository.findByNameAll(member.getName());
        if (!members.isEmpty()) throw new IllegalStateException("이미 존재하는 회원입니다");
    }

    public Member login(String name, String password) throws Exception {

        try {
            if (memberRepository.findByName(name) == null) throw new NullPointerException();

            Member findMember = memberRepository.findByName(name);
            if (findMember.getPassword().equals(password))
                throw new IllegalStateException("비밀번호가 잘못되었습니다.");
        }
        catch (NullPointerException e) {
            log.error("존재하지 않는 회원입니다");

        }
        catch (IllegalStateException e) {
            log.error("비밀번호가 잘못되었습니다");

        }

        return memberRepository.findByName(name);
    }

    public Member findOne(String name) {
        return memberRepository.findByName(name);
    }
}
