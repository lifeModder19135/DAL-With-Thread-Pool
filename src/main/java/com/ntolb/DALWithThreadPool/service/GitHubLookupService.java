package com.ntolb.DALWithThreadPool.service;

import java.util.concurrent.CompletableFuture;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ntolb.DALWithThreadPool.entity.User;

@Service
public class GitHubLookupService {
	
	private static final Logger logger = LoggerFactory.getLogger(GitHubLookupService.class);
	private final RestTemplate restTemplate;
	
	public GitHubLookupService(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
			
	}
	
	@Async
	public CompletableFuture<User> findUser(String user) throws InterruptedException {
		
		logger.info("Finding " + user);
		String url = String.format("http://api.github.com/users/%s", user);
		User result = restTemplate.getForObject(url, User.class);
		Thread.sleep(1000L);
		return CompletableFuture.completedFuture(result);
		
	}

}
