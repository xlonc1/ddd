package pl.training.ddd.film.dto;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * @author Arkadiusz Parzych
 * @since 05.01.18
 */
@Builder
@Getter
@EqualsAndHashCode
public class FilmDto {
  private String title;
  private FilmTypeDto type;
}
