package com.universo.almacen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.universo.almacen.model.Quote;
import com.universo.almacen.repository.QuoteRepository;

@Service
public class QuoteService {

	@Autowired
	private QuoteRepository repo;

	
	/* 
	 * Save quotes of the asset
	 */
	public void saveQuotes (List<Quote> listEntry) {
		
		List<Quote> listQuotes = listEntry;
		
		//for (Quote quoteItem : listQuotes) {
		//	repo.save(quoteItem);
		//}
		
		repo.saveAll(listEntry);
		
	}
	
}
