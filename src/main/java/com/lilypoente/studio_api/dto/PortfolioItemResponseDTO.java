package com.lilypoente.studio_api.dto;

import com.lilypoente.studio_api.entity.PortfolioItem;

public record PortfolioItemResponseDTO(
    String id,
    String title,
    String category,
    String description,
    String imageUrl
) {
    public PortfolioItemResponseDTO(PortfolioItem entity) {
        this(
            entity.getId(),
            entity.getTitle(),
            entity.getCategory(),
            entity.getDescription(),
            entity.getImageUrl()
        );
    }
}