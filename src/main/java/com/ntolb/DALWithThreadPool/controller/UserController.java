package com.ntolb.DALWithThreadPool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ntolb.DALWithThreadPool.service.UserService;

@RestController
public class UserController {
		
		
		@Autowired
		UserService service = new UserService();
		
		@PostMapping(value = "/users", consumes="MediaType.MULTIPART_FORM_DATA_VALUE", produces="application/json")
		public ResponseEntity saveUsers(@RequestParam(value="files") MultipartFile[] files) throws Exception {
			
			for(MultipartFile file:files) {
				service.saveUser(file);
			}
			return ResponseEntity.status(HttpStatus.CREATED).build;
			
		};
}