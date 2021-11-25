package pe.edu.upc.spring.controller;

import java.util.List;
import java.util.Optional;

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
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private IUsuarioService uService;
	
	Optional<Usuario> objUsuario;
	
	@RequestMapping({"/",""})
	public String irPaginaLogin(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "login";
	}
	
	@RequestMapping("/validarUsuario")
	public String ingresarCuenta(@ModelAttribute("usuario") Usuario objUsuario, BindingResult binRes, Model model) throws ParseException {
		List<Usuario> listaUsuarios;
		objUsuario.setUsername(objUsuario.getUsername());
		objUsuario.setContraseña(objUsuario.getContraseña());
		listaUsuarios = uService.findByUsernameAndPassword(objUsuario.getUsername(), objUsuario.getContraseña());
		
		if (!listaUsuarios.isEmpty()) {
			objUsuario = listaUsuarios.get(0);
			return "redirect:/inicio/datos/" + objUsuario.getIdUsuario();
		}
		else {
			model.addAttribute("mensaje", "Datos incorrectos");
			return "login";
		}
	}
}
