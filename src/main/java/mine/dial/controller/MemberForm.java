package mine.dial.controller;

import lombok.Getter;

import javax.validation.constraints.NotEmpty;

@Getter
public class MemberForm {

    @NotEmpty(message = "회원 이름을 입력하지 않았습니다")
    private String name;

    @NotEmpty(message = "비밀번호를 입력하지 않았습니다")
    private String password;
}
