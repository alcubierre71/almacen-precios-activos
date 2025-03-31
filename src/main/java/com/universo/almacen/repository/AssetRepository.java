package com.universo.almacen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.universo.almacen.model.Asset;

@Repository
public interface AssetRepository extends JpaRepository<Asset, Long> {

	// Obtain Assets order by Code
	@Query(value="SELECT a FROM Asset a " + 
			" ORDER BY code ASC " )
	public List<Asset> getAssetOrderCode();
	
}
