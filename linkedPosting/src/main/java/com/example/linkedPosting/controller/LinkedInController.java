package com.example.linkedPosting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.linkedPosting.dto.TextMessage;

import com.example.linkedPosting.service.LinkedInService;

@RestController
public class LinkedInController 
{
	@Autowired
	LinkedInService linkedInService;
	
	@PostMapping("/linkedPost")
	public String sharePost(@RequestBody TextMessage textMessage)
	{
		System.out.println(textMessage);
		String message = textMessage.getMessage();
		String accessToken = "AQV0FRaZwzBaIYK8ymA8xQOqFqnkhzl7s8ayhy18kTupNwvUjYT5mqtuA1YwMXb_HQNkMXvGf3mIoEKiyXUUeGAtTOHRQ1T_e3gg2AN4yhUVBf_px6sHpT77-SDUoRu1WI7OC7Mz4Hj5nMat5tcgPpCYMlhyVk3qzgXUzKFJj8pwgRyXmjSAaQUQRmE4w8rvVJRqnsR0kMlaPy7tKQI-8AtqxPIT4llCdMxyOYH9le5LCLHMLPfATdna0iVLv62MyZVpy47TeRgavqI2-M9n8CiCFGIX0_26BpgazudphvCUbrw2B7mhQgk6gnsNGyOI71lYy-J2EhbBlVXs-1pS4GpGLNIydQ";
		return linkedInService.createPost(message,accessToken);
	}
}
