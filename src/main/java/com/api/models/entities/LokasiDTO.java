package com.api.models.entities;


import java.sql.Timestamp; // Ubah dari java.security.Timestamp ke java.sql.Timestamp

public class LokasiDTO {

    private Integer id;
    private String nama_lokasi;
    private String negara;
    private String provinsi;
    private String kota;
    private Timestamp created_at; // Ubah dari java.util.Date ke java.sql.Timestamp

    // Constructor default
    public LokasiDTO() {}

    // Constructor dengan parameter
    public LokasiDTO(Integer id, String nama_lokasi, String negara, String provinsi, String kota, Timestamp created_at) {
        this.id = id;
        this.nama_lokasi = nama_lokasi;
        this.negara = negara;
        this.provinsi = provinsi;
        this.kota = kota;
        this.created_at = created_at;
    }

    // Getter dan Setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNama_lokasi() {
        return nama_lokasi;
    }

    public void setNama_lokasi(String nama_lokasi) {
        this.nama_lokasi = nama_lokasi;
    }

    public String getNegara() {
        return negara;
    }

    public void setNegara(String negara) {
        this.negara = negara;
    }

    public String getProvinsi() {
        return provinsi;
    }

    public void setProvinsi(String provinsi) {
        this.provinsi = provinsi;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    @Override
    public String toString() {
        return "LokasiDTO{" +
                "id=" + id +
                ", nama_lokasi='" + nama_lokasi + '\'' +
                ", negara='" + negara + '\'' +
                ", provinsi='" + provinsi + '\'' +
                ", kota='" + kota + '\'' +
                ", created_at=" + created_at +
                '}';
    }
}
