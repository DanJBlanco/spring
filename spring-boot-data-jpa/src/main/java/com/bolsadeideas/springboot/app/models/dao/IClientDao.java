package com.bolsadeideas.springboot.app.models.dao;

import com.bolsadeideas.springboot.app.models.entity.Client;

import java.util.List;

public interface IClientDao{

    public List<Client> findAll();

    public void save(Client client);

    public Client findOne(Long id);
}
