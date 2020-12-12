package com.beadando.dao.relational;

import com.beadando.dao.KocsiDAO;
import com.beadando.exceptions.*;

import com.beadando.model.Kocsik;
import com.beadando.model.Kategoria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.Collection;

public class KocsiDAORelational implements KocsiDAO {
    private static SessionFactory factory;
    public KocsiDAORelational(){
        factory=new Configuration().configure().buildSessionFactory();
    }

    public void ujKocsi(Kocsik kocsik) throws MarVanIlyenAdatbazisban {
        try{

            kocsiIDAlapjan(kocsik.getId());
        }
        catch (NincsAzAdatbazisban nincsAzAdatbazisban) {
            Session session = factory.openSession();
            Transaction tx = session.beginTransaction();
            session.save(kocsik);
            tx.commit();
            session.close();
            return;
        }

        throw new MarVanIlyenAdatbazisban(kocsik.getId());
    }

    public Collection<Kocsik> osszesKocsi() {
        Session session=factory.openSession();
        Collection<Kocsik> result =  session.createQuery("FROM Kocsik").list();
        return result;
    }

    public Kocsik kocsiIDAlapjan(String id) throws NincsAzAdatbazisban {
        Session session=factory.openSession();
        if(session.get(Kocsik.class,id)==null){
            throw  new NincsAzAdatbazisban(id);
        }
        Kocsik result=session.get(Kocsik.class,id);
        return result;
    }

    public void kocsiModositas(String id, String name, LocalDate keszult, int keszultdb, Kategoria kategoria, String telephe) throws TipusUres, KeszitesiIdoRossz, KeszultDbRossz, TelepheUres {
        Session session=factory.openSession();
        Transaction tx=session.beginTransaction();
        Kocsik object=session.get(Kocsik.class,id);
        object.setTipus(name);
        object.setTelephe(telephe);
        object.setKeszultdb(keszultdb);
        object.setKategoria(kategoria);
        object.setKeszult(keszult);
        session.update(object);
        tx.commit();
        session.close();
    }


    public void kocsiTorles(String id) {
        Session session=factory.openSession();
        Transaction tx=session.beginTransaction();
        Kocsik obj=session.get( Kocsik.class,id);
        session.delete(obj);
        tx.commit();
        session.close();
    }

    @Override
    public Collection<Kocsik> kocsikKategoriaSzerint(Kategoria kategoria) {
        Session session=factory.openSession();
        String hql="From kocsik Where kategoria=:kategoria";
        Query q=session.createQuery(hql);
        q.setParameter("kategoria", kategoria);
        Collection result =q.list();
        return result;
    }


}
