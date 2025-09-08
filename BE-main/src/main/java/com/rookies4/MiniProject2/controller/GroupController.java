package com.rookies4.MiniProject2.controller;

import com.rookies4.MiniProject2.domain.entity.Group;
import com.rookies4.MiniProject2.domain.enums.ApprovalStatus;
import com.rookies4.MiniProject2.repository.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/groups")
@RequiredArgsConstructor
public class GroupController {
    private final GroupRepository groupRepository;

    @GetMapping
    public List<Group> getGroups(
            @RequestParam(required = false) Integer regionId,
            @RequestParam(required = false) Integer sportId) {

        ApprovalStatus approvedStatus = ApprovalStatus.APPROVED;

        if (regionId != null && sportId != null) {
            return groupRepository.findByRegionIdAndSportIdAndApprovalStatus(regionId, sportId, approvedStatus);
        } else if (regionId != null) {
            return groupRepository.findByRegionIdAndApprovalStatus(regionId, approvedStatus);
        } else if (sportId != null) {
            return groupRepository.findBySportIdAndApprovalStatus(sportId, approvedStatus);
        } else {
            return groupRepository.findByApprovalStatus(approvedStatus);
        }
    }
}