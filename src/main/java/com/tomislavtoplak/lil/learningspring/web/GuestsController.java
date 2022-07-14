package com.tomislavtoplak.lil.learningspring.web;

import com.tomislavtoplak.lil.learningspring.business.GuestData;
import com.tomislavtoplak.lil.learningspring.business.GuestService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/guests")
public class GuestsController {
    private final GuestService guestService;

    public GuestsController(GuestService guestService) {
        this.guestService = guestService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getGuests(Model model) {
        List<GuestData> guestsData = this.guestService.getAllGuestsData();
        model.addAttribute("guestsData", guestsData);
        return "guests";
    }
}
