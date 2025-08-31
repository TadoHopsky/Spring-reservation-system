package org.reservationsystem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.reservationsystem.CustomColoriOutput.ANSI_CYAN;
import static org.reservationsystem.CustomColoriOutput.ANSI_RESET;

@RestController
public class ReservationController {
    private final Logger logger = LoggerFactory.getLogger(ReservationController.class);
    private final ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Reservation>> getReservationByID(
            @PathVariable("id") Long id) {
        logger.info(ANSI_CYAN + "Вызвался метод getReservationByID с ID : {}" + ANSI_RESET, id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(reservationService.getReservationByID(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Reservation>> getAllReservations() {
        logger.info(ANSI_CYAN + "Вызвался метод getAllReservations" + ANSI_RESET);
        return ResponseEntity.status(HttpStatus.OK)
                .body(reservationService.getAllReservation());
    }

    @PostMapping()
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation newReservation) {
        logger.info(ANSI_CYAN + "Создание нового объекта Reservation" + ANSI_RESET);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(reservationService.createReservation(newReservation));
    }
}
