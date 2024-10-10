package com.cibertec.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.app.entity.Rol;
import com.cibertec.app.repository.RolRepository;
import com.cibertec.app.service.RolService;

@Service
public class RolServiceImpl implements RolService{

	@Autowired
	RolRepository rolRepository;

	@Override
	public List<Rol> getAllRol() {
		// TODO Auto-generated method stub
		return rolRepository.findAll();
	}
}
