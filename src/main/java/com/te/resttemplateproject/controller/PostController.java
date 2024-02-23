package com.te.resttemplateproject.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.te.resttemplateproject.output.PostManResponse;
import com.te.resttemplateproject.service.PostService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/postal")
public class PostController {

	private final PostService postService;
	
	@RequestMapping(value = "/bycity",method = RequestMethod.GET,
			consumes = MediaType.ALL_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public PostManResponse getCity(@RequestParam String city) {
		System.err.println("contoller");
	return postService.getAll(city);
		
		
		
	}
}
