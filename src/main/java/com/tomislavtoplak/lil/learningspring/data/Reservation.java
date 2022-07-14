package com.tomislavtoplak.lil.learningspring.data;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="RESERVATION")
public class Reservation {
    @Id
    @GeneratedValue
    @Column(name="RESERVATION_ID")
    private long id;
    @ManyToOne
    @JoinColumn(name="ROOM_ID", referencedColumnName="ROOM_ID")
    private Room room;
    @ManyToOne
    @JoinColumn(name="GUEST_ID", referencedColumnName="GUEST_ID")
    private Guest guest;
    @Column(name="RES_DATE")
    @DateTimeFormat
    private Date date;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", room=" + room +
                ", guest=" + guest +
                ", date=" + date +
                '}';
    }
}
