package com.chatbot.demo.controller;

import com.chatbot.demo.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.chatbot.demo.util.GestorMenus;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {

	private GestorMenus gestMenu = new GestorMenus();

	@GetMapping("getData")
	public Response readGoogleSheet() {
		String respAux = gestMenu.getSalidaInicial();
		Response resp = new Response();
		String splittedArray[] = respAux.split(":");
		resp.setDescription(splittedArray[0]);
		List<String> options = new ArrayList<String>();
		for(String s : splittedArray[1].split(" ")) {
			options.add(s);
		}
		resp.setOptions(options);
		return resp;
	}

	@PostMapping("sendSelection")
	@ResponseBody
	public Response sendSelectedOption(@RequestBody OpcionSeleccionada opcion) {
		//System.out.println("Respuesta: " + opcion.getRespuesta());

		return gestMenu.comprobarRespuesta(opcion.getRespuesta());
	}

}
