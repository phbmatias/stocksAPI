package com.project.stocksAPI.services;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.project.stocksAPI.models.SearchHistory;
import com.project.stocksAPI.repositories.SearchHistoryRepository;

@Service
public class SearchHistoryService {
	
	@Autowired
	private SearchHistoryRepository repository;
	
	private RestTemplate restTemplate = new RestTemplate();
	
	public List<SearchHistory> SearchAndStoreCurrency(){
		String APIurl = "https://economia.awesomeapi.com.br/json/last/USD-BRL,EUR-BRL";
		Map<String, Map<String, Object>> response = restTemplate.getForObject(APIurl, Map.class);
		
		List<SearchHistory> searchHistories = new ArrayList<>();
		
		// Dolar
		Map<String, Object> usdData = response.get("USDBRL");
		SearchHistory usd = new SearchHistory();
		
		usd.setDate(LocalDateTime.now());
		usd.setCurrency("USD");
		usd.setValueInReais(new BigDecimal(usdData.get("bid").toString()));
		
		repository.save(usd);
		searchHistories.add(usd);
		
		return searchHistories;
	}
}
