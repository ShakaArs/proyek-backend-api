package com.api.models.repos;

import org.springframework.data.repository.CrudRepository;

import com.api.models.entities.Lokasi;


public interface LokasiRepo extends CrudRepository<Lokasi, Integer> {
    

}