package pl.training.ddd.infrastructure.mvc;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.training.ddd.film.dto.FilmNotFoundException;

@ControllerAdvice
class ExceptionHandlingAdvice {

    @ExceptionHandler(FilmNotFoundException.class)
    ResponseEntity<ErrorMessage> handleNotFoundFilms(FilmNotFoundException e) {
        ErrorMessage errorMessage = new ErrorMessage(e.getMessage());
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }

    @Getter
    @AllArgsConstructor
    class ErrorMessage {
        private String message;
        private String details;

        public ErrorMessage(String message) {
            this.message = message;
        }
    }
}
