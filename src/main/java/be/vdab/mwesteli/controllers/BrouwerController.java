package be.vdab.mwesteli.controllers;

import be.vdab.mwesteli.entities.Bier;
import be.vdab.mwesteli.entities.Brouwer;
import be.vdab.mwesteli.services.BierService;
import be.vdab.mwesteli.services.BrouwerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Maarten Westelinck on 13/03/2017 for bierhuis.
 */
@Controller
@RequestMapping("/brouwers")
class BrouwerController {
    private static final String VIEW = "brouwers";
    private static final String BROUWER_VIEW = "brouwer";
    private final BrouwerService brouwerService;
    private final BierService bierService;

    BrouwerController(BrouwerService brouwerService, BierService bierService) {
        this.brouwerService = brouwerService;
        this.bierService = bierService;
    }

    @GetMapping
    ModelAndView findAll() {
        return new ModelAndView(VIEW).addObject("brouwers", brouwerService.findAll());
    }

    @GetMapping("{brouwer}")
    ModelAndView read(@PathVariable Brouwer brouwer) {
        ModelAndView mav = new ModelAndView(BROUWER_VIEW);
        if (brouwer != null) {
            mav.addObject("brouwer", brouwer);
            List<Bier> sortedBieren = new ArrayList<>(brouwer.getBieren());
            sortedBieren.sort(Comparator.comparing(Bier::getNaam));
            mav.addObject("bieren", sortedBieren);
        }
        return mav;
    }

}
