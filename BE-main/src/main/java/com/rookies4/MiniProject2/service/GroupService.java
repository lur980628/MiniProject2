package com.rookies4.MiniProject2.service;

import com.rookies4.MiniProject2.domain.Group;
import com.rookies4.MiniProject2.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GroupService {

    private final GroupRepository groupRepository;

    @Autowired
    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Transactional
    public Group createGroup(Group group) {
        // 모임 생성 비즈니스 로직 추가
        // 예: 모임 상태를 "PENDING"으로 설정
        group.setStatus("PENDING");
        return groupRepository.save(group);
    }
}