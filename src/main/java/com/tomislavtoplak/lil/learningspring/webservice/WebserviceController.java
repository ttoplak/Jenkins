package com.tomislavtoplak.lil.learningspring.webservice;

import com.tomislavtoplak.lil.learningspring.business.ReservationService;
import com.tomislavtoplak.lil.learningspring.business.RoomReservation;
import com.tomislavtoplak.lil.learningspring.data.Guest;
import com.tomislavtoplak.lil.learningspring.data.Room;
import com.tomislavtoplak.lil.learningspring.util.DateUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class WebserviceController {
    private final DateUtils dateUtils;
    private final ReservationService reservationService;

    public WebserviceController(DateUtils dateUtils, ReservationService reservationService) {
        this.dateUtils = dateUtils;
        this.reservationService = reservationService;
    }

    @RequestMapping(path="/reservations", method= RequestMethod.GET)
    public List<RoomReservation> getReservations(@RequestParam(value="date", required = false) String dateString) {
        Date date = this.dateUtils.createDateFromDateString(dateString);
        return this.reservationService.getRoomReservationsForDate(date);
    }

    @RequestMapping(path="/rooms", method= RequestMethod.GET)
    public List<Room> getRooms() {
        return this.reservationService.getRooms();
    }

    @RequestMapping(path="/guests", method= RequestMethod.POST)
    public Guest addGuest(@RequestBody Guest guest) {
        return this.reservationService.addGuest(guest);
    }
}
