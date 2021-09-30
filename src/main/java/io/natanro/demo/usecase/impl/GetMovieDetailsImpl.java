package io.natanro.demo.usecase.impl;

import feign.FeignException;
import io.natanro.demo.adapter.MovieAdapter;
import io.natanro.demo.config.exceptions.ApiException;
import io.natanro.demo.config.exceptions.MovieNotFoundException;
import io.natanro.demo.external.gateway.TMDBGateway;
import io.natanro.demo.rest.dto.MovieDetailsDto;
import io.natanro.demo.usecase.GetMovieDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetMovieDetailsImpl implements GetMovieDetails {
    private final TMDBGateway tmdbGateway;

    @Override
    public MovieDetailsDto execute(Long id) {
        try {
            return MovieAdapter.convertToDetailsDto(tmdbGateway.getMovieDetails(id));
        } catch (FeignException.NotFound e) {
            throw new MovieNotFoundException();
        } catch (FeignException e) {
            throw new ApiException(e);
        }
    }
}
