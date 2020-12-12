package com.beadando.dao.relational;



import com.beadando.dao.KocsiDAO;
import com.beadando.exceptions.*;
import com.beadando.model.Kocsik;
import com.beadando.model.Kategoria;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class KocsikDAORelationalTest {
@Test
    public void test() throws KeszitesiIdoRossz, KeszultDbRossz, TelepheUres, TipusUres, MarVanIlyenAdatbazisban, NincsAzAdatbazisban {
    Kocsik ob=new Kocsik();
    KocsiDAO dao=new KocsiDAORelational();
    ob.setTipus("W210");
    ob.setKategoria(Kategoria.A);
    ob.setTelephe("A170");
    ob.setKeszultdb(1);
    ob.setKeszult(LocalDate.of(2009,02,12));

    dao.ujKocsi(ob);
    System.out.println(dao.osszesKocsi());
    //dao.removeBd("29dad4f1-b356-4db8-ba2c-8bbafe4a94b5");
}
}