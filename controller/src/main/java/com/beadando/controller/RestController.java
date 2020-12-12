package com.beadando.controller;


import com.beadando.exceptions.MarVanIlyenAdatbazisban;
import com.beadando.exceptions.NincsAzAdatbazisban;
import com.beadando.exceptions.TipusUres;
import com.beadando.model.Kocsik;
import com.beadando.service.KocsiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@org.springframework.web.bind.annotation.RestController
@RequestMapping(value = "/rest/")
public class RestController {

    @Autowired
    KocsiService service;

    @GetMapping(value = "kocsik")
    public Collection<Kocsik> getKocsik(){
        return service.getKocsik();
    }
    @GetMapping(value = "kocsi/{id:[A-Za-z0-9]{8}-[A-Za-z0-9]{4}-[A-Za-z0-9]{4}-[A-Za-z0-9]{4}-[A-Za-z0-9]{12}}")
    public Kocsik getKocsiID(@PathVariable(name="id")String id) throws NincsAzAdatbazisban {
        return service.getKocsiID(id);
    }
    @PostMapping(value = "kocsi", consumes = MediaType.APPLICATION_JSON_VALUE, produces = "application/json;charset=utf-8")
    public String addKocsi(@RequestBody Kocsik kocsik) throws MarVanIlyenAdatbazisban, TipusUres {
        System.out.println("Hozzáadandó: "+ kocsik);
        service.addKocsi(kocsik);
        return "Új kocsi lett hozzáadva ezzel az azonosítóval: "+ kocsik.getId();
    }

    @ExceptionHandler(MarVanIlyenAdatbazisban.class)
    @ResponseStatus(HttpStatus.IM_USED)
    public String foglaltKocsiId(MarVanIlyenAdatbazisban e){
        return "A kocsi az adott id-vel már létezik: "+e.getMessage();
    }


}
