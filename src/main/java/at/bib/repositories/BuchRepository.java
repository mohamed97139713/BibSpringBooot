package at.bib.repositories;

import at.bib.model.Buch;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BuchRepository {
    private final EntityManagerFactory emf;
    private EntityManager em;

    public BuchRepository() {
        this.emf = Persistence.createEntityManagerFactory("myJpaUnit");
    }

    private EntityManager getEntityManager() {
        if (em == null || !em.isOpen()) {
            em = emf.createEntityManager();
        }
        return em;
    }

    public void startTransaction() {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
    }

    public void commitTransaction() {
        EntityManager em = getEntityManager();
        if (em.getTransaction().isActive()) {
            em.getTransaction().commit();
        }
    }

    public void save(Buch buch) {
        startTransaction();
        try {
            em.merge(buch);
            commitTransaction();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public List<Buch> getAllBooks() {
        EntityManager em = getEntityManager();
        TypedQuery<Buch> query = em.createQuery("SELECT u FROM Buch u ORDER BY u.id", Buch.class);
        return query.getResultList();
    }

    public void delete(Long id) {
        EntityManager em = getEntityManager();
        startTransaction();
        try {
            Buch buch = em.find(Buch.class, id);
            if (buch != null) {
                em.remove(buch);
            }
            commitTransaction();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }


    public void deleteById(Long id) {
        EntityManager em = getEntityManager();
        startTransaction();
        try {
            Buch buch = em.find(Buch.class, id);
            if (buch != null) {
                em.remove(buch);
            }
            commitTransaction();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }


    public Optional<Buch> findById(Long id) {
        EntityManager em = getEntityManager();
        Buch buch = em.find(Buch.class, id);
        return Optional.ofNullable(buch);
    }

    public void saveAll(List<Buch> buecher) {
        EntityManager em = getEntityManager();
        startTransaction();
        try {
            for (Buch buch : buecher) {
                em.merge(buch);
            }
            commitTransaction();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }


    public void close() {
        emf.close();
    }
}
