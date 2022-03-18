package com.example.computerConfigurator.repository;

import com.example.computerConfigurator.blocks.VideoCard;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface GpuRepository extends CrudRepository<VideoCard, Integer> {
    Optional<VideoCard> findFirstByOrderByIdDesc();
}
