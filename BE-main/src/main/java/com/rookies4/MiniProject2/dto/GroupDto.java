package com.rookies4.MiniProject2.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

public class GroupDto {

    @Getter
    @Setter
    @NoArgsConstructor
    public static class CreateRequest {
        @NotBlank(message = "모임 이름은 필수 입력 항목입니다.")
        private String groupName;
        
        @NotNull(message = "지역 ID는 필수 입력 항목입니다.")
        private Integer regionId;
        
        @NotNull(message = "종목 ID는 필수 입력 항목입니다.")
        private Integer sportId;
        
        private String description;
        
        @NotNull(message = "최대 인원수는 필수 입력 항목입니다.")
        private int maxMembers;
        
        @NotNull(message = "모임 시간은 필수 입력 항목입니다.")
        private LocalDateTime meetingTime;

        @NotBlank(message = "모임 장소는 필수 입력 항목입니다.")
        private String location;
    }
}