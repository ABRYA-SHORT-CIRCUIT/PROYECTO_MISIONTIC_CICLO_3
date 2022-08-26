package com.proyecto.tvshop;

import com.proyecto.tvshop.modelos.Empresa;
import net.minidev.json.JSONUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(exclude ={SecurityAutoConfiguration.class})
public class TvshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(TvshopApplication.class, args);


		//Prueba Definition of done clase EMPRESA

		//Es posible crear una instancia de la clase "Empresa"
		Empresa TVempresa = new Empresa("TVsolutions", "Avenida siempre viva", "321456345", "901408201-5");

		//Es posible leer y modificar el nombre de la empresa
		System.out.println(TVempresa.getNombre());
		TVempresa.setNombre("TVsoluciones");
		System.out.println(TVempresa.getNombre());

		//Es posible leer y modificar la dirección de la empresa
		System.out.println(TVempresa.getDireccion());
		TVempresa.setDireccion("Cr 50 129 sur 30");
		System.out.println(TVempresa.getDireccion());

		//Es posible leer y modificar el teléfono de la empresa
		System.out.println(TVempresa.getTelefono());
		TVempresa.setDireccion("2345345");
		System.out.println(TVempresa.getTelefono());

		//Es posible leer y modificar el NIT de la empresa
		System.out.println(TVempresa.getNIT());
		TVempresa.setDireccion("65787878");
		System.out.println(TVempresa.getNIT());
	}
	}

