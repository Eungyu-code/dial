package mine.dial.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class DialNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "dialnumber_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    private Integer number;
    private String name;
    private String information;

    @Embedded
    private Address address;

    // ID Generation method
    public DialNumber create(Member member, Integer number, String city, String street, String zipcode, String name, String information) {

        this.member = member;
        this.number = number;
        this.address = new Address(city, street, zipcode);
        this.name = name;
        this.information = information;

        return this;
    }
}
