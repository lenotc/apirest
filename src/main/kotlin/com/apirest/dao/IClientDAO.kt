package com.apirest.dao

import com.apirest.entity.Client
import org.springframework.data.repository.CrudRepository

interface IClientDAO : CrudRepository<Client, Long>
{
}