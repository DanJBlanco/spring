package com.bolsadeideas.springboot.app.models.dao;

import com.bolsadeideas.springboot.app.models.entity.Client;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class ClientDatImpl {

    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public List<Client> findAll() {
        return em.createQuery("from Client").getResultList();
    }

    @Transactional
    public void save(Client client) {
        if ( client.getId() != null && client.getId() > 0){
            em.merge(client);
        } else {
            em.persist(client);
        }

    }

    @Transactional(readOnly = true)
    public Client findOne(Long id) {
        return em.find(Client.class, id);
    }

    @Transactional
    public void delete(Long id) {
        Client client = this.findOne(id);
        em.remove(client);
    }
}
