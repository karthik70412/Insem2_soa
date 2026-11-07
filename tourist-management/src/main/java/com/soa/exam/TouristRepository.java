package com.soa.exam;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TouristRepository
        extends JpaRepository<Tourist, Long> {

}