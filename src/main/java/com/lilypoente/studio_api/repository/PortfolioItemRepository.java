package com.lilypoente.studio_api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.lilypoente.studio_api.entity.PortfolioItem;

@Repository
public interface PortfolioItemRepository extends MongoRepository<PortfolioItem, String> {
}