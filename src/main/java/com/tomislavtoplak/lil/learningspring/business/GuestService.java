package com.tomislavtoplak.lil.learningspring.business;

import com.tomislavtoplak.lil.learningspring.data.GuestRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GuestService {
    private final GuestRepository guestRepository;

    public GuestService(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    public List<GuestData> getAllGuestsData() {
        List<GuestData> guestsData = new ArrayList<>();
        this.guestRepository.findAll().forEach(guest -> {
            GuestData data = new GuestData();
            data.setFirstName(guest.getFirstName());
            data.setLastName(guest.getLastName());
            data.setEmailAddress(guest.getEmailAddress());
            data.setPhoneNumber(guest.getPhoneNumber());
            guestsData.add(data);
        });

        return guestsData;
    }
}
