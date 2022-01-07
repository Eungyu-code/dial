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

    private final EntityManager em;

    public void save(DialNumber dialNumber) {
        em.persist(dialNumber);
    }

    public DialNumber findById(Long id) {
        return em.find(DialNumber.class, id);
    }

    public DialNumber findByNumber(Integer number) {
        return em.createQuery("select d from DialNumber d where d.number = :number", DialNumber.class)
                .setParameter("number", number)
                .getSingleResult();
    }

    public List<DialNumber> findByNumberAll(String number) {
        return em.createQuery("select d from DialNumber d where d.number = :number", DialNumber.class)
                .setParameter("number", number)
                .getResultList();
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

    public List<DialNumber> findAll() {
        return em.createQuery("select d from DialNumber d", DialNumber.class)
                .getResultList();
    }
}
