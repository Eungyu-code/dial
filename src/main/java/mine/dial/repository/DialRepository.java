package mine.dial.repository;

import lombok.RequiredArgsConstructor;
import mine.dial.domain.DialNumber;
import mine.dial.domain.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class DialRepository {

    private EntityManager em;

    public void save(DialNumber dialNumber) {
        em.persist(dialNumber);
    }

    public DialNumber findByNumber(Integer number) {
        return em.createQuery("select d from DialNumber d where d.number = :number", DialNumber.class)
                .setParameter("number", number)
                .getSingleResult();
    }

    public List<DialNumber> findByName(String name) {
        return em.createQuery("select d from DialNumber d where d.name = :name", DialNumber.class)
                .setParameter("name", name)
                .getResultList();
    }

    public List<DialNumber> findByMember(Member member) {
        return em.createQuery("select d from DialNumber d where d.member = :member", DialNumber.class)
                .getResultList();
    }
}
