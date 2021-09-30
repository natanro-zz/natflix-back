package io.natanro.demo.usecase;

import io.natanro.demo.rest.dto.MovieDetailsDto;

public interface GetMovieDetails {
    MovieDetailsDto execute(Long id);
}
