package io.natanro.demo.usecase.impl;

import io.natanro.demo.adapter.MovieAdapter;
import io.natanro.demo.domain.Movie;
import io.natanro.demo.external.gateway.TMDBGateway;
import io.natanro.demo.usecase.GetTopRatedMovies;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetTopRatedMoviesImpl implements GetTopRatedMovies {
    private final TMDBGateway tmdbGateway;

    @Override
    public List<Movie> execute(Integer page) {
        return MovieAdapter.convertToDomain(tmdbGateway.getTopRatedMovies(page));
    }
}
