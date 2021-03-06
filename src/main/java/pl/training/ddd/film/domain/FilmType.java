package pl.training.ddd.film.domain;

import pl.training.ddd.film.dto.FilmTypeDto;
import java.math.BigDecimal;

enum FilmType {
    NEW(40), REGULAR(30), OLD(30);

    private BigDecimal price;

    FilmType(long price) {
        this(BigDecimal.valueOf(price));
    }

    FilmType(BigDecimal price) {
        this.price = price;
    }

    FilmTypeDto dto() {
        return FilmTypeDto.valueOf(name());
    }
}
