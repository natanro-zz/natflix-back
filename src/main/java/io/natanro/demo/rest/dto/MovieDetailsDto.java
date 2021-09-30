package io.natanro.demo.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class MovieDetailsDto extends MovieDto {
    private String homepage;
    private Long runtime;
    private List<SpokenLanguagesDto> spokenLanguages;
    private String status;
    private String tagline;
}
