package com.example.linkedPosting.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;

@Service
public class LinkedInService 
{
	 @Value("${linkedin.clientId}")
	 private String clientId;

	 @Value("${linkedin.clientSecret}")
	 private String clientSecret;
	 
	 @Value("${linkedin.redirectUri}")
	 private String redirectUri;
	
	public String createPost(String message, String accessToken)
	{
		 String url = "https://api.linkedin.com/v2/ugcPosts";
		 
	        // Build the request body
	        String requestBody = "{\"author\":\"urn:li:person:cHTCMRpubB\",\"lifecycleState\":\"PUBLISHED\",\"specificContent\":{\"com.linkedin.ugc.ShareContent\":{\"shareCommentary\":{\"text\":\"" + message + "\"},\"shareMediaCategory\":\"NONE\"}},\"visibility\":{\"com.linkedin.ugc.MemberNetworkVisibility\":\"PUBLIC\"}}";
	        System.out.println("control is here: "+message);
	        // Make the API call
	        // You can use any HTTP client library (e.g., Apache HttpClient, OkHttp) to send the POST request
	        // Here's an example using Spring's RestTemplate
	        RestTemplate restTemplate = new RestTemplate();
	        HttpHeaders headers = new HttpHeaders();
	        headers.set("Authorization", "Bearer " + accessToken);
	        headers.set("Content-Type", "application/json");
	        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);
	        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);

	        // Handle the response
	        if (response.getStatusCode() == HttpStatus.CREATED) {
	            System.out.println("Post created successfully!");
	        } else {
	            System.out.println("Failed to create post. Response: " + response.getBody());
	        }
		return "success";
	}
	
}
