package com.universo.almacen.service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.universo.almacen.exception.ResourceNotFoundException;
import com.universo.almacen.model.Asset;
import com.universo.almacen.repository.AssetRepository;



@Service
public class AssetManagementService {

	@Autowired
	private AssetRepository repo;

	// READ
	public List<Asset> listAll() {
		return repo.findAll();
	}
	
	// CREATE
	public void save(Asset asset) {
		repo.save(asset);
	}
	
	// UPDATE
	public Asset get(Long id) {
		
		Supplier <? extends ResourceNotFoundException> exceptionSupplier = () -> new ResourceNotFoundException("Asset with id " + id + " not found");
		
		Asset asset = repo.findById(id).orElseThrow( exceptionSupplier );
		
		return asset;
	}
	
	// DELETE
	public void delete(Long id) {
		
		// Check existence of Asset before deleting
		if (!repo.existsById(id)) {
			throw new ResourceNotFoundException("Asset with id " + id + " not found");
		}
		
		repo.deleteById(id);
	}
	
	// ASSET - order by code
	public List<Asset> obtainAssetOrderCode() {
		
		List<Asset> listAsset = repo.getAssetOrderCode();
		
		return listAsset;
	}
	
}
