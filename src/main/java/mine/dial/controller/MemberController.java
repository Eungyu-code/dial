package mine.dial.controller;

import lombok.RequiredArgsConstructor;
import mine.dial.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/members/login")
    public String loginForm(Model model) {

        model.addAttribute("memberForm", new MemberForm());
        return "members/loginForm";
    }

}
