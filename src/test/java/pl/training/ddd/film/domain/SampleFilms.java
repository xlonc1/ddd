package pl.training.ddd.film.domain;

import pl.training.ddd.film.dto.FilmDto;
import pl.training.ddd.film.dto.FilmTypeDto;

/**
 * @author Arkadiusz Parzych
 * @since 05.01.18
 */
public interface SampleFilms {
  FilmDto trumper = createFilmDto("50 shades of Trumpet", FilmTypeDto.NEW);
  FilmDto clingon = createFilmDto("American Clingon Bondage", FilmTypeDto.OLD);

  static FilmDto createFilmDto(String title, FilmTypeDto type) {
    return FilmDto.builder()
        .title(title)
        .type(type)
        .build();
  }
}
