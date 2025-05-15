import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ManajemenStok {
    public static void main(String[] args) {
        ArrayList<Barang> daftarBarang = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        daftarBarang.add(new Barang("Spidol", 26));
        daftarBarang.add(new Barang("HVS A4", 26));
        daftarBarang.add(new Barang("Notebook", 9));
        daftarBarang.add(new Barang("Map", 9));

        boolean running = true;
        while (running) {
            try {
                System.out.println("\nSELAMAT DATANG DI MANAJEMEN TOKO KAMI");
                System.out.println("===== Menu Manajemen Stok =====");
                System.out.println("1. Tambah Barang Baru");
                System.out.println("2. Tampilkan Semua Barang");
                System.out.println("3. Kurangi Stok Barang");
                System.out.println("0. Keluar");
                System.out.print("Pilih opsi: ");

                String pilihanStr = scanner.nextLine();
                int pilihan;

                try {
                    pilihan = Integer.parseInt(pilihanStr);
                } catch (NumberFormatException e) {
                    System.out.println("Error: Input harus berupa angka!");
                    continue;
                }

                switch (pilihan) {
                    case 1:
                        tambahBarang(scanner, daftarBarang);
                        break;
                    case 2:
                        tampilkanBarang(daftarBarang);
                        break;
                    case 3:
                        kurangiStok(scanner, daftarBarang);
                        break;
                    case 0:
                        running = false;
                        System.out.println("Terima kasih telah menggunakan manajemen toko kami");
                        break;
                    default:
                        System.out.println("Opsi tidak valid. Silakan pilih lagi.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
    }


    private static void tambahBarang(Scanner scanner, ArrayList<Barang> daftarBarang) {
        try {
            System.out.print("Masukkan nama barang: ");
            String nama = scanner.nextLine();
            System.out.print("Masukkan stok awal: ");
            String stokStr = scanner.nextLine();

            int stok;
            try {
                stok = Integer.parseInt(stokStr);
                if (stok < 0) {
                    System.out.println("Error: Stok tidak boleh negatif!");
                    return;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Input stok harus berupa angka!");
                return;
            }

            Barang barangBaru = new Barang(nama, stok);
            daftarBarang.add(barangBaru);
            System.out.println("Barang '" + nama + "' berhasil ditambahkan.");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    private static void tampilkanBarang(ArrayList<Barang> daftarBarang) {
        if (daftarBarang.isEmpty()) {
            System.out.println("Stok barang kosong.");
            return;
        }

        System.out.println("\n--- Daftar Barang ---");
        for (int i = 0; i < daftarBarang.size(); i++) {
            Barang barang = daftarBarang.get(i);
            System.out.println(i + ". Nama: " + barang.getNama() + ", Stok: " + barang.getStok());
        }
        System.out.println("---------------------");
    }

    private static void kurangiStok(Scanner scanner, ArrayList<Barang> daftarBarang) {
        if (daftarBarang.isEmpty()) {
            System.out.println("Stok barang kosong.");
            return;
        }

        try {
            System.out.println("\n--- Daftar Barang (Pilih untuk kurangi Stok) ---");
            for (int i = 0; i < daftarBarang.size(); i++) {
                Barang barang = daftarBarang.get(i);
                System.out.println(i + ". " + barang.getNama() + " (Stok: " + barang.getStok() + ")");
            }
            System.out.print("Masukkan nomor indeks barang: ");
            String indeksStr = scanner.nextLine();

            int indeks;
            try {
                indeks = Integer.parseInt(indeksStr);
            } catch (NumberFormatException e) {
                System.out.println("Error: Input indeks harus berupa angka!");
                return;
            }

            if (indeks < 0 || indeks >= daftarBarang.size()) {
                System.out.println("Error: Indeks tidak valid untuk daftarBarang.");
                return;
            }

            Barang barang = daftarBarang.get(indeks);
            System.out.print("Masukkan jumlah stok yang akan diambil: ");
            String jumlahStr = scanner.nextLine();

            int jumlahDiambil;
            try {
                jumlahDiambil = Integer.parseInt(jumlahStr);
                if (jumlahDiambil <= 0) {
                    System.out.println("Error: Jumlah yang diambil harus positif!");
                    return;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Input jumlah harus berupa angka!");
                return;
            }
            if (jumlahDiambil > barang.getStok()) {
                throw new StokTidakCukupException("Stok untuk " + barang.getNama() +
                        " hanya tersisa " + barang.getStok());
            }
            barang.setStok(barang.getStok() - jumlahDiambil);
            System.out.println("Stok barang '" + barang.getNama() +
                    "' berhasil dikurangi. Sisa stok: " + barang.getStok());

        } catch (StokTidakCukupException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}