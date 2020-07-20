package com.ntolb.DALWithThreadPool.service;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ntolb.DALWithThreadPool.entity.User;
import com.ntolb.DALWithThreadPool.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	Object target;
	Logger logger =LoggerFactory.getLogger(UserService.class);
	
	public CompletableFuture<List<User>> saveUser(MultipartFile file){
		
		long startTime = System.currentTimeMillis();
		
		long endTime = System.currentTimeMillis();
		
		
		
	}
	private List<User> parseCSVFile(final MultipartFile fileArg) throws Exception{
		
		final List<User> users = new ArrayList<>();
		try {
			try (final BufferedReader br = new BufferedReader(new InputStreamReder(fileArg.getInputStream())) {
				String line;
				while ((br.))
			}
			return users;
		
		}
}
