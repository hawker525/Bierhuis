package be.vdab.mwesteli.controllers;

import be.vdab.mwesteli.entities.Bier;
import be.vdab.mwesteli.services.BierService;
import be.vdab.mwesteli.web.AantalForm;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Maarten Westelinck on 14/03/2017 for bierhuis.
 */
@Controller
@RequestMapping("/bieren")
public class BierenController {
    private static final String BIER = "bier";
    private static final String REDIRECT_NA_TOEVOEGEN_BIER = "redirect:/winkelwagen";
    private final BierService bierService;

    public BierenController(BierService bierService) {
        this.bierService = bierService;
    }

    @GetMapping("{bier}")
    ModelAndView read(@PathVariable Bier bier){
        if (bier != null) {
            return new ModelAndView(BIER).addObject(bier).addObject(new AantalForm());
        }
        return new ModelAndView("redirect:/brouwers");
    }

    @PostMapping("{bier}")
    ModelAndView toevoegen(HttpServletRequest request, @PathVariable Bier bier, @Validated AantalForm aantalForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView(BIER).addObject(bier);
        } else {
            ModelAndView mav = new ModelAndView(REDIRECT_NA_TOEVOEGEN_BIER);
            HttpSession session = request.getSession();
            List<WinkelwagenLijn> winkelwagen = (List<WinkelwagenLijn>) session.getAttribute("winkelwagen");

            WinkelwagenLijn lijn = new WinkelwagenLijn(bier, aantalForm.getAantal());

            if(winkelwagen == null) {
                winkelwagen = new ArrayList<>();
                winkelwagen.add(lijn);
            } else {
                Optional<WinkelwagenLijn> w = winkelwagen.stream().filter(l -> l.getBier().equals(bier)).findFirst();
                if(w.isPresent()){
                    w.get().addAantal(aantalForm.getAantal());
                } else {
                    winkelwagen.add(lijn);
                }
            }
            session.setAttribute("winkelwagen", winkelwagen);
            return mav;
        }
    }


}
