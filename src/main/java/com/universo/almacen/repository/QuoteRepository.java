package com.universo.almacen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.universo.almacen.model.Quote;

@Repository
public interface QuoteRepository extends JpaRepository<Quote, Long> {

	// Obtain Quote order by date
	@Query(value="SELECT q FROM Quote q " +
			" ORDER BY date ASC " )
	public List<Quote> getQuoteOrderDate();
	
}
