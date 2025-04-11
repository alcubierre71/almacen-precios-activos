package com.universo.almacen.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.universo.almacen.controller.AssetManagementController;
import com.universo.almacen.dto.AssetDto;
import com.universo.almacen.dto.mapper.AssetMapper;
import com.universo.almacen.model.Asset;
import com.universo.almacen.service.AssetManagementService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/asset_price_store/asset")
@CrossOrigin(origins = "http://localhost:4200") // allow Angular to connect
@Tag(name = "Assets", description = "Asset management API for asset creation, update, delete, and retrieval")
public class AssetManagementControllerImpl implements AssetManagementController {

	@Autowired
	private AssetManagementService service;

	// http://localhost:7070/assetpricestore/assetmanagement/
	@Operation(summary = "List all assets ordered by code")
	//@RequestMapping(value={"/","/list"})
    @RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
	@Override
	public List<AssetDto> viewAsset() {
		// TODO Auto-generated method stub
		
		List<Asset> listAssets = service.obtainAssetOrderCode();
		
		//Function <? super Asset, ? extends Object> mapper = AssetMapper::toDto; 
		List<AssetDto> listAssetsDto = listAssets.stream().map(AssetMapper::toDto).toList();
		
		return listAssetsDto;

	}
	
	// http://localhost:7070/assetpricestore/assetmanagement/{id}
	@Operation(
	    summary = "Get asset by ID",
	    responses = {
	        @ApiResponse(responseCode = "200", description = "Asset found"),
	        @ApiResponse(responseCode = "404", description = "Asset not found")
	    }
	)
	@GetMapping("/{id}")
	public ResponseEntity<AssetDto> getAsset(@PathVariable Long id) {
		Asset asset = service.get(id);
		
		AssetDto assetDto = AssetMapper.toDto(asset);
		
	    return ResponseEntity.ok(assetDto);
	}

//	@RequestMapping(value={"/create"})
//	@Override
//	public String showFormCreateAsset(@RequestBody Asset asset) {
//		// TODO Auto-generated method stub
//		
//		Asset asset = new Asset();
//		
//		model.addAttribute("asset", asset);
//		
//		return "views/create_asset";
//		
//	}

	@Operation(summary = "Save a new asset")
	@PostMapping(value="/save")
	@Override
	public ResponseEntity<Object> saveAsset(@Valid @RequestBody AssetDto assetDto) {
		// TODO Auto-generated method stub
		
		Asset asset = AssetMapper.toEntity(assetDto);
				
		service.save(asset);
		
		// Return to the HOME PAGE
		return ResponseEntity.ok().build();
		
	}

//	@RequestMapping("/edit/{id}")
//	@Override
//	public ModelAndView showFormEditAsset(Long id) {
//		// TODO Auto-generated method stub
//		
//		ModelAndView mav = new ModelAndView("views/editar_activo");
//		
//		// Obtain the asset
//		Asset asset = service.get(id);
//		
//		// Add to the model
//		mav.addObject("asset", asset);
//		
//		return mav;
//		
//	}

	
	@Operation(summary = "Update an existing asset")
	@PutMapping("/update/{id}")
	public ResponseEntity<AssetDto> updateAsset(@PathVariable Long id, @Valid @RequestBody AssetDto updatedAssetDto) {
	    // Ensure the asset exists
		
		Asset updatedAsset = AssetMapper.toEntity(updatedAssetDto);
		
	    Asset existingAsset = service.get(id);

	    // Update fields (you can also use a mapper here)
	    existingAsset.setCode(updatedAsset.getCode());
	    existingAsset.setDescription(updatedAsset.getDescription());
	    existingAsset.setType(updatedAsset.getType());
	    existingAsset.setSector(updatedAsset.getSector());
	    existingAsset.setMarket(updatedAsset.getMarket());
	    existingAsset.setCodeAlt(updatedAsset.getCodeAlt());

	    // Save updated asset
	    service.save(existingAsset);
	    
	    AssetDto existingAssetDto = AssetMapper.toDto(existingAsset);

	    return ResponseEntity.ok(existingAssetDto);
	}

	@Operation(summary = "Delete asset by ID")
	@DeleteMapping("/delete/{id}")
	@Override
	public ResponseEntity<Object> deleteAsset(@PathVariable Long id) {
		// TODO Auto-generated method stub
		
		service.delete(id);
		
		// Return to the HOME PAGE
		return ResponseEntity.noContent().build();
		
	}
	
}
