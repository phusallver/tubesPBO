/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.Serializable;

/**
 *
 * @author USER
 */
public class Buku implements Serializable{
    private String judulBuku;
    private int tahunTerbit;
    private String statusPinjam;
    private String genre;
    private String deskripsi;
    private String waktuKembali;
    
    public Buku(){}
    
    public Buku(String judulBuku, int tahunTerbit, String genre, String sinopsis){
        this.judulBuku = judulBuku;
        this.tahunTerbit = tahunTerbit;
        this.genre = genre;
        this.deskripsi = sinopsis;
        this.statusPinjam = "Tersedia";
    }
    
    public void SetJudulBuku(String judulBuku){
        this.judulBuku = judulBuku;
    }
    
    public void SetTahunTerbit(int tahunTerbit){
        this.tahunTerbit = tahunTerbit;
    }
    
    public void SetStatusPinjam(String statusPinjam){
        this.statusPinjam = statusPinjam;
    }
    
    public void SetGenre(String genre){
        this.genre = genre;
    }
    
    public void SetDeskripsi(String deskripsi){
        this.deskripsi = deskripsi;
    }
    
    public String GetJudulBuku(){
        return judulBuku;
    }
    
    public int GetTahunTerbit(){
        return tahunTerbit;
    }
    
    public String GetStatusPinjam(){
        return statusPinjam;
    }
    
    public String GetGenre(){
        return genre;
    }
    
    public String GetDeskripsi(){
        return deskripsi;
    }
    public void SetWaktuKembali(){
        
    }
    public String GetWaktuKembali(){
        return waktuKembali;
    }
}
