package com.ntolb.DALWithThreadPool.service;


import java.io.IOException;
import java.io.InputStreamReader;
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
	
	public CompletableFuture<List<User>> saveUser(MultipartFile file) throws Exception{
		
		long startTime = System.currentTimeMillis();
		List<User> users = parseCSVFile(file);
		logger.info("Saving list of users of size {}", users.size(), "" + Thread.currentThread().getName());
		users = repository.saveAll(users);
		long endTime = System.currentTimeMillis();
		logger.info("TOTAL TIME: {}", (endTime-startTime));
		return CompletableFuture.completedFuture(users);
		
		
	}
	private List<User> parseCSVFile(final MultipartFile fileArg) throws Exception{
		
		final List<User> users = new ArrayList<>();
		try {
			try (final BufferedReader br = new BufferedReader(new InputStreamReader(fileArg.getInputStream()))) {
				String line;
				while ((line = br.readLine()) != null) {
					final String [] data = line.split(",");
					final User user = new User();
					user.setName(data[0]);
					user.setEmail(data[1]);
					user.setGender(data[2]);
					users.add(user);
				}
				
				return users;	
			}
			
		
		}catch (final IOException e) {
			
			logger.error("failed to parse CSV file{}",e);
			throw new Exception("failed to parse CSV file{}",e);
		}
	}
}
