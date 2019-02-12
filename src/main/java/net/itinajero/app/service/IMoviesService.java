package net.itinajero.app.service;

import java.util.List;

import net.itinajero.app.model.Pelicula;

public interface IMoviesService {

	List<Pelicula> searchAll();
	Pelicula findById(int id);
}
