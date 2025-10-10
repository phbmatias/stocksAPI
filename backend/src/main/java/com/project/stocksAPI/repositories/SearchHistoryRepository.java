package com.project.stocksAPI.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.stocksAPI.models.SearchHistory;

public interface SearchHistoryRepository extends JpaRepository<SearchHistory, Long> {
	// Ao acordar, Gregor Samsa havia virado um inseto. E sua primeira preocupação… era não se atrasar pro trabalho.
}