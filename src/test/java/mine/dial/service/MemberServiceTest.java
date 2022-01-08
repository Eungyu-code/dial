package mine.dial.service;

import mine.dial.domain.Member;
import mine.dial.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired
    EntityManager em;

    @Autowired
    MemberService memberService;

    @AfterEach
    void aftereach() {
        em.clear();
    }

    @Test
    void 회원가입() {

        //given
        Member member = new Member();
        member.create("이은규", "1234");

        memberService.join(member);

        //when
        Member findMember = memberService.findOne("이은규");

        //then
        Assertions.assertThat(findMember).isEqualTo(member);
    }

    @Test
    void 로그인() throws Exception {

        //given
        Member member = new Member();
        member.create("이은규", "1234");

        memberService.join(member);

        //when
        Member findMember = memberService.login("이은규", "1234");

        //then
        Assertions.assertThat(findMember).isEqualTo(member);
    }

}