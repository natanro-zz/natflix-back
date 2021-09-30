package io.natanro.demo.external.gateway;

import io.natanro.demo.external.gateway.dto.MovieDetailsResponse;
import io.natanro.demo.external.gateway.dto.MovieResponse;
import io.natanro.demo.external.gateway.dto.TVShowsDetails;
import io.natanro.demo.external.gateway.dto.TVShowsResponse;

import java.util.List;

public interface TMDBGateway {
    List<MovieResponse> getPopularMovies(Integer page);
    List<MovieResponse> getTopRatedMovies(Integer page);
    List<TVShowsResponse> getPopularTVShows(Integer page);
    List<TVShowsResponse> getTopRatedTVShows(Integer page);
    MovieDetailsResponse getMovieDetails(Long id);
    TVShowsDetails getTVShowsDetails(Long id);
}
