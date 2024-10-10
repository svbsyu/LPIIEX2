package com.cibertec.app.service;

import java.util.List;

import com.cibertec.app.entity.Cliente;

public interface ClienteService {

	public Cliente saveCliente(Cliente userEntity);
	
	public List<Cliente> getAllCliente();
	
	public Cliente updateCliente(Cliente userEntity);
	
	public void deleteCliente(Integer id);
	
	public Cliente findClienteById(Integer id);
}
