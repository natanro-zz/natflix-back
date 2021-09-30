package io.natanro.demo.rest.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class LastEpisodeToAirDto {
    private LocalDate airDate;
    private Long episodeNumber;
    private Long id;
    private String name;
    private Long seasonNumber;
    private Double voteAverage;
    private Long voteCount;
}
