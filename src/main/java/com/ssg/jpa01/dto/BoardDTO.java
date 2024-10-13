package com.ssg.jpa01.dto;

import jakarta.persistence.Column;
import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class BoardDTO {
    private Long bno;
    private String title;
    private String content;
    private String writer;
    private LocalDateTime registerDate;
}
