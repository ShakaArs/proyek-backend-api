package com.api.models.repos;

import org.springframework.data.repository.CrudRepository;

import com.api.models.entities.ProyekLokasi;

public interface ProyekLokasiRepo extends CrudRepository<ProyekLokasi, Integer> {
    
}
