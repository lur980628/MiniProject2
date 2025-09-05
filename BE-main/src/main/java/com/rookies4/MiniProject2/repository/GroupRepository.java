package com.rookies4.MiniProject2.repository;

import com.rookies4.MiniProject2.domain.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Long> {
}