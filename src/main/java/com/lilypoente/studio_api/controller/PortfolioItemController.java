package com.lilypoente.studio_api.controller;

import com.lilypoente.studio_api.dto.PortfolioItemRequestDTO;
import com.lilypoente.studio_api.dto.PortfolioItemResponseDTO;
import com.lilypoente.studio_api.service.PortfolioItemService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/portfolio")
public class PortfolioItemController {

    private final PortfolioItemService service;

    public PortfolioItemController(PortfolioItemService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<PortfolioItemResponseDTO>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping
    public ResponseEntity<PortfolioItemResponseDTO> create(@Valid @RequestBody PortfolioItemRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PortfolioItemResponseDTO> update(
            @PathVariable String id,
            @Valid @RequestBody PortfolioItemRequestDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}