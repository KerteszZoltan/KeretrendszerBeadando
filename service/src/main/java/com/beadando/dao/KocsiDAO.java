package com.beadando.dao;

import com.beadando.exceptions.*;
import com.beadando.model.Kocsik;
import com.beadando.model.Kategoria;

import java.time.LocalDate;
import java.util.Collection;

public interface KocsiDAO {
    void ujKocsi(Kocsik kocsik) throws MarVanIlyenAdatbazisban;
    Collection<Kocsik> osszesKocsi();
    Kocsik kocsiIDAlapjan(String id)throws NincsAzAdatbazisban;
    void kocsiModositas(String id, String name, LocalDate keszult, int keszultdb, Kategoria kategoria, String distributor) throws TipusUres, KeszitesiIdoRossz, KeszultDbRossz, TelepheUres, NincsAzAdatbazisban;
    void kocsiTorles(String id)throws NincsAzAdatbazisban;
    Collection<Kocsik> kocsikKategoriaSzerint(Kategoria kategoria);
}
