package com.api.models.repos;

import org.springframework.data.repository.CrudRepository;

import com.api.models.entities.Proyek;

public interface ProyekRepo extends CrudRepository<Proyek, Integer> {
    

}