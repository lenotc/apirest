package com.apirest.service

import com.apirest.dao.IClientDAO
import com.apirest.entity.Client
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ClientServiceImpl : IClientService
{
    @Autowired
    lateinit var iClientDAO: IClientDAO

    @Transactional(readOnly = true)
    override fun findAll(): List<Client>
    {
        return iClientDAO.findAll().map { it }
    }

    @Transactional(readOnly = true)
    override fun findById(id: Long): Client
    {
        return iClientDAO.findById(id).orElse(Client())
    }

    @Transactional
    override fun save(client: Client): Client
    {
        return iClientDAO.save(client)
    }

    @Transactional
    override fun delete(id: Long)
    {
        iClientDAO.deleteById(id)
    }
}