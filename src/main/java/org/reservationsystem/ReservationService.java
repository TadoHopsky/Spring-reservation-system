package org.reservationsystem;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    private final List<Reservation> reservations = new ArrayList<>();
    {
        reservations.add(new Reservation(
                1L,
                100L,
                40L,
                LocalDate.now(),
                LocalDate.now().plusDays(5),
                ReservationStatus.APPROVED));

        reservations.add(new Reservation(
                2L,
                100L,
                40L,
                LocalDate.now(),
                LocalDate.now().plusDays(5),
                ReservationStatus.APPROVED));

        reservations.add(new Reservation(
                3L,
                100L,
                40L,
                LocalDate.now(),
                LocalDate.now().plusDays(5),
                ReservationStatus.APPROVED));
    }

    public Optional<Reservation> getReservationByID(Long id) {
        return reservations.stream()
                .filter(r -> r.id().equals(id))
                .findFirst();
    }

    public List<Reservation> getAllReservation(){
        return reservations;
    }

    public Reservation createReservation(Reservation newReservation) {
        long index = reservations.getLast().id();
        if(newReservation.id() != null) {
            throw new IllegalArgumentException("Reservation ID must not be null");
        }
        if(newReservation.status() != null) {
            throw new IllegalArgumentException("Reservation status must not be null");
        }
        var res =  new Reservation(index + 1,
                newReservation.userID(),
                newReservation.roomID(),
                newReservation.startDate(),
                newReservation.endDate(),
                ReservationStatus.APPROVED
        );
        reservations.add(res);
        return res;
    }
}
