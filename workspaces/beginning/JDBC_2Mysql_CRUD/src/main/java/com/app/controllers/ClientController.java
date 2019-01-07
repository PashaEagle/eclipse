package com.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.interfaces.ClientDao;
import com.app.dao.models.Client;

@RestController
public class ClientController {

	@Autowired
	private ClientDao clientDao;

	@RequestMapping(method = RequestMethod.GET, value = "/clients")
	public List<Client> allClients() {
		return clientDao.getAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/clients/{id}")
	public Client getClient(@PathVariable Integer id) {
		return clientDao.getById(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/clients")
	public void addClient(@RequestBody Client client) {
		clientDao.add(client);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/clients/")
	public void updateClient(@RequestBody Client client) {
		clientDao.update(client);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/clients/{id}")
	public void deleteClient(@PathVariable Integer id) {
		clientDao.remove(id);
	}
}
