package com.lilypoente.studio_api.dto;

import jakarta.validation.constraints.NotBlank;

public record PortfolioItemRequestDTO(
    @NotBlank(message = "O título é obrigatório")
    String title,

    @NotBlank(message = "A categoria é obrigatória")
    String category,

    String description,

    @NotBlank(message = "A URL da imagem é obrigatória")
    String imageUrl
) {}