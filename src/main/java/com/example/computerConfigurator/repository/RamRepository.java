package com.example.computerConfigurator.repository;

import com.example.computerConfigurator.blocks.Ram;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RamRepository extends CrudRepository<Ram, Integer> {
    Optional<Ram> findFirstByOrderByIdDesc();
}
