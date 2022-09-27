package com.proyecto.tvshop.restController;

import com.proyecto.tvshop.Servicios.EmpresaService;
import com.proyecto.tvshop.modelos.Empresa;
import com.proyecto.tvshop.modelos.State;
import jdk.swing.interop.SwingInterOpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@Controller
public class EmpresaController {
    private final List<String> QUERIES = Arrays.asList("VIEW","EDIT","CREATE","DELETE");
    @Autowired
    private EmpresaService empresaService;

    @GetMapping("/enterprises")
    public String showAllEnterprises(Model model){
        List<Empresa> allEnterprises = empresaService.listarEmpresas();
        model.addAttribute("enterpriseList",allEnterprises);
        return "empresas";
    }

    @GetMapping(value = "/enterprises/{id}")
    public String showEnterprise(@PathVariable("id") Integer idEnterprise, @RequestParam(required = false, value = "quest") String edit, Model model, RedirectAttributes redirect, @ModelAttribute("mensaje") String mensaje){
        Empresa qryEnterprise = new Empresa();
        String quest = QUERIES.contains(edit) ? edit : "VIEW";

        model.addAttribute("quest", quest);

        if(idEnterprise == 0) {
            if(quest.equals("CREATE")) {
                model.addAttribute("enterprise",qryEnterprise);
                model.addAttribute("mensaje",mensaje);
                return "empresa";
            } else {
                redirect.addFlashAttribute("errorMessage", "Consulta no válida");
                return "redirect:/enterprises";
            }
        } else {
            try {
                Optional<Empresa> fndEnterprise = empresaService.consultarEmpresa(idEnterprise);
                qryEnterprise = fndEnterprise.get();
            } catch (Exception e) {
                redirect.addFlashAttribute("errorMessage", e.getMessage());
                return "redirect:/enterprises";
            }
            model.addAttribute("enterprise",qryEnterprise);
        }

        if(quest.equals("DELETE")) {
            try {
                empresaService.eliminarEmpresa(idEnterprise);
                redirect.addFlashAttribute("message", "Empresa eliminada");
            } catch (Exception e){
                redirect.addFlashAttribute("message", "Empresa no pudo ser eliminada\n"+e.getMessage());
            }
            return "redirect:/enterprises";
        }

        return "empresa";
    }

    @PostMapping("/enterprises")
    public String addEnterprise(Empresa newEnterprise, RedirectAttributes redirectAttributes){
        try {
            if(newEnterprise.getId() == 0) {
                empresaService.crearEmpresa(newEnterprise);
            } else {
                empresaService.actualizarEmpresa(newEnterprise.getId(), newEnterprise);
            }
            redirectAttributes.addFlashAttribute("message", "Empresa creada");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
        }

        return "redirect:/enterprises";
    }



//    @PatchMapping("/enterprises/{id}")
//    public Empresa updateEnterprise(@PathVariable("id") Integer idEnterprise, @RequestBody Empresa editedEnterprise){
//        return empresaService.actualizarEmpresa(idEnterprise, editedEnterprise);
//    }

//    @DeleteMapping("/enterprises/{id}")
//    public String deleteEnterprise(@PathVariable("id") Integer idEnterprise){
//        if(empresaService.eliminarEmpresa(idEnterprise)) {
//            return "La empresa fue eliminada correctamente";
//        }
//        return "La empresa no fue eliminada";
//    }
}
