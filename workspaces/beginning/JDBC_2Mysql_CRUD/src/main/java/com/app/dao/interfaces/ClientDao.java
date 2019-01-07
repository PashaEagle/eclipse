package com.app.dao.interfaces;

import java.util.List;

import com.app.dao.models.Client;

public interface ClientDao {

	void add(Client client);
	void remove(Integer id);
	void update(Client client);
	List<Client> getAll();
	Client getById(Integer id);
}
