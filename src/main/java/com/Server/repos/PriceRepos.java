package com.Server.repos;

import com.API.domain.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepos extends JpaRepository<Price, Long> {
}
