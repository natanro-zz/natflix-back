package io.natanro.demo.usecase;

import io.natanro.demo.domain.TVShows;

import java.util.List;

public interface GetTopRatedTVShows {
    List<TVShows> execute(Integer page);
}
