package com.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.models.entities.Lokasi;
import com.api.models.repos.LokasiRepo;

@Service
@Transactional
public class LokasiServices {

    @Autowired
    private LokasiRepo lokasiRepo;

    public Lokasi createLokasi(Lokasi lokasi) {
        return lokasiRepo.save(lokasi);
    }

    public Iterable<Lokasi> getAllLokasi() {
        return lokasiRepo.findAll();
    }

    public Lokasi findOne(Integer id) {
        return lokasiRepo.findById(id).get();
    }

    public Lokasi updateLokasi(Lokasi lokasi) {
        return lokasiRepo.save(lokasi);
    }

    public void removeOne(Integer id) {
        lokasiRepo.deleteById(id);
    }
}
