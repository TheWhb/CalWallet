package pe.edu.upc.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {

	@RequestMapping({"/",""})
	public String irPaginaBienvenida() {
		return "landing";
	}
	
	@RequestMapping("/nosotros")
	public String irPaginaNosotros() {
		return "nosotros";
	}
	
	@RequestMapping("/contacto")
	public String irPaginaContacto() {
		return "contacto";
	}
	
}
