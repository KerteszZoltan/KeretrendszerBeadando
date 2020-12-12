package com.beadando.service;

import com.beadando.exceptions.*;
import com.beadando.model.Kocsik;
import com.beadando.model.Kategoria;

import java.time.LocalDate;
import java.util.Collection;

public interface KocsiService {
    void addKocsi(Kocsik kocsi) throws MarVanIlyenAdatbazisban;
    Collection<Kocsik> getKocsik();
    Kocsik getKocsiID(String id) throws NincsAzAdatbazisban;
    void kocsiFrissites(String id, String tipus, LocalDate keszult, int keszultdb, Kategoria kategoria, String telephe) throws NincsAzAdatbazisban, TipusUres, KeszultDbRossz, KeszitesiIdoRossz, TelepheUres;
    void kocsiTorles(String id)throws NincsAzAdatbazisban;
    Collection<Kocsik> kocsikKategoriaSzerint(Kategoria kategoria);
}
