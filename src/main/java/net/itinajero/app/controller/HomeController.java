package net.itinajero.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.itinajero.app.model.Pelicula;
import net.itinajero.app.service.IMoviesService;
import net.itinajero.app.util.Util;

@Controller
public class HomeController {

	
	@Autowired IMoviesService moviesService;
	
	private SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String goHome() {
		return "home";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String mostrarPrincipal(Model model) {
		
		List<String> fecha = Util.getNextDays(4);
		List<Pelicula> peliculas = moviesService.searchAll();
		model.addAttribute("peliculas", peliculas);
		model.addAttribute("fechaBusqueda",dateFormat.format(new Date()));
		model.addAttribute("fecha",fecha);
		return "home";
	}
	
	@RequestMapping(value="/search", method=RequestMethod.POST)
	public String search(Model model,String date,@RequestParam("fecha") String fecha) {
		List<String> fechas = Util.getNextDays(4);
		List<Pelicula> peliculas = moviesService.searchAll();
		model.addAttribute("peliculas", peliculas);
		model.addAttribute("fechaBusqueda",fecha);
		model.addAttribute("fecha",fechas);
		return "home";
	}

	@RequestMapping(value = "/details/{id}/{fecha}", method = RequestMethod.GET)
	public String mostrarDetalles(Model model, @PathVariable("id") int id,@PathVariable("fecha") String fecha) {
		System.out.println("path variable id : "+id);
		System.out.println("fecha : "+ fecha);
		String tituloPelicula = "Rapidos y furiososssss";
		int duracion = 139;
		double precioEntrada = 50;
		model.addAttribute("titulo", tituloPelicula);
		model.addAttribute("duracion", duracion);
		model.addAttribute("precio", precioEntrada);
		model.addAttribute("pelicula",moviesService.findById(id));
		return "detalle";
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String mostrarDetalle(Model model,@RequestParam("idMovie") int id,@RequestParam(name="fecha",required=false) String fecha) {
		System.out.println("path variable id : "+id);
		System.out.println("fecha : "+ fecha);
		String tituloPelicula = "Rapidos y furiososssss";
		int duracion = 139;
		double precioEntrada = 50;

		model.addAttribute("titulo", tituloPelicula);
		model.addAttribute("duracion", duracion);
		model.addAttribute("precio", precioEntrada);
		return "detalle";
	}

}
