package pe.isil.EFVasquez.visita;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.isil.EFVasquez.afiliados.Afiliado;
import pe.isil.EFVasquez.afiliados.AfiliadoService;
import pe.isil.EFVasquez.shared.BasicResponse;

import java.util.List;

@Controller
@RequestMapping("/visitas")
public class VisitaController {
    @Autowired
    private VisitaService visitaService;

    @Autowired
    private AfiliadoService afiliadoService;

    @GetMapping("/")
    public String index(Model model){

        model.addAttribute("listVisits",visitaService.findAll());

        return "visitas/index";
    }

    @GetMapping("create")
    public String create(Model model) {

        List<Afiliado> afiliado = afiliadoService.findAll();
        model.addAttribute("document",afiliado);
        return "visitas/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Visita visit, Model model){
        visitaService.save(visit);
        return "visitas/Success";
    }

    @GetMapping("/update")
    public String update(@RequestParam("id") Long id, Model model) {
        Visita aplicacion = visitaService.getVisitaById(id);
        model.addAttribute("visita", aplicacion);
        return "visitas/update";
    }

    @PostMapping("/update")
    public String updateUser(Visita visitaToUpdate, Model model) {
        BasicResponse response = visitaService.updateVisita(visitaToUpdate, visitaToUpdate.getId());

        if (response.getCode().equals("200")) {
            return "redirect:/visita/";
        } else {
            model.addAttribute("resp", response);
            return "./responseVisita";
        }
    }
}
