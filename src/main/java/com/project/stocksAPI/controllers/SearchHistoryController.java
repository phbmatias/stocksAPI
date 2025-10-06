package com.project.stocksAPI.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.stocksAPI.models.SearchHistory;
import com.project.stocksAPI.services.SearchHistoryService;

@RestController
@RequestMapping("/")
public class SearchHistoryController {

	@Autowired
	private SearchHistoryService service;
	
	@GetMapping
	public List<SearchHistory> getCurrency() {
		return service.
				SearchAndStoreCurrency();
	}
	
}
