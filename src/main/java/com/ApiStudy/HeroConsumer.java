package com.ApiStudy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.ApiStudy.Hero.Hero;
import com.ApiStudy.Hero.HeroBean;
import com.ApiStudy.Hero.HeroBoot;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

@Configuration
public class HeroConsumer {

	private static final String endpoint = "https://overwatch-api.net/api/v1/hero";
	
	private Cache<String, List<Hero>> cache = Caffeine.newBuilder()
			  .expireAfterWrite(10, TimeUnit.MINUTES)
			  .maximumSize(10)
			  .build();
	
	@Bean
	public RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate;
	}
	
	
	public HeroBoot getHeroBoot(){
		HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        ResponseEntity<HeroBoot> resp = restTemplate().exchange(endpoint, HttpMethod.GET, entity, HeroBoot.class);
		return resp.getBody();
	}
	
	public List<Hero> getHeroes(){
		if(cache.getIfPresent("heroes") != null) {
			return cache.getIfPresent("heroes");
		}
		List<Hero> heroes = new ArrayList<>();
		HeroBoot hb = getHeroBoot();
		for( HeroBean hbean : hb.getData()) {
			String heroUrl = hbean.getUrl();
			HttpHeaders headers = new HttpHeaders();
	        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
	        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
	        ResponseEntity<Hero> resp = restTemplate().exchange(heroUrl, HttpMethod.GET,entity,Hero.class);
			heroes.add(resp.getBody());
		}
		cache.put("heroes", heroes);
		return heroes;
	}
	
}
