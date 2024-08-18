package com.api.services;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.models.entities.Lokasi;
import com.api.models.entities.Proyek;
import com.api.models.entities.ProyekLokasi;
import com.api.models.repos.LokasiRepo;
import com.api.models.repos.ProyekLokasiRepo;
import com.api.models.repos.ProyekRepo;

@Service
public class ProyekLokasiService {

    @Autowired
    private ProyekLokasiRepo proyekLokasiRepository;

    @Autowired
    private LokasiRepo lokasiRepository;

    private ProyekRepo proyekRepo;

    @Transactional
    public ProyekLokasi createProyekLokasi(Integer proyekId, Integer lokasiId) {
        Proyek proyek = proyekRepo.findById(proyekId).orElseThrow(() -> new RuntimeException("Proyek not found"));
        Lokasi lokasi = lokasiRepository.findById(lokasiId).orElseThrow(() -> new RuntimeException("Lokasi not found"));
        ProyekLokasi proyekLokasi = new ProyekLokasi(proyek, lokasi);
        return proyekLokasiRepository.save(proyekLokasi);
    }

    @Transactional(readOnly = true)
    public Optional<ProyekLokasi> getProyekLokasiById(Integer id) {
        return proyekLokasiRepository.findById(id);
    }

    @Transactional
    public ProyekLokasi updateProyekLokasi(Integer id, Integer proyekId, Integer lokasiId) {
        ProyekLokasi proyekLokasi = proyekLokasiRepository.findById(id).orElseThrow(() -> new RuntimeException("ProyekLokasi not found"));
        Proyek proyek = proyekRepo.findById(proyekId).orElseThrow(() -> new RuntimeException("Proyek not found"));
        Lokasi lokasi = lokasiRepository.findById(lokasiId).orElseThrow(() -> new RuntimeException("Lokasi not found"));
        proyekLokasi.setProyek(proyek);
        proyekLokasi.setLokasi(lokasi);
        return proyekLokasiRepository.save(proyekLokasi);
    }

    @Transactional
    public void deleteProyekLokasi(Integer id) {
        proyekLokasiRepository.deleteById(id);
    }
}
