package com.universo.almacen.dto.mapper;

import com.universo.almacen.dto.AssetDto;
import com.universo.almacen.model.Asset;

public class AssetMapper {

	// Convert Asset Entity to Asset Dto
    public static AssetDto toDto(Asset asset) {
        AssetDto dto = new AssetDto();
        dto.setId(asset.getId());
        dto.setCode(asset.getCode());
        dto.setDescription(asset.getDescription());
        dto.setType(asset.getType());
        dto.setSector(asset.getSector());
        dto.setMarket(asset.getMarket());
        dto.setCodeAlt(asset.getCodeAlt());
        return dto;
    }

    // Convert Asset Dto to Asset Entity
    public static Asset toEntity(AssetDto dto) {
        Asset asset = new Asset();
        asset.setId(dto.getId());
        asset.setCode(dto.getCode());
        asset.setDescription(dto.getDescription());
        asset.setType(dto.getType());
        asset.setSector(dto.getSector());
        asset.setMarket(dto.getMarket());
        asset.setCodeAlt(dto.getCodeAlt());
        return asset;
    }
    
}
