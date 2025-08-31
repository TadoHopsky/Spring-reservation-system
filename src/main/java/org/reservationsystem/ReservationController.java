package org.reservationsystem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ReservationController {
    private final Logger logger = LoggerFactory.getLogger(ReservationController.class);
    private final ReservationService reservationService;

    @Autowired
    public ReservationController(
            ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/{id}")
    public Optional<Reservation> getReservationByID(
            @PathVariable("id") Long id) {                             // Получение ID через GET запрос
        logger.info("Вызвался метод getReservationByID с ID {}", id);
        return reservationService.getReservationByID(id);
    }

    @GetMapping("/all")
    public List<Reservation> getAllReservations() {
        logger.info("Вызвался метод getAllReservations");
        return reservationService.getAllReservation();
    }
}
