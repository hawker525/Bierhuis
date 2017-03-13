package be.vdab.mwesteli.controllers;

import be.vdab.mwesteli.services.BierService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Maarten Westelinck on 13/03/2017 for bierhuis.
 */
@Controller
@RequestMapping("/")
class IndexController {
    private static final String VIEW = "index";
    private final BierService bierService;

    IndexController(BierService bierService) {
        this.bierService = bierService;
    }

    @GetMapping
    ModelAndView index(){
        return new ModelAndView(VIEW).addObject("count", bierService.count());
    }

}
