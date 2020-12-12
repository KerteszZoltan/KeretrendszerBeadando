package com.beadando.model;

import com.beadando.exceptions.KeszultDbRossz;
import com.beadando.exceptions.TelepheUres;
import com.beadando.exceptions.TipusUres;
import com.beadando.exceptions.KeszitesiIdoRossz;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.UUID;

public class Kocsik {
    private String tipus;
    private String telephe;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate keszult;
    private String id;
    private Kategoria kategoria;
    private int keszultdb;

    public int getKeszultdb() {
        return keszultdb;
    }

    public void setKeszultdb(int keszultdb) throws KeszultDbRossz {
        if (keszultdb <=0){
            throw new KeszultDbRossz(keszultdb);
        }
        this.keszultdb = keszultdb;
    }


    public Kocsik() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) throws TipusUres {
        if (tipus.trim().length()==0){
            throw new TipusUres();
        }
        this.tipus = tipus;
    }

    public String getTelephe() {
        return telephe;
    }

    public void setTelephe(String telephe) throws TelepheUres {
        if (telephe.trim().length()==0){
            throw new TelepheUres();
        }
        this.telephe = telephe;
    }

    public LocalDate getKeszult() {
        return keszult;
    }

    public void setKeszult(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate keszult) throws KeszitesiIdoRossz {
        if(keszult ==null){
            throw new KeszitesiIdoRossz("Az elkészülési dátum nem lehet üres");
        }
        if (keszult.isBefore(LocalDate.of(2000,01,01))){
            throw new KeszitesiIdoRossz("Az elkészülési dátum nem lehet 2000 előtti");
        }
        this.keszult = keszult;
    }


    public Kategoria getKategoria() {
        return kategoria;
    }

    public void setKategoria(Kategoria kategoria) {
        this.kategoria = kategoria;
    }

public String toString(){
   return "Kocsik{" +
            "tipus='" + tipus + '\'' +
            ", id='" + id + '\'' +
            ", keszult=" + keszult +
           ", keszultdb=" + keszultdb +
            ", kategoria=" + kategoria +
            ", telephe=" + telephe +
            '}';
    }
}
