package com.example.computerConfigurator.repository;

import com.example.computerConfigurator.blocks.CaseBlock;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CaseBlockRepository extends CrudRepository<CaseBlock, Integer> {
    Optional<CaseBlock> findFirstByOrderByIdDesc();
}
