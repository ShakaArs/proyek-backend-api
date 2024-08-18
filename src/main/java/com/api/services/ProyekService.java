package com.api.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.models.entities.Proyek;
import com.api.models.entities.ProyekDTO;
import com.api.models.repos.ProyekRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProyekService {
    
    @Autowired
    private ProyekRepo proyekRepo;

    // Metode untuk membuat Proyek dari entity Proyek
    public Proyek createProyek(Proyek proyek) {
        if (proyek.getCreatedAt() == null) {
            proyek.setCreatedAt(LocalDateTime.now());
        }
        return proyekRepo.save(proyek);
    }
    public Proyek getProyekById(Integer id) {
        return proyekRepo.findById(id).orElse(null);
    }

    // Metode untuk membuat Proyek dari DTO
    public Proyek createProyek(ProyekDTO proyekDTO) {
        Proyek proyek = new Proyek();
        
        // Mapping dari DTO ke Entity
        proyek.setNamaProyek(proyekDTO.getNamaProyek());
        proyek.setClient(proyekDTO.getClient());
        proyek.setTanggalMulai(proyekDTO.getTanggalMulai());
        proyek.setTanggalSelesai(proyekDTO.getTanggalSelesai());
        proyek.setPimpinanProyek(proyekDTO.getPimpinanProyek());
        proyek.setKeterangan(proyekDTO.getKeterangan());
        proyek.setCreatedAt(proyekDTO.getCreatedAt() != null ? proyekDTO.getCreatedAt() : LocalDateTime.now());

        // Simpan entity ke database
        return proyekRepo.save(proyek);
    }

    // Metode untuk mendapatkan semua proyek
    public Iterable<Proyek> getAllProyek() {
        return proyekRepo.findAll();
    }

    // Metode untuk menemukan satu proyek berdasarkan id
    public Proyek findOne(Integer id) {
        return proyekRepo.findById(id).orElse(null);
    }

    // Metode untuk memperbarui proyek
    public Proyek updateProyek(Proyek proyek) {
        return proyekRepo.save(proyek);
    }

    // Metode untuk menghapus proyek berdasarkan id
    public void removeOne(Integer id) {
        proyekRepo.deleteById(id);
    }
}
