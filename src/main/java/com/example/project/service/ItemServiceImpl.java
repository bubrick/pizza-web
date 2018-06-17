package com.example.project.service;

import com.example.project.model.Item;
import com.example.project.model.ItemDTO;
import com.example.project.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {
    private ItemRepository itemRepository;

    private static ItemDaoImpl itemDao;

    public ItemServiceImpl(){
        itemDao = new ItemDaoImpl();
    }

    @Override
    public Item findById(Long id) {
        Optional<Item> item = itemRepository.findById(id);
//        itemDao.openCurrentSessionWithTransaction();
//        Item item = itemDao.findById(id);
//        itemDao.closeCurrentSessionWithTransaction();
        if (item.isPresent())
            return item.get();
        else
            return null;
//        new Configuration().configure().buildSessionFactory();
//        SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
//        Session sess;
//        Item item = new Item();
//        sess = sf.openSession();
//        try {
//            sess = sf.openSession();
//            Transaction tx = null;
//            try {
//                tx = sess.beginTransaction();
//                Query q = sess.createQuery("from Item where id = :id");
//                q.setParameter("id", id);
////                //item = (Item) q.getResultList().get(0);
////                Object o = q.list().get(0);
////                System.out.println(q.list().size());
////                if (o instanceof Item) {
////                    item = (Item) o;
////                }
////                item = (Item)q.getResultList().get(0);
//                List<Item> its = q.list();
//                item = its.get(0);
////                for (int i = 0; i < 4; i++){
////                    item = new Item((long)o.get(0)[0], (String)o.get(0)[1], (String)o.get(0)[2], (int)o.get(0)[3]);
////                }
////                item = (Item)q.list().get(0);
//                //System.out.println("LIL");
////                item = sess.get(Item.class, id);
//                tx.commit();
//            } catch(RuntimeException e2) {
//                try {
//                    if(tx != null) tx.rollback();
//                } catch (Exception e3) {
//                    throw new RuntimeException("Rollback error");
//                }
//                throw new RuntimeException(e2.getMessage());
//            }
//        } catch (RuntimeException e1) {
//            throw new RuntimeException(e1.getMessage());
//        } finally {
//            if(sess != null) sess.close();
//        }
//        return item;
    }

    @Override
    public List<Item> selectAll() {
        itemDao.openCurrentSessionWithTransaction();
        List<Item> items = itemDao.findAll();
        itemDao.closeCurrentSessionWithTransaction();
        return items;
//        SessionFactory sf = new Configuration().configure().buildSessionFactory();
//        Session session = null;
//        List<Item> items;
//        try {
//            session = sf.openSession();
//            Query q = session.createQuery("from Item");
//            items = q.getResultList();
//        } catch (RuntimeException e) {
//            throw new RuntimeException("Error while transaction performing");
//        } finally {
//            if(session != null) {
//                session.close();
//            }
//        }
//        return items;
    }

    @Override
    public void save(Item item){
        itemDao.openCurrentSessionWithTransaction();
        itemDao.save(item);
        itemDao.closeCurrentSessionWithTransaction();
//        SessionFactory sf = new Configuration().configure().buildSessionFactory();
//        Session sess = null;
//        try {
//            sess = sf.openSession();
//            Transaction tx = null;
//            try {
//                tx = sess.beginTransaction();
//                sess.save(item);
//                tx.commit();
//            } catch (RuntimeException e2) {
//                try {
//                    if (tx != null) tx.rollback();
//                } catch (Exception e3) {
//                    //logger.error("Exception in rollback", new RuntimeException("Rollback error"));
//                    throw new RuntimeException("Rollback error");
//                }
//                //logger.error("Exception in transaction",
//                //        new RuntimeException("Error while performing transaction"));
//                throw new RuntimeException("Error while performing transaction");
//            }
//
//        } catch (RuntimeException e1) {
//            //logger.error("Exception in openSession", new RuntimeException(e1.getMessage()));
//            throw new RuntimeException(e1.getMessage());
//        } finally {
//            if (sess != null) sess.close();
//        }
    }

    @Override
    public void update(Item item) {
        itemDao.openCurrentSessionWithTransaction();
        itemDao.update(item);
        itemDao.closeCurrentSessionWithTransaction();
//        SessionFactory sf = new Configuration().configure().buildSessionFactory();
//        Session sess = null;
//        try {
//            sess = sf.openSession();
//            Transaction tx = null;
//            try {
//                tx = sess.beginTransaction();
//                sess.update(item);
//                tx.commit();
////                tx = sess.beginTransaction();
////                String hql = "update Item set name =:name, description=:description, " +
////                        "price=:price where id=:id";
////                sess.createQuery(hql)
////                        .setParameter("id", item.getId())
////                        .setParameter("name", item.getName())
////                        .setParameter("description", item.getDescription())
////                        .setParameter("price", item.getPrice())
////                        .executeUpdate();
////                tx.commit();
//            } catch(RuntimeException e2) {
//                try {
//                    if(tx != null) tx.rollback();
//                } catch (Exception e3) {
//                    throw new RuntimeException("Rollback error");
//                }
//                throw new RuntimeException("Error while performing transaction");
//            }
//        } catch (RuntimeException e1) {
//            throw new RuntimeException(e1.getMessage());
//        } finally {
//            if(sess != null) sess.close();
//        }
    }

    @Override
    public void deleteById(Long id) {
        itemDao.openCurrentSessionWithTransaction();
//        itemDao.deleteItem(id);
        itemDao.closeCurrentSessionWithTransaction();
//        SessionFactory sf = new Configuration().configure().buildSessionFactory();
//
//        Session sess = null;
//        try {
//            sess = sf.openSession();
//            Transaction tx = null;
//            try {
//                tx = sess.beginTransaction();
//                Item item = sess.get(Item.class, id);
//                sess.delete(item);
//                tx.commit();
//            } catch(RuntimeException e2) {
//                try {
//                    if(tx != null) tx.rollback();
//                } catch (Exception e3) {
//                    throw new RuntimeException("Rollback error");
//                }
//                throw new RuntimeException("Error while performing transaction");
//            }
//
//        } catch (RuntimeException e1) {
//            throw new RuntimeException(e1.getMessage());
//        } finally {
//            if(sess != null) sess.close();
//        }
    }
}
