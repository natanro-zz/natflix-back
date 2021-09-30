package io.natanro.demo.external.gateway.impl;

import io.natanro.demo.external.client.TMDBClient;
import io.natanro.demo.external.client.TMDBClientParams;
import io.natanro.demo.external.gateway.TMDBGateway;
import io.natanro.demo.external.gateway.dto.MovieDetailsResponse;
import io.natanro.demo.external.gateway.dto.MovieResponse;
import io.natanro.demo.external.gateway.dto.TVShowsDetails;
import io.natanro.demo.external.gateway.dto.TVShowsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TMDBGatewayImpl implements TMDBGateway {

    private final TMDBClient tmdbClient;
    @Value("${tmdb.api.key}")
    private String apiKey;

    @Override
    public List<MovieResponse> getPopularMovies(Integer page) {
        return tmdbClient.getPopularMovies(TMDBClientParams.builder()
            .api_key(apiKey).page(page).build()).getResults();
    }

    @Override
    public List<MovieResponse> getTopRatedMovies(Integer page) {
        return tmdbClient.getTopRatedMovies(TMDBClientParams.builder()
            .api_key(apiKey).page(page).build()).getResults();
    }

    @Override
    public List<TVShowsResponse> getPopularTVShows(Integer page) {
        return tmdbClient.getPopularTVShows(TMDBClientParams.builder()
            .api_key(apiKey).page(page).build()).getResults();
    }

    @Override
    public List<TVShowsResponse> getTopRatedTVShows(Integer page) {
        return tmdbClient.getTopRatedTVShows(TMDBClientParams.builder()
            .api_key(apiKey).page(page).build()).getResults();
    }

    @Override
    public MovieDetailsResponse getMovieDetails(Long id) {
        return tmdbClient.getMovieDetails(id, TMDBClientParams.builder()
            .api_key(apiKey).build());
    }

    @Override
    public TVShowsDetails getTVShowsDetails(Long id) {
        return tmdbClient.getTVShowsDetails(id, TMDBClientParams.builder()
            .api_key(apiKey).build());
    }
}
