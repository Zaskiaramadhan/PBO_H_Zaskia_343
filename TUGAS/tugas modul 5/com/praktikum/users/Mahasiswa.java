package com.praktikum.users;

import com.praktikum.actions.MahasiswaActions;
import com.praktikum.data.Item;
import com.praktikum.main.LoginSystem;
import java.util.Scanner;

public class Mahasiswa extends User implements MahasiswaActions {
    //POLYMORPHISM
    public Mahasiswa(String nama, String nim) {
        super(nama, nim);
    }

    @Override
    public boolean login() {
        for (User user : LoginSystem.userList) {
            if (user instanceof Mahasiswa) {
                Mahasiswa mahasiswa = (Mahasiswa) user;
                if (mahasiswa.getNama().equals(this.getNama()) &&
                        mahasiswa.getNim().equals(this.getNim())) {
                    return true;
                }
            }
        }
        return false;
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

        try {
            System.out.print("Nama Barang: ");
            String namaBarang = scanner.nextLine();

            System.out.print("Deskripsi Barang: ");
            String deskripsiBarang = scanner.nextLine();

            System.out.print("Lokasi Terakhir/Ditemukan: ");
            String lokasi = scanner.nextLine();

            Item newItem = new Item(namaBarang, deskripsiBarang, lokasi, "Reported");

            LoginSystem.reportedItems.add(newItem);

            System.out.println("\nKonfirmasi Laporan:");
            System.out.println("Barang: " + namaBarang);
            System.out.println("Deskripsi: " + deskripsiBarang);
            System.out.println("Lokasi: " + lokasi);
            System.out.println("Status: Reported");
            System.out.println("Laporan telah diterima. Terima kasih!");

        } catch (Exception e) {
            System.out.println("Terjadi kesalahan saat memasukkan data. Silakan coba lagi.");
        }
    }

    @Override
    public void viewReportedItems() {
        System.out.println("\n=== DAFTAR LAPORAN BARANG ===");

        if (LoginSystem.reportedItems.isEmpty()) {
            System.out.println("Belum ada laporan barang.");
        } else {
            System.out.println("Daftar semua laporan barang:"); //enhanced for-loop
            for (int i = 0; i < LoginSystem.reportedItems.size(); i++) {
                Item item = LoginSystem.reportedItems.get(i);
                if (item.getStatus().equals("Reported")) {
                    System.out.println((i + 1) + ". " + item.toString());
                }
            }
        }
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

            try {
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
            } catch (Exception e) {
                System.out.println("Input tidak valid! Masukkan angka.");
                scanner.nextLine();
            }
        }
    }
}