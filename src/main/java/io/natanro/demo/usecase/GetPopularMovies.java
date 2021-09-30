package io.natanro.demo.usecase;

import io.natanro.demo.domain.Movie;

import java.util.List;

public interface GetPopularMovies {
    List<Movie> execute(Integer page);
}
