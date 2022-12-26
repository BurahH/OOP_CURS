package com.Server.repos;

import com.API.domain.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneRepos extends JpaRepository<Phone, Long> {
}
