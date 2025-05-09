package com.praktikum.users;

import com.praktikum.actions.AdminActions;
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
        return username.equals("zaskia") && password.equals("0343");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Status: Admin");
        System.out.println("Login berhasil sebagai Admin!");
    }

    @Override
    public void manageItems() {
        System.out.println(">> Fitur Kelola Barang Belum Tersedia <<");
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
        }
    }
}