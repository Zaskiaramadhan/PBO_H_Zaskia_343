package com.praktikum.main;

import com.praktikum.users.User;
import com.praktikum.users.Admin;
import com.praktikum.users.Mahasiswa;
import com.praktikum.data.Item;
import java.util.ArrayList;
import java.util.Scanner;

public class LoginSystem {
    public static ArrayList<User> userList = new ArrayList<>();
    public static ArrayList<Item> reportedItems = new ArrayList<>();

    public static void main(String[] args) {
        // Initialize default users
        userList.add(new Admin("Admin Z", "000", "zaskia", "0343"));
        userList.add(new Admin("Admin R", "001", "admin", "admin123"));
        userList.add(new Mahasiswa("zaskia", "343"));
        userList.add(new Mahasiswa("kiaaa", "123"));

        Scanner scanner = new Scanner(System.in);
        boolean systemRunning = true;

        while (systemRunning) {
            System.out.println("\n=== SISTEM LOGIN ===");
            System.out.println("1. Admin");
            System.out.println("2. Mahasiswa");
            System.out.println("0. Keluar");
            System.out.print("Masukkan pilihan (0-2): ");

            try {
                int pilihan = scanner.nextInt();
                scanner.nextLine();

                if (pilihan == 0) {
                    systemRunning = false;
                    continue;
                }

                User user = null;
                boolean loginSuccess = false;

                if (pilihan == 1) {
                    System.out.print("Username: ");
                    String username = scanner.nextLine();
                    System.out.print("Password: ");
                    String password = scanner.nextLine();

                    user = new Admin("", "", username, password);
                    loginSuccess = user.login();

                    if (loginSuccess) {
                        for (User u : userList) {
                            if (u instanceof Admin) {
                                Admin admin = (Admin) u;
                                if (admin.getUsername().equals(username) &&
                                        admin.getPassword().equals(password)) {
                                    user = admin;
                                    break;
                                }
                            }
                        }
                    }

                } else if (pilihan == 2) {
                    System.out.print("Nama: ");
                    String nama = scanner.nextLine();
                    System.out.print("NIM: ");
                    String nim = scanner.nextLine();

                    user = new Mahasiswa(nama, nim);
                    loginSuccess = user.login();

                    if (loginSuccess) {
                        for (User u : userList) {
                            if (u instanceof Mahasiswa) {
                                Mahasiswa mahasiswa = (Mahasiswa) u;
                                if (mahasiswa.getNama().equals(nama) &&
                                        mahasiswa.getNim().equals(nim)) {
                                    user = mahasiswa;
                                    break;
                                }
                            }
                        }
                    }

                } else {
                    System.out.println("Pilihan tidak valid!");
                    continue;
                }

                System.out.println("\n=== Hasil Login ===");
                if (loginSuccess) {
                    user.displayInfo();
                    user.displayAppMenu(); // This will return here after logout
                } else {
                    System.out.println("Login gagal! Periksa kembali kredensial Anda.");
                }

            } catch (Exception e) {
                System.out.println("Input tidak valid! Silakan coba lagi.");
                scanner.nextLine(); // Clear the invalid input
            }
        }

        System.out.println("Program selesai. Terima kasih!");
    }
}