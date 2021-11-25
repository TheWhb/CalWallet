package pe.edu.upc.spring.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sun.el.parser.ParseException;

import pe.edu.upc.spring.model.Usuario;
import pe.edu.upc.spring.model.Factura;
import pe.edu.upc.spring.model.Letra;
import pe.edu.upc.spring.model.ReciboPorHonorario;
import pe.edu.upc.spring.service.IUsuarioService;
import pe.edu.upc.spring.service.IFacturaService;
import pe.edu.upc.spring.service.ILetraService;
import pe.edu.upc.spring.service.IReciboPorHonorarioService;

@Controller
@RequestMapping("/inicio")
public class InicioController {

	@Autowired
	private IUsuarioService uService;
	
	@Autowired
	private IFacturaService fService;
	
	@Autowired
	private ILetraService lService;
	
	@Autowired
	private IReciboPorHonorarioService rService;
	
	Optional<Usuario> objUsuario;
	int idUsuario;
	String Username;
	String Email;
	String RUC;
	String TipoMoneda;
	String TipoTasa;
	double TasaInteres;
	
	//Usuario
	@RequestMapping("/datos/{id}")
	public String CargarDatos(@PathVariable int id, Map<String, Object> model) {
		setObjUsuario(uService.listarId(id));
		setIdUsuario(objUsuario.get().getIdUsuario());
		setUsername(objUsuario.get().getUsername());
		setEmail(objUsuario.get().getEmail());
		setRUC(objUsuario.get().getRUC());
		setTipoMoneda(objUsuario.get().getTipo_Moneda());
		setTipoTasa(objUsuario.get().getTipoTasa());
		setTasaInteres(objUsuario.get().getTasaInteres());
		return "redirect:/inicio";
	}
	
	@RequestMapping({"/",""})
	public String irPaginaInicio(Map<String, Object> model) {
		model.put("idUsuario", getIdUsuario());
		model.put("UsernameHola", "Hola, " + getUsername());
		model.put("Username", getUsername());
		model.put("Email", getEmail());
		model.put("RUC", getRUC());
		model.put("TipoMoneda", getTipoMoneda());
		model.put("TipoTasa", getTipoTasa());
		model.put("TasaInteres", getTasaInteres());
		return "inicio";
	}
	
	@RequestMapping("/modificar")
	public String modificar(@ModelAttribute Usuario usuario, BindingResult binRes, Model model) 
		throws ParseException
	{
		if (binRes.hasErrors()) {
			model.addAttribute("UsernameHola", "Hola, " + getUsername());
			model.addAttribute("TipoMoneda", getTipoMoneda());		
			model.addAttribute("TipoTasa", getTipoTasa());
			model.addAttribute("usuario", getObjUsuario());
			model.addAttribute("mensaje", "No se pudo cambiar");
			return "config";
		}
		else {
			getObjUsuario().get().setTipo_Moneda(usuario.getTipo_Moneda());
			getObjUsuario().get().setTipoTasa(usuario.getTipoTasa());
			getObjUsuario().get().setTasaInteres(usuario.getTasaInteres());
			boolean flag = uService.grabar(getObjUsuario().get());
			if (flag) {
				if (!(getTipoMoneda().equals(usuario.getTipo_Moneda()))) {
					List<Factura> listaF = fService.BuscarFacturasConUsuarioId(getIdUsuario());
					List<Letra> listaL = lService.BuscarLetrasConUsuarioId(getIdUsuario());
					List<ReciboPorHonorario> listaR = rService.BuscarRecibosConUsuarioId(getIdUsuario());
					if (usuario.getTipo_Moneda().equals("Soles")) {
						for (Factura factura : listaF) {
							factura.setSub_total(factura.getSub_total()*4);
							factura.setAnticipos(factura.getAnticipos()*4);
							factura.setDescuentos(factura.getDescuentos()*4);
							factura.setValor_venta(factura.getValor_venta()*4);
							factura.setISC(factura.getISC()*4);
							factura.setIGV(factura.getIGV()*4);
							factura.setOtro_cargo(factura.getOtro_cargo()*4);
							factura.setOtro_tributo(factura.getOtro_tributo()*4);
							factura.setImporte_total(factura.getImporte_total()*4);
							factura.setAlDescuento(factura.getAlDescuento()*4);
							fService.grabar(factura);
						}
						for (Letra letra : listaL) {
							letra.setImporteLetra(letra.getImporteLetra()*4);
							letra.setAlDescuento(letra.getAlDescuento()*4);
							lService.grabar(letra);
						}
						for (ReciboPorHonorario recibo : listaR) {
							recibo.setTotal(recibo.getTotal()*4);
							recibo.setRetencion(recibo.getRetencion()*4);
							recibo.setTotal_neto(recibo.getTotal_neto()*4);
							recibo.setAlDescuento(recibo.getAlDescuento()*4);
							rService.grabar(recibo);
						}
					}
					else {
						for (Factura factura : listaF) {
							factura.setSub_total(factura.getSub_total()/4);
							factura.setAnticipos(factura.getAnticipos()/4);
							factura.setDescuentos(factura.getDescuentos()/4);
							factura.setValor_venta(factura.getValor_venta()/4);
							factura.setISC(factura.getISC()/4);
							factura.setIGV(factura.getIGV()/4);
							factura.setOtro_cargo(factura.getOtro_cargo()/4);
							factura.setOtro_tributo(factura.getOtro_tributo()/4);
							factura.setImporte_total(factura.getImporte_total()/4);
							factura.setAlDescuento(factura.getAlDescuento()/4);
							fService.grabar(factura);
						}
						for (Letra letra : listaL) {
							letra.setImporteLetra(letra.getImporteLetra()/4);
							letra.setAlDescuento(letra.getAlDescuento()/4);
							lService.grabar(letra);
						}
						for (ReciboPorHonorario recibo : listaR) {
							recibo.setTotal(recibo.getTotal()/4);
							recibo.setRetencion(recibo.getRetencion()/4);
							recibo.setTotal_neto(recibo.getTotal_neto()/4);
							recibo.setAlDescuento(recibo.getAlDescuento()/4);
							rService.grabar(recibo);
						}
					}					
				}
				return "redirect:/inicio/datos/" + getIdUsuario();
			}
			else {
				model.addAttribute("UsernameHola", "Hola, " + getUsername());
				model.addAttribute("TipoMoneda", getTipoMoneda());		
				model.addAttribute("TipoTasa", getTipoTasa());
				model.addAttribute("usuario", getObjUsuario());
				model.addAttribute("mensaje", "No se pudo cambiar");
				return "config";
			}
		}
	}
	
	@RequestMapping("/configuracion")
	public String irPaginaConfiguracion(Model model) {
		model.addAttribute("UsernameHola", "Hola, " + getUsername());
		model.addAttribute("TipoMoneda", getTipoMoneda());		
		model.addAttribute("TipoTasa", getTipoTasa());
		model.addAttribute("TasaInteres", (getTasaInteres()));
		model.addAttribute("usuario", getObjUsuario());
		return "config";
	}
	
	@RequestMapping("/cerrarSesion")
	public String irPaginaCerrarSesion() {
		setObjUsuario(null);
		setIdUsuario(0);
		setUsername(null);
		setEmail(null);
		setRUC(null);
		setTipoMoneda(null);
		setTipoTasa(null);
		setTasaInteres(0);
		return "redirect:/home";
	}
	
	//Factura
	@RequestMapping("/registrarFactura")
	public String registrarFactura(Model model) {
		model.addAttribute("UsernameHola", "Hola, " + getUsername());
		model.addAttribute("TipoMoneda", getTipoMoneda());
		model.addAttribute("factura", new Factura());
		return "facturas";
	}
	
	@RequestMapping("/crearFactura")
	public String crearFactura(@ModelAttribute Factura objFactura, BindingResult binRes, Model model) 
		throws ParseException
	{
		if (binRes.hasErrors()) {
			model.addAttribute("UsernameHola", "Hola, " + getUsername());
			model.addAttribute("TipoMoneda", getTipoMoneda());
			model.addAttribute("mensaje", "No se pudo registrar");
			return "facturas";
		}
		else {
			double Periodo = objFactura.getPeriodo();
			double InteresPeriodo; double AlDescuento; int redon; double respuesta;
			if (getTipoTasa().equals("Efectiva")) {
				InteresPeriodo = ((Math.pow(1 + (getTasaInteres()/100),Periodo/360))-1);
				AlDescuento = (InteresPeriodo/(1+InteresPeriodo));	
			}
			else {
				double TEP = (Math.pow(1 + (getTasaInteres()/36000),360)-1);
				InteresPeriodo = ((Math.pow(1 + TEP,Periodo/360))-1);
				AlDescuento = (InteresPeriodo/(1+InteresPeriodo));	
			}
			redon = (int)((objFactura.getImporte_total()*(1-AlDescuento))*100); respuesta = redon;
			objFactura.setAlDescuento(respuesta/100);
			redon = (int)(((Math.pow(objFactura.getImporte_total()/objFactura.getAlDescuento(),360/Periodo))-1)*10000000); respuesta = redon;
			objFactura.setFTCEA(respuesta/100000);
			objFactura.setUsuario(getObjUsuario().get());
			boolean flag = fService.grabar(objFactura);
			if (flag) {
				return "redirect:/inicio/listarFacturas";
			}
			else {
				model.addAttribute("UsernameHola", "Hola, " + getUsername());
				model.addAttribute("TipoMoneda", getTipoMoneda());
				model.addAttribute("mensaje", "No se pudo registrar");
				return "facturas";
			}
		}
	}
	
	@RequestMapping("/listarFacturas")
	public String listarFacturas(Map<String, Object> model) { 
		model.put("UsernameHola", "Hola, " + getUsername());
		model.put("TipoMoneda", getTipoMoneda());
		model.put("listaFacturas", fService.BuscarFacturasConUsuarioId(getIdUsuario()));
		return "listFacturas";
	}
	
	@RequestMapping("/eliminarFactura")
	public String eliminar(Map<String, Object> model,  @RequestParam(value="id") Integer id) {
		try {
			if (id!=null && id>0) {
				fService.eliminar(id);
			}
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un error");
		}
		model.put("UsernameHola", "Hola, " + getUsername());
		model.put("TipoMoneda", getTipoMoneda());
		model.put("listaFacturas", fService.BuscarFacturasConUsuarioId(getIdUsuario()));
		return "listFacturas";
	}
	
	//Letra
	@RequestMapping("/registrarLetra")
	public String registrarLetra(Model model) {
		model.addAttribute("UsernameHola", "Hola, " + getUsername());
		model.addAttribute("TipoMoneda", getTipoMoneda());
		model.addAttribute("letra", new Letra());
		return "letras";
	}
	
	@RequestMapping("/crearLetra")
	public String crearLetra(@ModelAttribute Letra objLetra, BindingResult binRes, Model model) 
		throws ParseException
	{
		if (binRes.hasErrors()) {
			model.addAttribute("UsernameHola", "Hola, " + getUsername());
			model.addAttribute("TipoMoneda", getTipoMoneda());
			model.addAttribute("mensaje", "No se pudo registrar");
			return "letras";
		}
		else {
			double Periodo = objLetra.getPeriodo();
			double InteresPeriodo; double AlDescuento; int redon; double respuesta;
			if (getTipoTasa().equals("Efectiva")) {
				InteresPeriodo = ((Math.pow(1 + (getTasaInteres()/100),Periodo/360))-1);
				AlDescuento = (InteresPeriodo/(1+InteresPeriodo));	
			}
			else {
				double TEP = (Math.pow(1 + (getTasaInteres()/36000),360)-1);
				InteresPeriodo = ((Math.pow(1 + TEP,Periodo/360))-1);
				AlDescuento = (InteresPeriodo/(1+InteresPeriodo));	
			}
			redon = (int)((objLetra.getImporteLetra()*(1-AlDescuento))*100); respuesta = redon;
			objLetra.setAlDescuento(respuesta/100);
			redon = (int)(((Math.pow(objLetra.getImporteLetra()/objLetra.getAlDescuento(),360/Periodo))-1)*10000000); respuesta = redon;
			objLetra.setLTCEA(respuesta/100000);
			objLetra.setUsuario(getObjUsuario().get());
			objLetra.setUsuario(getObjUsuario().get());
			boolean flag = lService.grabar(objLetra);
			if (flag) {
				return "redirect:/inicio/listarLetras";
			}
			else {
				model.addAttribute("UsernameHola", "Hola, " + getUsername());
				model.addAttribute("TipoMoneda", getTipoMoneda());
				model.addAttribute("mensaje", "No se pudo registrar");
				return "letras";
			}
		}
	}
	
	@RequestMapping("/listarLetras")
	public String listarLetras(Map<String, Object> model) {
		model.put("UsernameHola", "Hola, " + getUsername());
		model.put("TipoMoneda", getTipoMoneda());
		model.put("periodo", new Usuario());
		model.put("listaLetras", lService.BuscarLetrasConUsuarioId(getIdUsuario()));
		return "listLetras";
	}
	
	@RequestMapping("/eliminarLetra")
	public String eliminarLetra(Map<String, Object> model,  @RequestParam(value="id") Integer id) {
		try {
			if (id!=null && id>0) {
				lService.eliminar(id);
				
			}
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un error");
		}
		model.put("UsernameHola", "Hola, " + getUsername());
		model.put("TipoMoneda", getTipoMoneda());
		model.put("listaLetras", lService.BuscarLetrasConUsuarioId(getIdUsuario()));
		return "listLetras";
	}
	
	//Recibo
	@RequestMapping("/registrarRecibo")
	public String registrarRecibo(Model model) {
		model.addAttribute("UsernameHola", "Hola, " + getUsername());
		model.addAttribute("TipoMoneda", getTipoMoneda());
		model.addAttribute("recibo", new ReciboPorHonorario());
		return "recibos";
	}
	
	@RequestMapping("/crearRecibo")
	public String crearRecibo(@ModelAttribute ReciboPorHonorario objRecibo, BindingResult binRes, Model model) 
		throws ParseException
	{
		if (binRes.hasErrors()) {
			model.addAttribute("UsernameHola", "Hola, " + getUsername());
			model.addAttribute("TipoMoneda", getTipoMoneda());
			model.addAttribute("mensaje", "No se pudo registrar");
			return "recibos";
		}
		else {
			double Periodo = objRecibo.getPeriodo();
			double InteresPeriodo; double AlDescuento; int redon; double respuesta;
			if (getTipoTasa().equals("Efectiva")) {
				InteresPeriodo = ((Math.pow(1 + (getTasaInteres()/100),Periodo/360))-1);
				AlDescuento = (InteresPeriodo/(1+InteresPeriodo));	
			}
			else {
				double TEP = (Math.pow(1 + (getTasaInteres()/36000),360)-1);
				InteresPeriodo = ((Math.pow(1 + TEP,Periodo/360))-1);
				AlDescuento = (InteresPeriodo/(1+InteresPeriodo));	
			}
			redon = (int)((objRecibo.getTotal_neto()*(1-AlDescuento))*100); respuesta = redon;
			objRecibo.setAlDescuento(respuesta/100);
			redon = (int)(((Math.pow(objRecibo.getTotal_neto()/objRecibo.getAlDescuento(),360/Periodo))-1)*10000000); respuesta = redon;
			objRecibo.setRTCEA(respuesta/100000);
			objRecibo.setUsuario(getObjUsuario().get());
			objRecibo.setUsuario(getObjUsuario().get());
			objRecibo.setUsuario(getObjUsuario().get());
			boolean flag = rService.grabar(objRecibo);
			if (flag) {
				return "redirect:/inicio/listarRecibos";
			}
			else {
				model.addAttribute("UsernameHola", "Hola, " + getUsername());
				model.addAttribute("TipoMoneda", getTipoMoneda());
				model.addAttribute("mensaje", "No se pudo registrar");
				return "recibos";
			}
		}
	}
	
	@RequestMapping("/listarRecibos")
	public String listarRecibos(Map<String, Object> model) {
		model.put("UsernameHola", "Hola, " + getUsername());
		model.put("TipoMoneda", getTipoMoneda());
		model.put("periodo", new Usuario());
		model.put("listaRecibos", rService.BuscarRecibosConUsuarioId(getIdUsuario()));
		return "listRecibos";
	}
	
	@RequestMapping("/eliminarRecibo")
	public String eliminarRecibo(Map<String, Object> model,  @RequestParam(value="id") Integer id) {
		try {
			if (id!=null && id>0) {
				rService.eliminar(id);
			}
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un error");
		}
		model.put("UsernameHola", "Hola, " + getUsername());
		model.put("TipoMoneda", getTipoMoneda());
		model.put("listaRecibos", rService.BuscarRecibosConUsuarioId(getIdUsuario()));
		return "listRecibos";
	}
	
	//GetSet
	public Optional<Usuario> getObjUsuario() {
		return objUsuario;
	}

	public void setObjUsuario(Optional<Usuario> objUsuario) {
		this.objUsuario = objUsuario;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getRUC() {
		return RUC;
	}

	public void setRUC(String rUC) {
		RUC = rUC;
	}

	public String getTipoMoneda() {
		return TipoMoneda;
	}

	public void setTipoMoneda(String tipoMoneda) {
		TipoMoneda = tipoMoneda;
	}

	public String getTipoTasa() {
		return TipoTasa;
	}

	public void setTipoTasa(String tipoTasa) {
		TipoTasa = tipoTasa;
	}

	public double getTasaInteres() {
		return TasaInteres;
	}

	public void setTasaInteres(double tasaInteres) {
		TasaInteres = tasaInteres;
	}
}
