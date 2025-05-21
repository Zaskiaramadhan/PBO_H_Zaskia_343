import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.InputMismatchException;

public class daftarBelanja {
    public static void main(String[] args) {
        ArrayList<String> daftarBelanja = new ArrayList<>();
        daftarBelanja.add("Kangkung");
        daftarBelanja.add("Udang");
        daftarBelanja.add("Nasi");
        daftarBelanja.add(1, "Air putih");

        System.out.println("\nDaftar Belanja Awal: " + daftarBelanja);
        System.out.println("Elemen pertama: " + daftarBelanja.get(0));
        daftarBelanja.set(0, "Kangkung Segar");
        System.out.println("Setelah diubah: " + daftarBelanja);

        daftarBelanja.remove(2);
        System.out.println("Setelah 'Udang' dihapus: " + daftarBelanja);
        System.out.println("Ukuran ArrayList sekarang: " + daftarBelanja.size());

        System.out.println("\nMenampilkan Daftar Belanja dengan Iterator:");
        Iterator<String> it = daftarBelanja.iterator();
        while (it.hasNext()) {
            String item = it.next();
            System.out.println("- " + item);
        }

        System.out.println("\nMenampilkan Daftar Belanja dengan for-each:");
        for (String item : daftarBelanja) {
            System.out.println("* " + item);
        }

        Scanner inputScanner = new Scanner(System.in);
        System.out.print("\nMasukkan sebuah angka: ");
        try {
            int angkaInput = inputScanner.nextInt();
            System.out.println("Angka yang dimasukkan: " + angkaInput);
        } catch (InputMismatchException e) {
            System.out.println("Error: Input yang dimasukkan bukan angka yang valid!");
        }

        System.out.println("\nMencoba akses indeks di luar batas ArrayList (daftarBelanja):");
        try {
            System.out.println("Mencoba ambil elemen ke-10: " + daftarBelanja.get(10));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: Indeks yang diakses di luar batas ukuran ArrayList!");
        } finally {
            System.out.println("Blok finally selalu dieksekusi, baik ada error maupun tidak.");
            inputScanner.close();
        }
    }
}