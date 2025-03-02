package modul1tugas1;

import java.util.Scanner;

public class LoginSederhana {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String adminUsername = "zaskia123";
        String adminPassword = "112233";
        String mahasiswaNama = "zaskia123";
        String mahasiswaNIM = "112233";

        System.out.println("Pilih login:");
        System.out.println("1. Admin");
        System.out.println("2. Mahasiswa");
        System.out.print("Masukkan pilihan: ");
        int pilihan = scanner.nextInt();
        scanner.nextLine();

        if (pilihan == 1) {
            System.out.print("Masukkan username: ");
            String username = scanner.nextLine();

            System.out.print("Masukkan password: ");
            String password = scanner.nextLine();

            if (username.equals(adminUsername) && password.equals(adminPassword)) {
                System.out.println("Login Admin berhasil!");
            } else {
                System.out.println("Login Admin gagal! Username atau password salah.");
            }
        } else if (pilihan == 2) {
            System.out.print("Masukkan Nama: ");
            String nama = scanner.nextLine();

            System.out.print("Masukkan NIM: ");
            String nim = scanner.nextLine();
            
            if (nama.equals(mahasiswaNama) && nim.equals(mahasiswaNIM)) {
                System.out.println("Login Mahasiswa berhasil!");
                System.out.println("Nama: " + nama);
                System.out.println("NIM: " + nim);
            } else {
                System.out.println("Login gagal! Nama atau NIM salah.");
            }
        } else {
            System.out.println("Pilihan tidak valid!");
        }

        scanner.close();
    }
}