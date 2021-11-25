package pe.edu.upc.spring.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sun.el.parser.ParseException;

import pe.edu.upc.spring.model.Usuario;
import pe.edu.upc.spring.service.IUsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	@Autowired
	private IUsuarioService uService;
	
	Optional<Usuario> objUsuario;
	
	@RequestMapping("/logout")
	public String irPaginaBienvenida() {
		return "redirect:/home";
	}
	
	@RequestMapping("/")
	public String irPaginaListadoPropietarios(Map<String, Object> model) {
		model.put("listaUsuarios", uService.listar());
		return "listUsuarios"; // "listPropietarios" es una pagina del frontEnd para listar
	}

	@RequestMapping("/irLogin")
	public String irPaginaLogin(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "loginU";
	}
	
	@RequestMapping("/datos/{id}")
	public String CargarDatos(@PathVariable int id, Map<String, Object> model) {
		setObjUsuario(uService.listarId(id));
		return "redirect:/usuario/configuracion";
	}
	
	@RequestMapping("/configuracion")
	public String irPaginaConfiguracion(Model model) {
		model.addAttribute("usuario", getObjUsuario());
		return "config";
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) 
		throws ParseException
	{
		Optional<Usuario> objPropietario = uService.listarId(id);
		if (objPropietario == null) {
			objRedir.addFlashAttribute("mensaje", "No se pudo acceder");
			return "redirect:/inicio/datos"; /*cambiar*/
		}
		else {
			
			if(objPropietario.isPresent())
				objPropietario.ifPresent(o->model.addAttribute("usuario", o));
			return "registroU";
		}
	}
		
	
		
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model ) {
		model.put("listaUsuarios", uService.listar());
		return "listUsuarios";
	}

	public Optional<Usuario> getObjUsuario() {
		return objUsuario;
	}

	public void setObjUsuario(Optional<Usuario> objUsuario) {
		this.objUsuario = objUsuario;
	}

	
	
	
}
