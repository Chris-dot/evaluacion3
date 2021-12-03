package com.nttdata.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	ClienteRepository cr;
	
	

}
