package com.praktikum.main;

import com.praktikum.users.User;
import com.praktikum.users.Admin;
import com.praktikum.users.Mahasiswa;
import java.util.Scanner;

public class LoginSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== SISTEM LOGIN ===");
        System.out.println("Pilih jenis login:");
        System.out.println("\n");
        System.out.println("1. Admin");
        System.out.println("2. Mahasiswa");
        System.out.print("Masukkan pilihan (1/2): ");
        int pilihan = scanner.nextInt();
        scanner.nextLine();
        
        User user = null;
        boolean loginSuccess = false;
        
        if (pilihan == 1) {
            System.out.print("Username: ");
            String username = scanner.nextLine();
            System.out.print("Password: ");
            String password = scanner.nextLine();

            user = new Admin("zaskia", "0343", username, password);
            loginSuccess = user.login();
        } else if (pilihan == 2) {
            System.out.println("\n");
            System.out.print("Nama: ");
            String nama = scanner.nextLine();
            System.out.print("NIM: ");
            String nim = scanner.nextLine();

            user = new Mahasiswa(nama, nim);
            loginSuccess = user.login();
        } else {
            System.out.println("Pilihan tidak valid!");
            return;
        }
        
        System.out.println("\n=== Hasil Login ===");
        if (loginSuccess) {
            user.displayInfo();
            user.displayAppMenu();
        } else {
            System.out.println("Login gagal! Periksa kembali! .");
        }
    }
}