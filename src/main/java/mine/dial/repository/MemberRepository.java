package mine.dial.repository;

import lombok.RequiredArgsConstructor;
import mine.dial.domain.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    public void save(Member member) {
        em.persist(member);
    }

    public Member findByName(String name) {
        return em.createQuery("select d from DialNumber d where d.name = :name", Member.class)
                .getSingleResult();
    }

}
