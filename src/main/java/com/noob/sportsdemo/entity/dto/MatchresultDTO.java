package com.noob.sportsdemo.entity.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class MatchresultDTO {
    private String matchStatus;
    private String matchScore;
    private String matchPlayer;
    private String matchRank;
    private int matchId;
}
