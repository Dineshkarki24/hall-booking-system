package com.hrutility.hrutilityjava.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class HallRequestDTO {
    @NotBlank(message = "Name is required")
    private String name;
    @NotBlank(message = "Image is reuired")
    private String image;
    private String description;
}
