package com.apirest.service

import com.apirest.entity.Client

interface IClientService
{
    fun findAll(): List<Client>

    fun findById(id: Long): Client

    fun save(client: Client): Client

    fun delete(id: Long)
}