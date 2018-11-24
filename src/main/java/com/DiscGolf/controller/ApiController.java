package com.DiscGolf.controller;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.DiscGolf.dao.UserDiscDAO;
import com.DiscGolf.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@RestController
@RequestMapping("/api")
public class ApiController {

	@Autowired
	UserDiscDAO udDao;

	@GetMapping(value = "/get/users")
	public @ResponseBody String returnAllUsers() throws JsonProcessingException {

		ObjectMapper responseMapper = new ObjectMapper();
		responseMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, true);
		return responseMapper.writeValueAsString(udDao.getAllUsers());
	}

	@GetMapping(value = "/get/discs")
	public @ResponseBody String returnAllDiscs() throws JsonProcessingException {

		ObjectMapper responseMapper = new ObjectMapper();
		responseMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, true);
		return responseMapper.writeValueAsString(udDao.getAllDiscs());
	}

	@GetMapping(value = "/get/discs/user")
	public @ResponseBody String returnAllUserDiscs() throws JsonProcessingException {

		int id = 1;
		ObjectMapper responseMapper = new ObjectMapper();
		responseMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, true);
		return responseMapper.writeValueAsString(udDao.getAllDiscsByUserId(id));
	}

	@PostMapping(path = "/post/discs/user")
	public void requestUserInfo(@RequestBody String newUser) throws IOException {
		ObjectMapper requestMapper = new ObjectMapper();
		User requestUser = requestMapper.readValue(newUser, User.class);

		System.out.println("Javan new user: " + requestUser);

		// dao.createJotai(metodi);
	}

}