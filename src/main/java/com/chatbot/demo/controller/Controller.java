package com.chatbot.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.chatbot.demo.util.GestorMenus;

@RestController
public class Controller {

	private GestorMenus gestMenu = new GestorMenus();

	@GetMapping("getData")
	public String readGoogleSheet() {
		return gestMenu.getSalidaInicial();
	}

	@PostMapping("sendSelection")
	@ResponseBody
	public String sendSelectedOption(@RequestBody OpcionSeleccionada opcion) {
		System.out.println("Respuesta: " + opcion.getRespuesta());

		String msg = gestMenu.comprobarRespuesta(opcion.getRespuesta());

		return msg;
	}

}
