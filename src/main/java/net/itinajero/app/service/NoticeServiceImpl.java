package net.itinajero.app.service;

import org.springframework.stereotype.Service;

import net.itinajero.app.model.Notice;

@Service
public class NoticeServiceImpl implements INoticeService {

	// Constructor vacio. Unicamente para imprimir un mensaje al crearse una instancia
	public NoticeServiceImpl() {
		System.out.println("Creando una instancia de la clase NoticiasServiceImpl");
	}
	
	public void save(Notice notice) {
		System.out.println(notice);
	}

}
