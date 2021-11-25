package pe.edu.upc.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sun.el.parser.ParseException;

import pe.edu.upc.spring.model.Usuario;
import pe.edu.upc.spring.service.IUsuarioService;

@Controller
@RequestMapping("/register")
public class RegisterController {

	@Autowired
	private IUsuarioService uService;
	
	@RequestMapping({"/",""})
	public String irPaginaRegister(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "registroU";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Usuario objUsuario, BindingResult binRes, Model model) 
		throws ParseException
	{
		if (binRes.hasErrors()) {
			model.addAttribute("mensaje", "No se pudo registrar");
			return "registroU";
		}
		else {
			objUsuario.setTasaInteres(objUsuario.getTasaInteres());
			boolean flag = uService.grabar(objUsuario);
			if (flag) {
				return "redirect:/inicio/datos/" + objUsuario.getIdUsuario();
			}
			else {
				model.addAttribute("mensaje", "No se pudo registrar");
				return "registroU";
			}
		}
	}
	
}
