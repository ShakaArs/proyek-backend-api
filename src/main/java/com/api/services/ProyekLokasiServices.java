package com.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.models.entities.ProyekLokasi;
import com.api.models.repos.ProyekLokasiRepo;

@Service
@Transactional
public class ProyekLokasiServices {
    
    @Autowired
    private ProyekLokasiRepo proyekLokasiRepo;

    public ProyekLokasi createProyekLokasi(ProyekLokasi proyekLokasi) {
        return proyekLokasiRepo.save(proyekLokasi);
    }

    public Iterable<ProyekLokasi> getAllProyekLokasi() {
        return proyekLokasiRepo.findAll();
    }

    public ProyekLokasi findOne(Integer id) {
        return proyekLokasiRepo.findById(id).get();
    }

    public ProyekLokasi updateProyekLokasi(ProyekLokasi proyekLokasi) {
        return proyekLokasiRepo.save(proyekLokasi);
    }

    public void removeOne(Integer id) {
        proyekLokasiRepo.deleteById(id);
    }
}
