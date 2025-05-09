package com.praktikum.users;

import com.praktikum.actions.MahasiswaActions;
import java.util.Scanner;

public class Mahasiswa extends User implements MahasiswaActions { //POLYMORPHISM
    public Mahasiswa(String nama, String nim) {
        super(nama, nim);
    }

    @Override
    public boolean login() {
        return getNama().equals("zaskia") && getNim().equals("343");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Status: Mahasiswa");
        System.out.println("Login berhasil sebagai Mahasiswa!");
    }

    @Override
    public void reportItem() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("\n=== LAPORKAN BARANG ===");
        System.out.print("Nama Barang: ");
        String namaBarang = scanner.nextLine();
        
        System.out.print("Deskripsi Barang: ");
        String deskripsiBarang = scanner.nextLine();
        
        System.out.print("Lokasi Terakhir/Ditemukan: ");
        String lokasi = scanner.nextLine();
        
        System.out.println("\nKonfirmasi Laporan:");
        System.out.println("Barang: " + namaBarang);
        System.out.println("Deskripsi: " + deskripsiBarang);
        System.out.println("Lokasi: " + lokasi);
        System.out.println("Laporan telah diterima. Terima kasih!");
    }
    
    @Override
    public void viewReportedItems() {
        System.out.println(">> Fitur Lihat Laporan Belum Tersedia <<");
    }

    @Override
    public void displayAppMenu() { //POLYMORPHISM
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;
        
        while (isRunning) {
            System.out.println("\n=== MENU MAHASISWA ===");
            System.out.println("1. Laporkan Barang Temuan/Hilang");
            System.out.println("2. Lihat Daftar Laporan");
            System.out.println("0. Logout");
            System.out.print("Pilihan: ");
            
            int pilihan = scanner.nextInt();
            scanner.nextLine();
            
            switch (pilihan) {
                case 1:
                    reportItem();
                    break;
                case 2:
                    viewReportedItems();
                    break;
                case 0:
                    System.out.println("Logout berhasil!");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }
}