package mine.dial.controller;

import lombok.RequiredArgsConstructor;
import mine.dial.domain.DialNumber;
import mine.dial.domain.Member;
import mine.dial.service.DialService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final DialService dialService;

    @GetMapping("/")
    public String home(Model model) {

        List<DialNumber> dialnumbers = dialService.findDialData();
        model.addAttribute("dialnumbers", dialnumbers);

        return "home";
    }
}
