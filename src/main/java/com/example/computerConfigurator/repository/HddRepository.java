package com.example.computerConfigurator.repository;

import com.example.computerConfigurator.blocks.Hdd;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HddRepository extends CrudRepository<Hdd, Integer> {
    Optional<Hdd> findFirstByOrderByIdDesc();
}
