package com.bolsadeideas.springboot.app.models.service;

import com.bolsadeideas.springboot.app.models.entity.Client;

import java.util.List;

public interface IClientService {

    List<Client> findAll();

    void save(Client client);

    Client findOne(Long id);

    void delete(Long id);
}
