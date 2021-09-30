package io.natanro.demo.adapter;

import io.natanro.demo.domain.Movie;
import io.natanro.demo.external.gateway.dto.MovieDetailsResponse;
import io.natanro.demo.external.gateway.dto.MovieResponse;
import io.natanro.demo.rest.dto.MovieDetailsDto;
import io.natanro.demo.rest.dto.MovieDto;
import io.natanro.demo.rest.dto.SpokenLanguagesDto;
import lombok.experimental.UtilityClass;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class MovieAdapter {

    public static Movie toDomain(MovieResponse response) {
        var movie = Movie.builder().build();
        BeanUtils.copyProperties(response, movie);
        return movie;
    }

    public static List<Movie> convertToDomain(List<MovieResponse> responses) {
        return responses.stream()
            .map(MovieAdapter::toDomain)
            .collect(Collectors.toList());
    }
    
    public static MovieDto toDto(Movie movie) {
        var movieDto = MovieDto.builder().build();
        BeanUtils.copyProperties(movie, movieDto);
        return movieDto;
    }
    
    public static List<MovieDto> convertToDto(List<Movie> movies) {
        return movies.stream()
            .map(MovieAdapter::toDto)
            .collect(Collectors.toList());
    }

    public static MovieDetailsDto convertToDetailsDto(MovieDetailsResponse movieDetails) {
        var dto = MovieDetailsDto.builder().build();
        BeanUtils.copyProperties(movieDetails, dto);
        setSpokenLanguagesList(movieDetails, dto);
        return dto;
    }

    private static void setSpokenLanguagesList(MovieDetailsResponse movieDetails, MovieDetailsDto dto) {
        List<SpokenLanguagesDto> spokenLanguages = new ArrayList<>();
        movieDetails.getSpokenLanguages().forEach(sLR -> {
            var sLD = SpokenLanguagesDto.builder().build();
            BeanUtils.copyProperties(sLR, sLD);
            spokenLanguages.add(sLD);
        });
        dto.setSpokenLanguages(spokenLanguages);
    }
}
