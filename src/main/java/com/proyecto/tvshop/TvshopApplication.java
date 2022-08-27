package com.proyecto.tvshop;

import com.proyecto.tvshop.modelos.Empleado;
import com.proyecto.tvshop.modelos.Empresa;
import com.proyecto.tvshop.modelos.MovimientoDinero;
import net.minidev.json.JSONUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(exclude ={SecurityAutoConfiguration.class})
public class TvshopApplication {

	public static void main(String[] args) {
		//SpringApplication.run(TvshopApplication.class, args); esta linea la comenté para que por ahora funcione la prueba


		//Prueba Definition of done clase EMPRESA

		//Es posible crear una instancia de la clase "Empresa"
		Empresa TVempresa = new Empresa("TVsolutions", "Avenida siempre viva", "321456345", "901408201-5");

		//Es posible leer y modificar el nombre de la empresa
		System.out.println("Nombre de la empresa: " + TVempresa.getNombre());
		TVempresa.setNombre("TVsoluciones");
		System.out.println("Nuevo nombre de la empresa: " + TVempresa.getNombre());

		//Es posible leer y modificar la dirección de la empresa
		System.out.println( "Dirección de la empresa: " + TVempresa.getDireccion());
		TVempresa.setDireccion("Cr 50 129 sur 30");
		System.out.println("Nueva dirección de la empresa: " + TVempresa.getDireccion());

		//Es posible leer y modificar el teléfono de la empresa
		System.out.println("Télefono de la empresa: " + TVempresa.getTelefono());
		TVempresa.setTelefono("2345345");
		System.out.println("Nuevo télefono de la empresa: " + TVempresa.getTelefono());

		//Es posible leer y modificar el NIT de la empresa
		System.out.println("NIT empresa: " + TVempresa.getNIT());
		TVempresa.setNIT("65787878");
		System.out.println("Nuevo NIT empresa: " + TVempresa.getNIT());

		//Prueba Definition of done clase Empleado

		Empleado empleado = new Empleado("Pepito Perez","pepitoperez@gmail.com","operativo",TVempresa);

		//Es posible leer y modificar el nombre de un empleado
		System.out.println("Nombre del empleado: " + empleado.getNombre());
		empleado.setNombre("Pepito Morales");
		System.out.println("Nuevo nombre del empleado: " + empleado.getNombre());

		//Es posible leer y modificar el correo de un empleado
		System.out.println("Correo empleado: " + empleado.getCorreo());
		empleado.setCorreo("pepitomorales@gmail.com");
		System.out.println("Nuevo correo empleado: " + empleado.getCorreo());

		//Es posible leer y modificar la empresa a la que el empleado pertenece
		System.out.println("Empresa: " + empleado.getEmpresa());
		Empresa Tvshop = new Empresa("TVshop","Cr 77 67 90", "8776763" ,"90878640-4");
		empleado.setEmpresa(Tvshop);
		System.out.println("Nueva empresa" + empleado.getEmpresa());

		//Es posible leer y modificar el rol del empleado (administrador, operativo)
		System.out.println("Rol: " + empleado.getRol());
		empleado.setRol("Administrativo");
		System.out.println("Nuevo rol: " + empleado.getRol());

		//Prueba Definition of done clase MovimientoDinero

		//Es posible crear una nueva instancia de la clase "MovimientoDinero"
		MovimientoDinero movimiento = new MovimientoDinero(5000000,"Venta_Tv",empleado);

		//Es posible leer y modificar el monto del movimiento
		System.out.println("monto: " + movimiento.getMonto());
		movimiento.setMonto(6000000);
		System.out.println("Nuevo monto: " + movimiento.getMonto());

		//Es posible crear montos positivos y negativos
		System.out.println("monto positivo/negativo: " + movimiento.getMonto());
		movimiento.setMonto(-6000000);
		System.out.println("monto positivo/negativo: " + movimiento.getMonto());

		//Es posible leer y modificar el concepto del movimiento
		System.out.println("Concepto: " + movimiento.getConcepto());
		movimiento.setConcepto("Compra de Tv");
		System.out.println("Nuevo concepto: " + movimiento.getConcepto());

		//Es posible definir qué usuario fue encargado de registrar el movimiento
		System.out.println("Usuario Encargado: " + movimiento.getUsuario());
		Empleado empleado1 = new Empleado("Juan Velez", "juanvelez@gmail.com", "administrativo",Tvshop);
		movimiento.setUsuario(empleado1);
		System.out.println("Nuevo usuario encargado: " + movimiento.getUsuario());


	}
	}

