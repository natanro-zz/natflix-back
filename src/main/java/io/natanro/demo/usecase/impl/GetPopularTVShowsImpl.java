package io.natanro.demo.usecase.impl;

import io.natanro.demo.adapter.TVShowsAdapter;
import io.natanro.demo.domain.TVShows;
import io.natanro.demo.external.gateway.TMDBGateway;
import io.natanro.demo.usecase.GetPopularTVShows;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetPopularTVShowsImpl implements GetPopularTVShows {
    private final TMDBGateway tmdbGateway;

    @Override
    public List<TVShows> execute(Integer page) {
        return TVShowsAdapter.convertToDomain(tmdbGateway.getPopularTVShows(page));
    }
}
