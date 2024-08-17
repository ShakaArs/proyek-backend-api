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

import com.api.models.entities.Proyek;
import com.api.models.entities.ProyekDTO;
import com.api.services.ProyekService;

@RestController
@RequestMapping("/api/proyek")
public class ProyekController {

    @Autowired
    private ProyekService proyekService;

    // Endpoint untuk mendapatkan semua proyek
    @GetMapping("/get")
    public ResponseEntity<Map<String, Object>> getAllProyek() {
        Iterable<Proyek> proyekList = proyekService.getAllProyek();
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Daftar semua proyek berhasil diambil");
        response.put("data", proyekList);
        
        return ResponseEntity.ok(response);
    }


    // Endpoint untuk membuat proyek baru
    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> createProyek(@RequestBody ProyekDTO proyekDTO) {
        System.out.println("Received ProyekDTO: " + proyekDTO);
        Proyek proyek = proyekService.createProyek(proyekDTO);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Proyek berhasil ditambahkan");
        response.put("data", proyek);
        return ResponseEntity.ok(response);
    }
    

    // Endpoint untuk memperbarui proyek
    @PutMapping("/update")
    public ResponseEntity<Map<String, Object>> updateProyek(@RequestBody Proyek proyek) {
    Proyek updatedProyek = proyekService.updateProyek(proyek);
    
    if (updatedProyek == null) {
        // Jika proyek tidak berhasil diperbarui, kembalikan respons dengan pesan kesalahan
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Proyek tidak ditemukan atau gagal diperbarui");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
    
    // Menyusun pesan respons jika pembaruan berhasil
    Map<String, Object> response = new HashMap<>();
    response.put("message", "Proyek berhasil diperbarui");
    response.put("data", updatedProyek);
    
    return ResponseEntity.ok(response);
}


    // Endpoint untuk menghapus proyek
    @DeleteMapping("/delete")
    public ResponseEntity<Map<String, Object>> removeProyek(@RequestParam Integer id) {
    // Cek apakah proyek ada sebelum mencoba menghapusnya
    Proyek proyek = proyekService.getProyekById(id); // Anda perlu menambahkan metode ini di ProyekService
    if (proyek == null) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Proyek tidak ditemukan");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
    proyekService.removeOne(id);
    // Menyusun pesan respon jika penghapusan berhasil
    Map<String, Object> response = new HashMap<>();
    response.put("message", "Proyek berhasil dihapus dengan id: " + id);
    return ResponseEntity.ok(response);
}

}
