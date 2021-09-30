package io.natanro.demo.usecase.impl;

import io.natanro.demo.adapter.TVShowsAdapter;
import io.natanro.demo.domain.TVShows;
import io.natanro.demo.external.gateway.TMDBGateway;
import io.natanro.demo.usecase.GetTopRatedTVShows;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetTopRatedTVShowsImpl implements GetTopRatedTVShows {

    private final TMDBGateway gateway;

    @Override
    public List<TVShows> execute(Integer page) {
        return TVShowsAdapter.convertToDomain(gateway.getTopRatedTVShows(page));
    }
}
