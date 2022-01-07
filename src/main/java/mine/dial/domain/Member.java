package mine.dial.domain;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Slf4j
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @OneToMany(mappedBy = "member")
    private List<DialNumber> dialNumbers = new ArrayList<>();

    private String name;
    private String password;


    public static String getSHA512(String input) throws Exception {

        String toReturn = null;
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-512");
            digest.update(input.getBytes("UTF-8"));
            toReturn = String.format("%0128x", new BigInteger(1, digest.digest()));
        } catch (Exception e) {
            log.error("비밀번호 복호화 오류");
        }

        return toReturn;
    }

    public Member create(String name, String password) throws Exception {
        this.name = name;
        this.password = getSHA512(password);

        return this;
    }

}
