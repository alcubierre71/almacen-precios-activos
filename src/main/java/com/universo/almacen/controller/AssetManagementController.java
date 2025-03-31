package com.universo.almacen.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.universo.almacen.dto.AssetDto;
import com.universo.almacen.model.Asset;

public interface AssetManagementController {

	public List<AssetDto> viewAsset();
	
	public ResponseEntity<AssetDto> getAsset(Long id);
	
	//public String showFormCreateAsset(Model model); // Esto se gestiona en Angular
	
	public ResponseEntity<Object> saveAsset(AssetDto assetDto);
	
	// public ModelAndView showFormEditAsset(@PathVariable(name="id") Long id);   // Esto se gestiona en Angular 
	
	public ResponseEntity<AssetDto> updateAsset(Long id, AssetDto updatedAssetDto);
	
	public ResponseEntity<Object> deleteAsset(Long id);
	
}
