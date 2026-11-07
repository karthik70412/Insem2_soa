package com.soa.exam;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class TouristService {

    @Autowired
    private TouristRepository repository;

    public List<Tourist> getAllTourists() {
        return repository.findAll();
    }
    
    public Tourist saveTourist(Tourist tourist) {
        return repository.save(tourist);
    }
}