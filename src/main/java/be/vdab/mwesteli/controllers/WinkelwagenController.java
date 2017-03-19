package be.vdab.mwesteli.controllers;

import be.vdab.mwesteli.entities.Bestelbon;
import be.vdab.mwesteli.entities.BestelbonLijn;
import be.vdab.mwesteli.entities.Bier;
import be.vdab.mwesteli.services.BestelbonLijnService;
import be.vdab.mwesteli.services.BestelbonService;
import be.vdab.mwesteli.valueobjects.Adres;
import be.vdab.mwesteli.web.AdresForm;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maarten Westelinck on 14/03/2017 for bierhuis.
 */
@Controller
@RequestMapping("/winkelwagen")
public class WinkelwagenController {
    private final BestelbonService bestelbonService;
    private final BestelbonLijnService bestelbonLijnService;
    private static final String WINKELWAGEN = "winkelwagen";
    private static final String REDIRECT = "redirect:/brouwers";
    private static final String BEVESTIGING = "bevestiging";

    public WinkelwagenController(BestelbonService bestelbonService, BestelbonLijnService bestelbonLijnService) {
        this.bestelbonService = bestelbonService;
        this.bestelbonLijnService = bestelbonLijnService;
    }

    @GetMapping
    ModelAndView show(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        if(session == null || session.getAttribute("winkelwagen") == null) {
            return new ModelAndView(REDIRECT);
        }
        return new ModelAndView(WINKELWAGEN).addObject("adresForm", new AdresForm());
    }

    @PostMapping
    ModelAndView bestelbonMaken(HttpServletRequest request, @Validated AdresForm adresForm, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return new ModelAndView(WINKELWAGEN);
        }

        Adres adres = new Adres();
        adres.setGemeente(adresForm.getGemeente());
        adres.setHuisnr(adresForm.getHuisnr());
        adres.setPostcode(adresForm.getPostcode());
        adres.setStraat(adresForm.getStraat());

        List<BestelbonLijn> bestelbonLijnen = new ArrayList<>();

        Bestelbon bestelbon = new Bestelbon();
        bestelbon.setAdres(adres);
        bestelbon.setNaam(adresForm.getNaam());
        bestelbonService.create(bestelbon);

        List<WinkelwagenLijn> winkelwagen = (List<WinkelwagenLijn>) request.getSession().getAttribute("winkelwagen");
        for (WinkelwagenLijn lijn : winkelwagen) {
            Bier bier = lijn.getBier();
            BestelbonLijn bestelbonLijn = new BestelbonLijn(bestelbon.getId(), bier.getId());
            bestelbonLijn.setPrijs(lijn.getTotaal());
            bestelbonLijn.setAantal(lijn.getAantal());
            bestelbonLijnen.add(bestelbonLijn);
        }


        bestelbonLijnService.createMultiple(bestelbonLijnen);
        request.getSession().removeAttribute("winkelwagen");
        return new ModelAndView(BEVESTIGING).addObject("id", bestelbon.getId());
    }

}
