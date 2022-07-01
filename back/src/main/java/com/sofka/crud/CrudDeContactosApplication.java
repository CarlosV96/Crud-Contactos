package com.sofka.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase inicial de Sistema CRUD de contactos
 *
 * @version 1.0.0 2022-07-01
 * @author Carlos Valencia <caliche-9696@hotmail.com>
 * @since 1.0.0
 */
@SpringBootApplication
public class CrudDeContactosApplication {

	/**
	 * Método principal con el que inicia el sistema
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(CrudDeContactosApplication.class, args);
	}

}
