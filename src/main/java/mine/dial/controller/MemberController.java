package mine.dial.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mine.dial.domain.Member;
import mine.dial.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/members/login")
    public String loginForm(Model model) {

        model.addAttribute("memberForm", new MemberForm());
        return "members/loginForm";
    }

    @PostMapping("/members/login")
    public String login(@Valid MemberForm memberForm, BindingResult result, HttpSession session) {

        if (result.hasErrors()) return "members/loginForm";


        return "redirect:/";
    }

    @GetMapping("/members/new")
    public String addForm(Model model) {
        model.addAttribute("memberForm", new MemberForm());
        return "members/addForm";
    }

    @PostMapping("/members/new")
    public String add(@Valid MemberForm memberForm, BindingResult result) {

        if (result.hasErrors()) return "members/addForm";

        Member member = new Member();
        member.create(memberForm.getName(), memberForm.getPassword());

        memberService.join(member);
        return "redirect:/";
    }
}
