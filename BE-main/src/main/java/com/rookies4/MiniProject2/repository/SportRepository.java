package com.rookies4.MiniProject2.repository;

import com.rookies4.MiniProject2.domain.Sport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SportRepository extends JpaRepository<Sport, Long> {
}