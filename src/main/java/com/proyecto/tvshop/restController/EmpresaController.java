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

//@RequestMapping("/enterprises")
//@Controller

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
        Empresa qryEnterprise;
        String quest = QUERIES.contains(edit) ? edit : "VIEW";

        model.addAttribute("quest", quest);

        //Si la solicitud llega con id = 0, se va a crear una nueva empresa
        if(idEnterprise == 0) {
            if(quest.equals("CREATE")) {
                qryEnterprise = new Empresa();
                model.addAttribute("enterprise",qryEnterprise);
                model.addAttribute("mensaje",mensaje);
                return "empresa";
            } else {
                redirect.addFlashAttribute("errorMessage", "Consulta no válida");
                return "redirect:/enterprises";
            }
        } else { //Si id es diferente de 0, se va a hacer una actualización o una eliminación
            try {
                Optional<Empresa> fndEnterprise = empresaService.consultarEmpresa(idEnterprise);
                qryEnterprise = fndEnterprise.get();
                model.addAttribute("enterprise",qryEnterprise);
                model.addAttribute("mensaje",mensaje);
            } catch (Exception e) {
                redirect.addFlashAttribute("errorMessage", e.getMessage());
                return "redirect:/enterprises";
            }
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

    //Si  la empresa llega con ID = 0 o inexistente, se crea una nueva, de lo contrario se actualiza
    @PostMapping("/enterprises")
    public String addEnterprise(@RequestParam(value = "ID") Integer id, Empresa newEnterprise, RedirectAttributes redirectAttributes){
        String messageResponse;

        if(id == 0) {
            messageResponse = empresaService.crearEmpresa(newEnterprise)? "La empresa ha sido creada con éxito" : "La empresa no pudo ser creada";
        } else {
            messageResponse = empresaService.actualizarEmpresa(id, newEnterprise)? "Los cambios han sido guardados con éxito" : "Los cambios no se han podido guardar";
        }
        redirectAttributes.addFlashAttribute("message", messageResponse);

        return "redirect:/enterprises";
    }
}
