package io.natanro.demo.rest;

import io.natanro.demo.adapter.MovieAdapter;
import io.natanro.demo.rest.dto.GeneralResponse;
import io.natanro.demo.rest.routes.ApiRoutes;
import io.natanro.demo.usecase.GetMovieDetails;
import io.natanro.demo.usecase.GetPopularMovies;
import io.natanro.demo.usecase.GetTopRatedMovies;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = ApiRoutes.BASE_URL_MOVIE)
@RequiredArgsConstructor
public class MovieControllerImpl implements MovieController {
    private final GetPopularMovies getPopularMovies;
    private final GetTopRatedMovies getTopRatedMovies;
    private final GetMovieDetails getMovieDetails;

    @Override
    public GeneralResponse getPopularMovies(Integer page) {
        return GeneralResponse.builder()
            .data(MovieAdapter.convertToDto(getPopularMovies.execute(page)))
            .build();
    }

    @Override
    public GeneralResponse getTopRatedMovies(Integer page) {
        return GeneralResponse.builder()
            .data(MovieAdapter.convertToDto(getTopRatedMovies.execute(page)))
            .build();
    }

    @Override
    public GeneralResponse getMovieDetails(Long id) {
        return GeneralResponse.builder()
            .data(getMovieDetails.execute(id))
            .build();
    }
}
