package com.universo.almacen.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssetDto {

    private Long   id;
    @NotBlank(message = "Code is required")
    @Size(max = 50, message = "Code must be at most 50 characters")
    private String code;
    @NotBlank(message = "Description is required")
    private String description;
    @NotBlank(message = "Type is required")
    private String type;
    @NotBlank(message = "Sector is required")
    private String sector;
    @NotBlank(message = "Narjet is required")
    private String market;
    @Size(max = 50, message = "CodeAlt maximum is 50 characters")
    private String codeAlt;
    
}
