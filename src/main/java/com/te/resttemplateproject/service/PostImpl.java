package com.te.resttemplateproject.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.te.resttemplateproject.output.PostManResponse;
import com.te.resttemplateproject.output.PostOfficeBean;

import lombok.RequiredArgsConstructor;

@Service("post_service_impl")
@RequiredArgsConstructor
public class PostImpl implements PostService {

	private final RestTemplate restTemplate;

	@Override
	public PostManResponse getAll(String city) {

		String url = "https://api.postalpincode.in/postoffice/{city}";
		url = url.replace("{city}", city);
		System.out.println("Url is :" + url);

		ResponseEntity<PostManResponse[]> resposne = restTemplate.getForEntity(url, PostManResponse[].class);
		System.err.println("response status cose : " + resposne.getStatusCode());
		PostManResponse[] body = resposne.getBody();
		System.err.println(body);

		for (PostManResponse postManResponse : body) {
			List<PostOfficeBean> postOffice = postManResponse.getPostOffice();
			postOffice.stream().forEach(post -> {
				System.out.println(post.getCountry() + " country " + post.getName() + " name");

			});
		}

		return body[0];
	}

}
