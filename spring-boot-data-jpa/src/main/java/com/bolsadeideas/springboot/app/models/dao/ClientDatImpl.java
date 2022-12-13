package com.bolsadeideas.springboot.app.models.dao;

import com.bolsadeideas.springboot.app.models.entity.Client;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("clientDaoH2")
public class ClientDatImpl implements IClientDao {

    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    @Override
    public List<Client> findAll() {
        return em.createQuery("from Client").getResultList();
    }

    @Override
    @Transactional
    public void save(Client client) {
        if ( client.getId() != null && client.getId() > 0){
            em.merge(client);
        } else {
            em.persist(client);
        }

    }

    @Override
    public Client findOne(Long id) {
        return em.find(Client.class, id);
    }


}
