/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class Anggota implements Serializable {
    private String idAnggota;
    private String firstName;
    private String lastName;
    private String address;
    private ArrayList<Buku> bukuPinjaman;
    
    public Anggota(){}
    
    public Anggota(String firstName, String lastName, String address){
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        bukuPinjaman = new ArrayList<Buku>();
    }
    
    public void SetIdAnggota(String idAnggota){
        this.idAnggota = idAnggota;
    }
    
    public void SetFirstName(String firstName){
        this.firstName = firstName;
    }
    
    public void SetLastName(String lastName){
        this.lastName = lastName;
    }
    
    public void SetAddress(String emailAddress){
        this.address = emailAddress;
    }
    
    public void SetBukuPinjaman(ArrayList<Buku> bukuPinjaman){
        this.bukuPinjaman = bukuPinjaman;
    }
    
    public String GetIdAnggota(){
        return this.idAnggota;
    }
    
    public String GetFirstName(){
        return this.firstName;
    }
    
    public String GetLastName(){
        return this.lastName;
    }
    
    public String GetAddress(){
        return this.address;
    }
    
    public ArrayList<Buku> GetBukuPinjaman(){
        return bukuPinjaman;
    }
}
