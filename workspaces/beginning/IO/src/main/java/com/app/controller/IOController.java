package com.app.controller;
	
import java.io.IOException;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.converter.Converter;
import com.app.model.User;

@RestController
public class IOController{
	
	/*@Autowired
	private OutputUser outputUser;
	@Autowired
	private InputUser inputUser;*/

	
	@RequestMapping(value = "/write", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void create(@RequestBody List<User> users) {
		//outputUser.writeToFile(user)		;
		try 
		{	
			Converter.toJSON(users);
		}
		catch(IOException e){System.out.println("Error while writing");}
	}
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public String get(){
		List<User> users;
		try
		{
			users = Converter.toJavaObject();
			return users.toString();
		}
		catch(IOException e) {System.out.println("Error while reading..");}
		
		return "Error!!1!";
		
	}
}
