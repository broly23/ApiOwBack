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

import com.ApiStudy.Map.Maps;
import com.ApiStudy.Map.MapBean;
import com.ApiStudy.Map.MapBoot;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

@Configuration
public class MapConsumer {
	
	private static final String endpoint = "https://overwatch-api.net/api/v1/map";

	private Cache<String, List<Maps>> cache = Caffeine.newBuilder()
			  .expireAfterWrite(10, TimeUnit.MINUTES)
			  .maximumSize(10)
			  .build();
	
	@Bean
	public RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate;
	}
	
	public MapBoot getMapBoot() {
		HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        ResponseEntity<MapBoot> resp = restTemplate().exchange(endpoint, HttpMethod.GET, entity, MapBoot.class);
		return resp.getBody();
	}
	
	public List<Maps> getMaps(){
		if(cache.getIfPresent("maps") != null) {
			return cache.getIfPresent("maps");
		}
		List<Maps> maps = new ArrayList<>();
		MapBoot mb = getMapBoot();
		for( MapBean mbean : mb.getData()) {
			String mapUrl = mbean.getUrl();
			HttpHeaders headers = new HttpHeaders();
	        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
	        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
	        ResponseEntity<Maps> resp = restTemplate().exchange(mapUrl, HttpMethod.GET,entity,Maps.class);
			maps.add(resp.getBody());
		}
		cache.put("maps", maps);
		return maps;
	}
}
