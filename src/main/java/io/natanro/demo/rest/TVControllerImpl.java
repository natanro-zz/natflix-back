package io.natanro.demo.rest;

import io.natanro.demo.adapter.TVShowsAdapter;
import io.natanro.demo.rest.dto.GeneralResponse;
import io.natanro.demo.rest.routes.ApiRoutes;
import io.natanro.demo.usecase.GetPopularTVShows;
import io.natanro.demo.usecase.GetTVShowsDetails;
import io.natanro.demo.usecase.GetTopRatedTVShows;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = ApiRoutes.BASE_URL_TV)
@RequiredArgsConstructor
public class TVControllerImpl implements TVController {
    private final GetTopRatedTVShows getTopRatedTVShows;
    private final GetPopularTVShows getPopularTVShows;
    private final GetTVShowsDetails getTVShowsDetails;

    @Override
    public GeneralResponse getPopularTVShows(Integer page) {
        return GeneralResponse.builder()
            .data(TVShowsAdapter.convertToDto(getPopularTVShows.execute(page)))
            .build();
    }

    @Override
    public GeneralResponse getTopRatedTVShows(Integer page) {
        return GeneralResponse.builder()
            .data(TVShowsAdapter.convertToDto(getTopRatedTVShows.execute(page)))
            .build();
    }

    @Override
    public GeneralResponse getTVShowsDetails(Long id) {
        return GeneralResponse.builder()
            .data(getTVShowsDetails.execute(id))
            .build();
    }
}
