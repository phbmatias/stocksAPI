package com.project.stocksAPI.services;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
	
	public List<SearchHistory> SearchAndStoreCurrency(String currencyType){
		String APIcurrencyType = currencyType;
		
		if(APIcurrencyType.equalsIgnoreCase("USD")) {
			APIcurrencyType = "USD-BRL";
		}
		else if(APIcurrencyType.equalsIgnoreCase("EUR")) {
			APIcurrencyType = "EUR-BRL";
		}
		else if(APIcurrencyType.equalsIgnoreCase("BTC")) {
			APIcurrencyType = "BTC-BRL";
		}
		else {
			throw new IllegalArgumentException("Moeda não suportada");
		}
		
		String APIurl = "https://economia.awesomeapi.com.br/json/last/" + APIcurrencyType;
		Map<String, Map<String, Object>> response = restTemplate.
				getForObject(APIurl, Map.class);
		
		List<SearchHistory> searchHistories = new ArrayList<>();
		
		// Formatador de data dia/mês/ano horas:minutos:segundos 
		DateTimeFormatter dateFormatter = DateTimeFormatter.
				ofPattern("dd/MM/yyyy HH:mm:ss");
		
		
		// Dolar
		Map<String, Object> Data = response.get(APIcurrencyType.replace("-", ""));
		SearchHistory currency = new SearchHistory();
		
		currency.setDate(LocalDateTime.now().
				format(dateFormatter));
		currency.setCurrency(currencyType);
		currency.setValueInReais(new BigDecimal(Data.
				get("bid").toString()));
		
		repository.save(currency);
		searchHistories.add(currency);
		
		return searchHistories;
	}
}
