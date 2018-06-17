package com.example.project.service;

import com.example.project.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    public CartServiceImpl(){}

    @Override
    public Cart findById(Long id) {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session session = null;
        Cart cart = null;
        try {
            session = sf.openSession();
            Transaction tx = null;
            try {
                tx = session.beginTransaction();
                Query q = session.createQuery("from Cart where id = :id");
                q.setParameter("id", id);
                cart = (Cart)q.list().get(0);
                tx.commit();
            } catch(RuntimeException e2) {
                try {
                    if(tx != null) tx.rollback();
                } catch (Exception e3) {
                    throw new RuntimeException("Rollback error");
                }
                throw new RuntimeException(e2.getMessage());
            }
        } catch (RuntimeException e1) {
            throw new RuntimeException(e1.getMessage());
        } finally {
            if(session != null) session.close();
        }
        if(cart == null) {
            throw new RuntimeException("Item not found");
        }
        return cart;
    }

    @Override
    public List<Cart> selectAll() {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session session = null;
        List<Cart> carts;
        try {
            session = sf.openSession();
            Query q = session.createQuery("from Cart");
            carts = q.list();
        } catch (RuntimeException e) {
            throw new RuntimeException("Error while transaction performing");
        } finally {
            if(session != null) {
                session.close();
            }
        }
        return carts;
    }

    @Override
    public void save(Cart cart) {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session session = null;
        try {
            session = sf.openSession();
            Transaction tx = null;
            try {
                tx = session.beginTransaction();
                session.save(cart);
                tx.commit();
            } catch (RuntimeException e2) {
                try {
                    if (tx != null) tx.rollback();
                } catch (Exception e3) {
                    throw new RuntimeException("Rollback error");
                }
                throw new RuntimeException("Error while performing transaction");
            }

        } catch (RuntimeException e1) {
            throw new RuntimeException(e1.getMessage());
        } finally {
            if (session != null) session.close();
        }
    }

    @Override
    public void update(Cart cart) {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session session = null;
        try {
            session = sf.openSession();
            Transaction tx = null;
            try {
                tx = session.beginTransaction();
                session.saveOrUpdate(cart);
                tx.commit();
            } catch(RuntimeException e2) {
                try {
                    if(tx != null) tx.rollback();
                } catch (Exception e3) {
                    throw new RuntimeException("Rollback error");
                }
                throw new RuntimeException("Error while performing transaction");
            }
        } catch (RuntimeException e1) {
            throw new RuntimeException(e1.getMessage());
        } finally {
            if(session != null) session.close();
        }
    }

    @Override
    public void deleteById(Long id) {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();

        Session session = null;
        try {
            session = sf.openSession();
            Transaction tx = null;
            try {
                tx = session.beginTransaction();
                Cart cart = session.get(Cart.class, id);
                session.delete(cart);
                tx.commit();
            } catch(RuntimeException e2) {
                try {
                    if(tx != null) tx.rollback();
                } catch (Exception e3) {
                    throw new RuntimeException("Rollback error");
                }
                throw new RuntimeException("Error while performing transaction");
            }

        } catch (RuntimeException e1) {
            throw new RuntimeException(e1.getMessage());
        } finally {
            if(session != null) session.close();
        }
    }

    @Override
    public List<Item> selectItemsByCartId(Long id) {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session session = null;
        List<Item> items;
        try {
            session = sf.openSession();
            Query q = session.createQuery("select it from Cart c join c.itemsList it" +
                    " where c.id = :id").setParameter("id", id);
            items = q.list();
        } catch (RuntimeException e) {
            throw new RuntimeException("Error while transaction performing");
        } finally {
            if(session != null) {
                session.close();
            }
        }
        return items;
    }

    @Override
    public void deleteItemById(Long cartid, Long itemid) {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session session = null;
        try {
            session = sf.openSession();
            Transaction tx = null;
            try {
                tx = session.beginTransaction();
                Cart cart = (Cart)session.get(Cart.class, cartid);
                Item item = (Item)session.get(Item.class, itemid);
                cart.itemsList.remove(item);
                session.save(cart);
                tx.commit();
            } catch(RuntimeException e2) {
                try {
                    if(tx != null) tx.rollback();
                } catch (Exception e3) {
                    throw new RuntimeException("Rollback error");
                }
                throw new RuntimeException("Error while performing transaction");
            }
        } catch (RuntimeException e1) {
            throw new RuntimeException(e1.getMessage());
        } finally {
            if(session != null) session.close();
        }
    }
}
