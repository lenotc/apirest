package com.apirest.controllers

import com.apirest.entity.Client
import com.apirest.service.IClientService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@CrossOrigin(origins = arrayOf("http://localhost:4200"))
@RestController
@RequestMapping("/api")
class ClientRest
{
    @Autowired
    lateinit var iClientService: IClientService

    @GetMapping("/clients")
    fun index(): List<Client>
    {
        return iClientService.findAll()
    }

    @GetMapping("/clients/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<Any>
    {
        val client = iClientService.findById(id)

        if (client.id <= 0L) {
            val response = mapOf("message" to "The ID $id has not been found :( ")
            return ResponseEntity(response, HttpStatus.NOT_FOUND)
        }

        return ResponseEntity(client, HttpStatus.OK)
    }

    @PostMapping("/clients")
    fun postClient(@RequestBody client: Client): ResponseEntity<Any>
    {
        val clientSaved = iClientService.save(client)
        val response = mapOf("message" to "the client has been saved with success", "client" to clientSaved)
        return ResponseEntity(response, HttpStatus.CREATED);
    }

    @PutMapping("/clients")
    fun putClient(@RequestBody client: Client): ResponseEntity<Any>
    {
        val response = mapOf("message" to "the client has been updated with success", "client" to iClientService.save(client))
        return ResponseEntity(response, HttpStatus.CREATED)
    }

    @DeleteMapping("/clients/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteClient(@PathVariable id: Long): ResponseEntity<Any>
    {
        iClientService.delete(id)
        val response = mapOf("message" to "The client has been delete with success")
        return ResponseEntity(response, HttpStatus.OK)
    }
}