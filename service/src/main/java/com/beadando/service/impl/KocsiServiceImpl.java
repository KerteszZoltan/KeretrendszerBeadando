package com.beadando.service.impl;

import com.beadando.dao.KocsiDAO;
import com.beadando.exceptions.*;
import com.beadando.model.Kocsik;
import com.beadando.service.KocsiService;
import com.beadando.model.Kategoria;

import java.time.LocalDate;
import java.util.Collection;
import java.util.stream.Collectors;

public class KocsiServiceImpl implements KocsiService {
    KocsiDAO dao;
    public KocsiServiceImpl(KocsiDAO dao) {
        this.dao=dao;
    }

    @Override
    public void addKocsi(Kocsik kocsi) throws MarVanIlyenAdatbazisban {
    dao.ujKocsi(kocsi);
    }

    @Override
    public Collection<Kocsik> getKocsik() {
        Collection<Kocsik>result=dao.osszesKocsi();
        return result;
    }

    @Override
    public Kocsik getKocsiID(String id) throws NincsAzAdatbazisban {
        Kocsik result=dao.kocsiIDAlapjan(id);
        return result;
    }

    @Override
    public void kocsiFrissites(String id, String tipus, LocalDate keszult, int keszultdb, Kategoria kategoria, String telephe) throws NincsAzAdatbazisban, TipusUres, KeszultDbRossz, KeszitesiIdoRossz, TelepheUres {
            dao.kocsiModositas(id,tipus,keszult,keszultdb, kategoria,telephe);

    }

    @Override
    public void kocsiTorles(String id) throws NincsAzAdatbazisban {
            dao.kocsiTorles(id);
    }



    @Override
    public Collection<Kocsik> kocsikKategoriaSzerint(Kategoria kategoria) {
        Collection<Kocsik> kocsiks = getKocsik();
        Collection<Kocsik> result= kocsiks.stream().filter(d -> d.getKategoria()== kategoria).collect(Collectors.toList());
        return result;
    }
}
