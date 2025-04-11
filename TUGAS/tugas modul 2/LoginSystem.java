import java.util.Scanner;

public class LoginSystem {
    private Admin admin;
    private Mahasiswa mahasiswa;
    private Scanner scanner;

    public LoginSystem() {
        // Inisialisasi data admin dan mahasiswa
        admin = new Admin("zaskia123", "112233");
        mahasiswa = new Mahasiswa("zaskia123", "343");
        scanner = new Scanner(System.in);
    }

    public void run() {
        System.out.println("Sistem Login");
        System.out.println("Pilih jenis login:");
        System.out.println("1. Admin");
        System.out.println("2. Mahasiswa");
        System.out.print("Masukkan pilihan: ");

        int pilihan = scanner.nextInt();
        scanner.nextLine(); // Membersihkan buffer

        switch(pilihan) {
            case 1:
                loginAdmin();
                break;
            case 2:
                loginMahasiswa();
                break;
            default:
                System.out.println("Pilihan tidak valid, program akan berhenti.");
        }
    }

    private void loginAdmin() {
        System.out.print("Masukkan username: ");
        String username = scanner.nextLine();

        System.out.print("Masukkan password: ");
        String password = scanner.nextLine();

        if (admin.login(username, password)) {
            System.out.println("Login Admin berhasil!");
        } else {
            System.out.println("Login Admin gagal! Username atau password salah.");
        }
    }

    private void loginMahasiswa() {
        System.out.print("Masukkan Nama: ");
        String nama = scanner.nextLine();

        System.out.print("Masukkan NIM: ");
        String nim = scanner.nextLine();

        if (mahasiswa.login(nama, nim)) {
            System.out.println("Login Mahasiswa berhasil!");
            mahasiswa.displayInfo();
        } else {
            System.out.println("Login gagal! Nama atau NIM salah.");
        }
    }

    public void close() {
        scanner.close();
    }
}

