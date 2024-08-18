package com.api.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.models.entities.Lokasi;
import com.api.services.LokasiServices;

@RestController
@RequestMapping("/api/lokasi")
public class LokasiController {

    @Autowired
    private LokasiServices lokasiServices;

    // Endpoint untuk mendapatkan semua lokasi
    @GetMapping("/get")
    public ResponseEntity<Map<String, Object>> getAllLokasi() {
        Iterable<Lokasi> lokasiList = lokasiServices.getAllLokasi();
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Daftar semua lokasi berhasil diambil");
        response.put("data", lokasiList);
        
        return ResponseEntity.ok(response);
    }
    // Endpoint untuk membuat lokasi baru
    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> createLokasi(@RequestBody Lokasi lokasiDTO) {
        System.out.println("Received Lokasi: " + lokasiDTO);
        Lokasi createdLokasi = lokasiServices.createLokasi(lokasiDTO);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Lokasi berhasil ditambahkan");
        response.put("data", createdLokasi);
        
        return ResponseEntity.ok(response);
    }
    // Endpoint untuk memperbarui lokasi
    @PutMapping("/update")
    public ResponseEntity<Map<String, Object>> updateLokasi(@RequestBody Lokasi lokasi) {
        Lokasi updatedLokasi = lokasiServices.updateLokasi(lokasi);
        if (updatedLokasi == null) {
            // Jika lokasi tidak berhasil diperbarui, kembalikan respons dengan pesan kesalahan
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Lokasi tidak ditemukan atau gagal diperbarui");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
        // Menyusun pesan respons jika pembaruan berhasil
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Lokasi berhasil diperbarui");
        response.put("data", updatedLokasi);
        
        return ResponseEntity.ok(response);
    }
    // Endpoint untuk menghapus lokasi
    @DeleteMapping("/delete")
    public ResponseEntity<Map<String, Object>> removeLokasi(@RequestParam Integer id) {
        Lokasi lokasi = lokasiServices.findOne(id);
        if (lokasi == null) {
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Lokasi tidak ditemukan");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
        lokasiServices.removeOne(id);
        // Menyusun pesan respons jika penghapusan berhasil
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Lokasi berhasil dihapus");
        return ResponseEntity.ok(response);
    }
    @GetMapping("/find")
    public ResponseEntity<Map<String, Object>> findLokasi(@RequestParam Integer id) {
        Lokasi lokasi = lokasiServices.findOne(id);
        if (lokasi == null) {
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Lokasi tidak ditemukan");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Lokasi berhasil ditemukan");
        response.put("data", lokasi);
        return ResponseEntity.ok(response);
    }
}
