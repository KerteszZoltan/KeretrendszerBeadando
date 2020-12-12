package com.beadando.controller;

import com.beadando.exceptions.*;
import com.beadando.model.Kocsik;
import com.beadando.model.Kategoria;
import com.beadando.service.KocsiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Collection;

@Controller
public class KocsiController {
@Autowired
@Qualifier("KocsiService")
KocsiService service;

@ModelAttribute(value = "kocsi")
public Kocsik create(){
    return new Kocsik();
}



@GetMapping(value="/kocsik")
public ModelAndView getBds(Model model){
    ModelAndView mav=new ModelAndView("KocsiList");
    model.addAttribute("kategoria", Kategoria.values());
    mav.addObject("kocsik",service.getKocsik());
    return mav;
}

    @GetMapping(value = "/kocsik/{id}")
    public String getBdById(@PathVariable String id, Model model) throws NincsAzAdatbazisban {
        model.addAttribute("kocsi",service.getKocsiID(id));
        return "KocsiAdatlap";
    }

    @PostMapping(value="/keresKocsiID")
    public ModelAndView searchById(String id) throws NincsAzAdatbazisban {
    Kocsik result=service.getKocsiID(id);
    Collection<Kocsik> resultList=new ArrayList<Kocsik>();
    resultList.add(result);
    ModelAndView mav=new ModelAndView("KocsiList");
    mav.addObject("kocsik",resultList);
    return mav;
    }

    @GetMapping(value = "/ujKocsi")
    public String addBdForm(Model model){
        model.addAttribute("Kategoria", Kategoria.values());
        return "KocsiAdd";
    }

    @PostMapping(value = "addKocsi")
    public String addBd(@ModelAttribute("kocsi") Kocsik kocsik, Model model){
        try {
            service.addKocsi(kocsik);
        } catch (MarVanIlyenAdatbazisban marVanIlyenAdatbazisban) {
            marVanIlyenAdatbazisban.printStackTrace();
        }
        return "redirect:kocsik/"+ kocsik.getId();
    }

    @GetMapping(value = "/modifyBd/{id}")
    public String modifyBdForm(@PathVariable String id,Model model) throws NincsAzAdatbazisban {
        Kocsik object=service.getKocsiID(id);
        model.addAttribute("kocsi2",object);
        model.addAttribute("Kategoria1", Kategoria.values());
        return "KocsiModositas";
    }

    @PostMapping(value = "/modify")
    public String modifyBd(@ModelAttribute("kocsi2") Kocsik kocsik, Model model){
        try {
            service.kocsiFrissites(kocsik.getId(), kocsik.getTipus(), kocsik.getKeszult(), kocsik.getKeszultdb(), kocsik.getKategoria(), kocsik.getTelephe());
        } catch (KeszultDbRossz keszultDbRossz) {
            keszultDbRossz.printStackTrace();
        } catch (KeszitesiIdoRossz keszitesiIdoRossz) {
            keszitesiIdoRossz.printStackTrace();
        } catch (TelepheUres telepheUres) {
            telepheUres.printStackTrace();
        } catch (TipusUres tipusUres) {
            tipusUres.printStackTrace();
        } catch (NincsAzAdatbazisban nincsAzAdatbazisban) {
            nincsAzAdatbazisban.printStackTrace();
        }
        return "redirect:kocsi/"+ kocsik.getId();
    }


    @GetMapping(value = "/removeBd/{id}")
    public String removeBd(@PathVariable String id) throws NincsAzAdatbazisban {
        service.kocsiTorles(id);
        return "redirect:/kocsik";
    }

    @PostMapping(value="/byKategoria")
    public ModelAndView getBdByRate(Kategoria kategoria){
        ModelAndView mav=new ModelAndView("KocsiList");
        mav.addObject("kocsik",service.kocsikKategoriaSzerint(kategoria));
        return mav;
    }
}
