package com.ApiStudy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.ApiStudy.Achievement.Achievement;
import com.ApiStudy.Achievement.AchievementBoot;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;


@Configuration
public class AchievementConsumer {

	private static final String endpoint = "https://overwatch-api.net/api/v1/achievement";

	private Cache<String, List<Achievement>> cache = Caffeine.newBuilder()
			  .expireAfterWrite(10, TimeUnit.MINUTES)
			  .maximumSize(10)
			  .build();
	
	@Bean
	public RestTemplate restTemplate() {
		final RestTemplate restTemplate = new RestTemplate();
		final HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
		final HttpClient httpClient = HttpClientBuilder.create().setRedirectStrategy(new LaxRedirectStrategy()).build();
		factory.setHttpClient(httpClient);
		restTemplate.setRequestFactory(factory);
		return restTemplate;
	}

	public List<Achievement> getAchievements() {
		
		if(cache.getIfPresent("achievements") != null) {
			return cache.getIfPresent("achievements");
		}
		
		List<Achievement> achievements = new ArrayList<Achievement>();
		String url = endpoint;
		while (url != null) {
			final RestTemplate restTemplate = new RestTemplate();
			final HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
			final HttpClient httpClient = HttpClientBuilder.create().setRedirectStrategy(new LaxRedirectStrategy()).build();
			factory.setHttpClient(httpClient);
			restTemplate.setRequestFactory(factory);
			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
			HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
			ResponseEntity<AchievementBoot> resp = restTemplate.exchange(url, HttpMethod.GET, entity,
					AchievementBoot.class);
			achievements.addAll(resp.getBody().getData());
			url = resp.getBody().getNext();
		}
		
		cache.put("achievements", achievements);
		
		return achievements;
	}

}
