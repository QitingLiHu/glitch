package com.chatbot.demo.util.niveles0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.chatbot.demo.util.GestorMenus;
import com.chatbot.demo.util.Response;

public class Pasivo {

	private String salida = "Elija el numero del asunto que desee consultar:";
	private GestorMenus gestMenus;

	// Opciones
	private ArrayList<String> nivel1 = new ArrayList<>(Arrays.asList("CUENTA BBVA", "CUENTA CX", "IPF", "FONDO"));

	// Flujo cuenta BBVA
	private ArrayList<String> cuentabbva, cuentabbva1, cuentabbva2;

	public Pasivo(GestorMenus gestMenus) {

		this.gestMenus = gestMenus;

		nivel1 = new ArrayList<>(Arrays.asList("CUENTA BBVA", "CUENTA CX", "IPF", "FONDO"));

		cuentabbva = new ArrayList<>(
				Arrays.asList("Disconformidad con el cobro de comisión de administración y mantenimiento",
						"Información sobre la cuenta remunerada", "Aclaraciones sobre un cobro de descubierto"));

		cuentabbva1 = new ArrayList<>(Arrays.asList(
				"¿Ha localizado en el FRONT de BONIFICACIONES el INDICADOR de cuyo cumplimiento es objeto la incidencia?",
				"Informacion de la cuenta",
				"¿Ha localizado en el FRONT de BONIFICACIONES el INDICADOR de cuyo cumplimiento es objeto la incidencia?"));

		cuentabbva2 = new ArrayList<>(Arrays.asList(
				"Si es así, siga las indicaciones que le dice el FRONT y pase la incidencia al equipo que se le indica, para que confirme el valor de ese INDICADOR\r\n",
				"Si no es así, y ya lo ha consultado con su responsable, entonces pase la incidencia a ANS CATALOGO Y CONDICIONES"));

	}

	// Methods
	public Response getTextoNivel1() {
		Response msg = new Response();
		msg.setDescription(salida);
		List<String> options = new ArrayList<String>();
		options.add("Salir");

		for (int i = 0; i < nivel1.size(); i++) {
			options.add(nivel1.get(i));
		}
		
		msg.setOptions(options);
		return msg;

	}

	public Response pasarNivel1ANivel2(String respuesta) {
		Response msg = new Response();
		msg.setDescription(salida);
		List<String> options = new ArrayList<String>();
		options.add("Salir");

		try {
			int resp = Integer.parseInt(respuesta);

			switch (resp) {
			case 1:
				for (int i = 0; i < cuentabbva.size(); i++) {
					options.add(cuentabbva.get(i));
				}

				break;
			case 2:
			case 3:
			}

		} catch (NumberFormatException ex) {

			String resp = respuesta.toLowerCase();

		}
		msg.setOptions(options);
		return msg;
	}

	public Response pasarNivel2ANivel3(String respuesta) {
		Response msg = new Response();
		msg.setDescription(cuentabbva1.get(0));
		List<String> options = new ArrayList<String>();
		options.add("Salir");
		
		try {
			int resp = Integer.parseInt(respuesta);
			switch (resp) {
			case 1:
				for (int i = 0; i < cuentabbva2.size(); i++) {
					options.add(cuentabbva2.get(i));
				}
				gestMenus.setNivelPreguntas(0);
				break;
			case 2:
			case 3:
			}

		} catch (NumberFormatException ex) {

			String resp = respuesta.toLowerCase();

		}

		msg.setOptions(options);
		
		return msg;
	}

	public ArrayList<String> getNivel1() {
		return nivel1;
	}

	public void setNivel1(ArrayList<String> nivel1) {
		this.nivel1 = nivel1;
	}

	public ArrayList<String> getCuentabbva() {
		return cuentabbva;
	}

	public void setCuentabbva(ArrayList<String> cuentabbva) {
		this.cuentabbva = cuentabbva;
	}

	public ArrayList<String> getCuentabbva1() {
		return cuentabbva1;
	}

	public void setCuentabbva1(ArrayList<String> cuentabbva1) {
		this.cuentabbva1 = cuentabbva1;
	}

	public ArrayList<String> getCuentabbva2() {
		return cuentabbva2;
	}

	public void setCuentabbva2(ArrayList<String> cuentabbva2) {
		this.cuentabbva2 = cuentabbva2;
	}

}
