package com.project.stocksAPI.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.stocksAPI.models.SearchHistory;
import com.project.stocksAPI.services.SearchHistoryService;

@CrossOrigin
@RestController
@RequestMapping("/")
public class SearchHistoryController {

	@Autowired
	private SearchHistoryService service;
	
	@GetMapping("/usd")
	
	public List<SearchHistory> getCurrencyUsd() {
		return service.
				SearchAndStoreCurrency("USD");
	}
	@GetMapping("/eur")
	public List<SearchHistory> getCurrencyEur() {
		return service.
				SearchAndStoreCurrency("EUR");
	}
	@GetMapping("/btc")
	public List<SearchHistory> getCurrencyBtc() {
		return service.
				SearchAndStoreCurrency("BTC");
	}
	@GetMapping("/all")
	public List<SearchHistory> getAllHistory() {
		return service.getAllHistory();
	}
}