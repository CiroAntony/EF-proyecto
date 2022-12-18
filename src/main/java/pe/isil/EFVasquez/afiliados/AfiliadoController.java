package pe.isil.EFVasquez.afiliados;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.isil.EFVasquez.shared.BasicResponse;

@Controller
@RequestMapping("")
public class AfiliadoController {
    @Autowired
    private AfiliadoService afiliadoService;

    @GetMapping({"", "/", "/login"})
    public String login() {
        return "afiliados/login";
    }

    @GetMapping("/afiliados/register")
    public String register() {
        return "afiliados/register";
    }

    @GetMapping("/afiliados/recoverpassword")
    private String recoverPassword() {
        return "afiliados/recoverpassword";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute Afiliado user, Model model) {
        BasicResponse result = afiliadoService.login(user.getName(), user.getPassword());

        if (result.getCode().equals("200")) {
            return "/menu/index";
        } else {
            model.addAttribute("resp", result);
            return "afiliados/login";
        }
    }

    @PostMapping("/afiliados/register")
    public String register(@ModelAttribute Afiliado user, Model model) {
        BasicResponse result = afiliadoService.register(user);
        if (result.getCode().equals("200")) {
            return "redirect:/login";
        } else {
            model.addAttribute("resp", result);
            return "index";
        }
    }

    @PostMapping("/afiliados/recoverpassword")
    private String recoverPassword(@ModelAttribute Afiliado user, Model model) {
        BasicResponse result = afiliadoService.recoverPassword(user, user.getName(), user.getPassword());
        model.addAttribute("resp", result);
        return "redirect:/login";
    }
}
