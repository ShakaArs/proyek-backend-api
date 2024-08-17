package com.api.models.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "proyek")
public class Proyek implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String namaProyek;
    
    private String client;


    private LocalDate tanggalMulai;

    private LocalDate tanggalSelesai;


    private String pimpinanProyek;
    
    @Lob
    @Column(columnDefinition = "TEXT")
    private String keterangan;

    @OneToMany(mappedBy = "proyek")
    private Set<ProyekLokasi> proyekLokasi;

    
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    // Default constructor
    public Proyek() {
    }

    // Parameterized constructor
    public Proyek(String namaProyek, String client, LocalDate tanggalMulai, LocalDate tanggalSelesai,
                  String pimpinanProyek, String keterangan, LocalDateTime createdAt) {
        this.namaProyek = namaProyek;
        this.client = client;
        this.tanggalMulai = tanggalMulai;
        this.tanggalSelesai = tanggalSelesai;
        this.pimpinanProyek = pimpinanProyek;
        this.keterangan = keterangan;
        this.createdAt = createdAt;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNamaProyek() {
        return namaProyek;
    }

    public void setNamaProyek(String namaProyek) {
        this.namaProyek = namaProyek;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public LocalDate getTanggalMulai() {
        return tanggalMulai;
    }

    public void setTanggalMulai(LocalDate tanggalMulai) {
        this.tanggalMulai = tanggalMulai;
    }

    public LocalDate getTanggalSelesai() {
        return tanggalSelesai;
    }

    public void setTanggalSelesai(LocalDate tanggalSelesai) {
        this.tanggalSelesai = tanggalSelesai;
    }

    public String getPimpinanProyek() {
        return pimpinanProyek;
    }

    public void setPimpinanProyek(String pimpinanProyek) {
        this.pimpinanProyek = pimpinanProyek;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    // public Set<ProyekLokasi> getProyekLokasi() {
    //     return proyekLokasi;
    // }

    // public void setProyekLokasi(Set<ProyekLokasi> proyekLokasi) {
    //     this.proyekLokasi = proyekLokasi;
    // }
}
