package com.rookies4.MiniProject2.repository;

import com.rookies4.MiniProject2.domain.Region;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionRepository extends JpaRepository<Region, Long> {
}