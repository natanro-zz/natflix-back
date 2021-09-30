package io.natanro.demo.usecase;

import io.natanro.demo.rest.dto.TVShowsDetailsDto;

public interface GetTVShowsDetails {
    TVShowsDetailsDto execute(Long id);
}
