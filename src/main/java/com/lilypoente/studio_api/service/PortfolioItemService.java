package com.lilypoente.studio_api.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.lilypoente.studio_api.dto.PortfolioItemRequestDTO;
import com.lilypoente.studio_api.dto.PortfolioItemResponseDTO;
import com.lilypoente.studio_api.entity.PortfolioItem;
import com.lilypoente.studio_api.repository.PortfolioItemRepository;

@Service
public class PortfolioItemService {

    private final PortfolioItemRepository repository;

    public PortfolioItemService(PortfolioItemRepository repository) {
        this.repository = repository;
    }

    public List<PortfolioItemResponseDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(PortfolioItemResponseDTO::new)
                .toList();
    }

    public PortfolioItemResponseDTO create(PortfolioItemRequestDTO dto) {
        PortfolioItem item = new PortfolioItem(
                dto.title(),
                dto.category(),
                dto.description(),
                dto.imageUrl()
        );
        return new PortfolioItemResponseDTO(repository.save(item));
    }

    public PortfolioItemResponseDTO update(String id, PortfolioItemRequestDTO dto) {
        PortfolioItem item = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Projeto não encontrado"));

        item.setTitle(dto.title());
        item.setCategory(dto.category());
        item.setDescription(dto.description());
        item.setImageUrl(dto.imageUrl());

        return new PortfolioItemResponseDTO(repository.save(item));
    }

    public void delete(String id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Projeto não encontrado");
        }
        repository.deleteById(id);
    }
}