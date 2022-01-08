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

    public void create(String name, String password) {
        this.name = name;
        this.password = password;

    }

}
