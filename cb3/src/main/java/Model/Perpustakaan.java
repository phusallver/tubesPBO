/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class Perpustakaan {
    private ArrayList<Buku> daftarBuku;
    private ArrayList<Anggota> daftarAnggota;
    
    public Perpustakaan(){
        daftarBuku = new ArrayList<Buku>();
        daftarAnggota = new ArrayList<Anggota>();
    }
    
    public void SetDaftarBuku(ArrayList<Buku> daftarBuku){
        this.daftarBuku = daftarBuku;
        
    }
    
    public void SetDaftarAnggota(ArrayList<Anggota> daftarAnggota){
        this.daftarAnggota = daftarAnggota;
    }
    
    public ArrayList<Buku> GetDaftarBuku(){
        return this.daftarBuku;
    }
    
    public ArrayList<Anggota> GetDaftarAnggota(){
        return this.daftarAnggota;
    }
    
    public void AddAnggota(Anggota anggota){
        this.daftarAnggota.add(anggota);
    }
    
    public void AddBuku(Buku buku){
        this.daftarBuku.add(buku);
    }
    
    public int CariAnggota(String nama){
        int i = 0;
        for (Anggota anggota : daftarAnggota){
            if (nama.contains(anggota.GetFirstName()) && nama.contains(anggota.GetLastName())){
                return i;
            }
            i++;
        }
        return -1;
    }
    
    public int CariBuku(String judul){
        int i = 0;
        for (Buku buku : daftarBuku){
            if (buku.GetJudulBuku().contains(judul)){
                return i;
            }
            i++;
        }
        return -1;
    }
    
    public String PinjamBuku(String namaPeminjam, String judulBuku){
        
        Buku buku = daftarBuku.get(CariBuku(judulBuku));
        Anggota peminjam = daftarAnggota.get(CariAnggota(namaPeminjam));
        
        if (buku != null && peminjam != null){
            if (!buku.GetStatusPinjam().equals("Terpinjam")){
                //ubah status pinjam dan update list pinjaman
                ArrayList<Buku> listPinjaman = peminjam.GetBukuPinjaman();
                if (listPinjaman.size()==3){
                    return "Quota peminjaman peminjam telah penuh.";
                }
                buku.SetStatusPinjam("Terpinjam");
                listPinjaman.add(buku);
                peminjam.SetBukuPinjaman(listPinjaman);
                return "Buku berhasil dipinjam.";
            }
            return "Buku sedang tidak tersedia.";
        }
        return "Buku atau pengguna tidak ditemukan.";
    }
    
    public String KembalikanBuku(String namaPeminjam, String judulBuku){
        Anggota peminjam = daftarAnggota.get(CariAnggota(namaPeminjam));
        if (peminjam != null){
            for (int i = 0; i < peminjam.GetBukuPinjaman().size(); i++){
                if (peminjam.GetBukuPinjaman().get(i).GetJudulBuku().equals(judulBuku)){
                    //ubah status pinjam dan update list pinjaman
                    daftarBuku.get(CariBuku(judulBuku)).SetStatusPinjam("Tersedia");
                    
                    ArrayList<Buku> listPinjaman = peminjam.GetBukuPinjaman();
                    listPinjaman.remove(i);
                    peminjam.SetBukuPinjaman(listPinjaman);
                    return "Buku berhasil dikembalikan.";
                }
            }
        }
        return "Buku atau pengguna tidak ditemukan, silahkan inputkan ulang.";
    }
    
    public String TambahAnggota(String namaDepan, String namaBelakang, String alamat){
        if (namaDepan.isEmpty() || namaBelakang.isEmpty() || alamat.isEmpty()){
            return "Mohon lengkapi formulir";
        }
        for (Anggota anggota : daftarAnggota){
            if (anggota.GetFirstName().equals(namaDepan) 
                    && anggota.GetLastName().equals(namaBelakang)
                    && anggota.GetAddress().equals(alamat)){
                return "Anggota telah terdaftar dalam database.";
            }
        }
        AddAnggota(new Anggota(namaDepan, namaBelakang, alamat));
        return "Anggota berhasil didaftarkan.";
    }
    
    public String TambahBuku(String judul, String tahunTerbit, String genre, String sinopsis){
        //perlu trycatch
        if (judul.isEmpty() || tahunTerbit.isEmpty() || genre.isEmpty() || sinopsis.isEmpty()){
            return "Mohon lengkapi formulir";
        }
        try {
            AddBuku(new Buku(judul, Integer.parseInt(tahunTerbit), genre, sinopsis));
            return "Buku berhasil ditambahkan kedalam database";
        } catch (NumberFormatException e) {
            return "Inputan tahun terbit harus hanya berupa angka.";
        }
    }
    public String HapusBuku(String judulBuku){
        int idx = CariBuku(judulBuku);
        daftarBuku.remove(idx);
        return "Buku berhasil dihapus dari database.";
    }
}
