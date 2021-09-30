package io.natanro.demo.rest;

import io.natanro.demo.rest.dto.GeneralResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

public interface MovieController {
    @Operation(summary = "Get popular movies",
        description = "Endpoint to retrieve all popular movies in a page",
        parameters = {
            @Parameter(name = "page",
                description = "the number of the page to read the movies from",
                in = ParameterIn.QUERY)
        },
        responses = {
            @ApiResponse(responseCode = "200", description = "Movies were retrieved successfully"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
        })
    @GetMapping(path = "/movies/popular")
    GeneralResponse getPopularMovies(@RequestParam(required = false, defaultValue = "1") Integer page);

    @Operation(summary = "Get top rated movies",
        description = "Endpoint to retrieve all top rated movies in a page",
        parameters = {
            @Parameter(name = "page",
                description = "the number of the page to read the movies from",
                in = ParameterIn.QUERY)
        },
        responses = {
            @ApiResponse(responseCode = "200", description = "Movies were retrieved successfully"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
        })
    @GetMapping(path = "/movies/top_rated")
    GeneralResponse getTopRatedMovies(@RequestParam(required = false, defaultValue = "1") Integer page);

    @Operation(summary = "Get movie details",
        description = "Endpoint to retrieve details from a given movie",
        parameters = {
            @Parameter(name = "id",
                description = "movie id",
                in = ParameterIn.PATH)
        },
        responses = {
            @ApiResponse(responseCode = "200", description = "Movies were retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "Movie id is not valid"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
        })
    @GetMapping(path = "/movie/{id}")
    GeneralResponse getMovieDetails(@PathVariable Long id);
}
