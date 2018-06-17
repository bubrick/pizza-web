package com.example.project.service;

import com.example.project.model.Cart;
import com.example.project.model.Item;
import com.example.project.repository.ItemRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@Repository("itemDao")
public class ItemDaoImpl implements ItemDao<Item, Long> {

    ItemRepository itemRepository;

    private Session currentSession;

    private Transaction currentTransaction;

    public ItemDaoImpl() {}

    private static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration().configure().addAnnotatedClass(Item.class).addAnnotatedClass(Cart.class);
//        Configuration configuration = new Configuration().configure().addAnnotatedClass(Item.class).addAnnotatedClass(Cart.class);
//        SessionFactory sf = configuration.buildSessionFactory();
        StandardServiceRegistryBuilder builder;
        builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
//        return sf;
        return configuration.buildSessionFactory(builder.build());
    }

    public Session openCurrentSessionWithTransaction(){
        setCurrentSession(getSessionFactory().getCurrentSession());
        setCurrentTransaction(getCurrentSession().beginTransaction());
        return getCurrentSession();
    }

    public void closeCurrentSessionWithTransaction(){
        getCurrentTransaction().commit();
        getCurrentSession().close();
    }

    public Session getCurrentSession() {
        return currentSession;
    }

    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }

    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }

    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }

    @Override
    public void update(Item entity) {
        getCurrentSession().update(entity);
    }

    @Override
    public void save(Item entity) {
        getCurrentSession().save(entity);
    }

//    @Override
//    public Item findById(Long id) {
////        Item item = itemRepository.findById(id);
//////        Query q = getCurrentSession().createQuery("from Item i where i.id = :id");
//////        q.setParameter("id", id);
//////        Item item = (Item) q.list().get(0);
////        //Item item = (Item) getCurrentSession().get(Item.class, id);
////        return item;
//        return null;
//    }

    @Override
    public void delete(Item entity) {
        getCurrentSession().delete(entity);
    }

    @Override
    public List<Item> findAll() {
        return (List<Item>) getCurrentSession().createQuery("from Item").list();
    }

//    @Override
//    public void deleteItem(Long id) {
//        Item temp = findById(id);
//        delete(temp);
//    }
}
