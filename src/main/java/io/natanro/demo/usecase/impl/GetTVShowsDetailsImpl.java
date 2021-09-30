package io.natanro.demo.usecase.impl;

import feign.FeignException;
import io.natanro.demo.adapter.TVShowsAdapter;
import io.natanro.demo.config.exceptions.ApiException;
import io.natanro.demo.config.exceptions.TVShowNotFoundException;
import io.natanro.demo.external.gateway.TMDBGateway;
import io.natanro.demo.rest.dto.TVShowsDetailsDto;
import io.natanro.demo.usecase.GetTVShowsDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetTVShowsDetailsImpl implements GetTVShowsDetails {
    private final TMDBGateway tmdbGateway;

    @Override
    public TVShowsDetailsDto execute(Long id) {
        try {
            return TVShowsAdapter.convertToDetailsDto(tmdbGateway.getTVShowsDetails(id));
        } catch (FeignException.NotFound e) {
            throw new TVShowNotFoundException();
        } catch (FeignException e) {
            throw new ApiException(e);
        }
    }
}
