package com.bolsadeideas.springboot.app.models.service;

import com.bolsadeideas.springboot.app.models.entity.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IClientService {

    List<Client> findAll();

    Page<Client> findAll(Pageable pageable);

    void save(Client client);

    Client findOne(Long id);

    void delete(Long id);
}
