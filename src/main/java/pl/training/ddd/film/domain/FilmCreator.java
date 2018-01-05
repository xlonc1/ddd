package pl.training.ddd.film.domain;

import pl.training.ddd.film.dto.FilmDto;
import static java.util.Objects.requireNonNull;

class FilmCreator {
    Film from(FilmDto filmDto) {
        requireNonNull(filmDto);
        return Film.builder()
                .title(filmDto.getTitle())
                .type(FilmType.valueOf(filmDto.getType().name()))
                .build();
    }
}
