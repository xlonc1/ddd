package pl.training.ddd.film.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import pl.training.ddd.film.dto.FilmDto;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Arkadiusz Parzych
 * @since 05.01.18
 */
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Film {

  @Id
  private String title;
  private FilmType type;

  FilmDto dto() {
    return FilmDto.builder()
        .title(title)
        .type(type.dto())
        .build();
  }
}
