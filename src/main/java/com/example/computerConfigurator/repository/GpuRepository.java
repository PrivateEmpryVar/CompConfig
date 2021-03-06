package com.example.computerConfigurator.repository;

import com.example.computerConfigurator.blocks.VideoCard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GpuRepository extends CrudRepository<VideoCard, Integer> {
    Optional<VideoCard> findFirstByOrderByIdDesc();
}
