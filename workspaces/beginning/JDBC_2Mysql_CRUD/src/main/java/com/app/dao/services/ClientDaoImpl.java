package com.app.dao.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.app.dao.interfaces.ClientDao;
import com.app.dao.models.Client;
import com.app.dao.models.Role;

public class ClientDaoImpl implements ClientDao {


	private static final String QUERY_INSERT = "INSERT INTO Clients (name, lastName, role) VALUES (?,?,?)";
	private static final String QUERY_UPDATE = "UPDATE Clients SET name = ?, lastName = ?, role = ? WHERE id = ?";
	private static final String QUERY_SELECT_ALL = "SELECT * FROM Clients";
	private static final String QUERY_SELECT_BY_ID = "SELECT * FROM Clients WHERE id = ?";
	private static final String QUERY_DELETE_BY_ID = "DELETE FROM Clients WHERE id = ?";

	@Autowired
	@Qualifier("firstDBTemplate")
	private JdbcTemplate jdbcTemplate;

	@Override
	public void add(Client client) {
		jdbcTemplate.update(QUERY_INSERT, client.getName(), client.getLastName(), client.getRole().name());
	}

	@Override
	public void remove(Integer id) {
		jdbcTemplate.update(QUERY_DELETE_BY_ID, id);
	}

	@Override
	public void update(Client client) {
		jdbcTemplate.update(QUERY_UPDATE, client.getName(), client.getLastName(), client.getRole().name(), client.getId());
	}

	@Override
	public List<Client> getAll() {
		List<Client> clients = jdbcTemplate.query(QUERY_SELECT_ALL, new ClientMapper());
		return clients;
	}

	@Override
	public Client getById(Integer id) {
		Client client = (Client) jdbcTemplate.queryForObject(QUERY_SELECT_BY_ID, new Object[] { id }, new ClientMapper());
		return client;
	}

	private class ClientMapper implements RowMapper {

		@Override
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			Client client = new Client();
			client.setId(rs.getInt("id"));
			client.setName(rs.getString("name"));
			client.setLastName(rs.getString("lastName"));
			client.setRole(Role.valueOf(rs.getString("role")));
			return client;
		}

	}
}
