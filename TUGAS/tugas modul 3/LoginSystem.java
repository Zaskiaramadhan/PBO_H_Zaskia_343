public class LoginSystem {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        System.out.println("=== SISTEM LOGIN ===");
        System.out.println("Pilih jenis login:");
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

            user = new Admin("Admin", "000", username, password);
            loginSuccess = user.login();
        } else if (pilihan == 2) {
            System.out.print("Nama: ");
            String nama = scanner.nextLine();
            System.out.print("NIM: ");
            String nim = scanner.nextLine();

            user = new Mahasiswa(nama, nim);
            loginSuccess = user.login();
        } else {
            System.out.println("Pilihan tidak valid!");
            scanner.close();
            return;
        }

        if (loginSuccess) {
            user.displayInfo();
        } else {
            System.out.println("Login gagal! Periksa kembali kredensial Anda.");
        }

        scanner.close();
    }
}