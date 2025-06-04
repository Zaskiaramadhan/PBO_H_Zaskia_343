package com.praktikum.users;

import com.praktikum.actions.AdminActions;
import com.praktikum.data.Item;
import com.praktikum.main.LoginSystem;
import java.util.Scanner;

public class Admin extends User implements AdminActions {
    private String username;
    private String password;

    public Admin(String nama, String nim, String username, String password) {
        super(nama, nim);
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean login() {
        for (User user : LoginSystem.userList) {
            if (user instanceof Admin) {
                Admin admin = (Admin) user;
                if (admin.getUsername().equals(this.username) &&
                        admin.getPassword().equals(this.password)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Status: Admin");
        System.out.println("Login berhasil sebagai Admin!");
    }

    @Override
    public void manageItems() {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\n=== KELOLA LAPORAN BARANG ===");
            System.out.println("1. Lihat Semua Laporan");
            System.out.println("2. Tandai Barang Telah Diambil (Claimed)");
            System.out.println("0. Kembali ke Menu Utama");
            System.out.print("Pilihan: ");

            try {
                int pilihan = scanner.nextInt();
                scanner.nextLine();

                switch (pilihan) {
                    case 1:
                        viewAllReports();
                        break;
                    case 2:
                        markItemAsClaimed();
                        break;
                    case 0:
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

    private void viewAllReports() {
        System.out.println("\n=== SEMUA LAPORAN BARANG ===");
        if (LoginSystem.reportedItems.isEmpty()) {
            System.out.println("Belum ada laporan barang.");
        } else { //enhanced for-loop
            for (int i = 0; i < LoginSystem.reportedItems.size(); i++) {
                Item item = LoginSystem.reportedItems.get(i);
                System.out.println((i + 1) + ". " + item.toString());
            }
        }
    }

    private void markItemAsClaimed() {
        if (LoginSystem.reportedItems.isEmpty()) {
            System.out.println("Belum ada laporan barang untuk ditandai.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        viewAllReports();

        System.out.print("\nMasukkan nomor item yang akan ditandai sebagai 'Claimed': ");
        try {
            int index = scanner.nextInt() - 1;

            if (index >= 0 && index < LoginSystem.reportedItems.size()) {
                Item item = LoginSystem.reportedItems.get(index);
                if (item.getStatus().equals("Reported")) {
                    item.setStatus("Claimed");
                    System.out.println("Item '" + item.getItemName() + "' telah ditandai sebagai 'Claimed'.");
                } else {
                    System.out.println("Item sudah memiliki status 'Claimed'.");
                }
            } else {
                System.out.println("Nomor item tidak valid!");
            }
        } catch (Exception e) {
            System.out.println("Input tidak valid! Masukkan nomor yang benar.");
        }
    }

    @Override
    public void manageUsers() {
        System.out.println(">> Fitur Kelola Mahasiswa Belum Tersedia <<");
    }

    @Override
    public void displayAppMenu() { //POLYMORPHISM
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\n=== MENU ADMIN ===");
            System.out.println("1. Kelola Laporan Barang");
            System.out.println("2. Kelola Data Mahasiswa");
            System.out.println("0. Logout");
            System.out.print("Pilihan: ");

            try {
                int pilihan = scanner.nextInt();
                scanner.nextLine();

                switch (pilihan) {
                    case 1:
                        manageItems();
                        break;
                    case 2:
                        manageUsers();
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