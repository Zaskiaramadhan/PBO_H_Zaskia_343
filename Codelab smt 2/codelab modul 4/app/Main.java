package app;
// mendeklarasikan bahwa antarmuka (interface) main berada di dalam paket (package) app.

import perpustakaan.*; //mengimpor semua kelas dari paket perpustakaan.

public class Main { //mendeklarasikan kelas publik bernama Main.
    public static void main(String[] args) { //mendeklarasikan metode main.
        NonFiksi bukuNonFiksi = new NonFiksi("Madilog", "Tan Malaka", "Sejarah & Ilmu Pengetahuan"); //membuat objek bukuNonFiksi dari kelas NonFiksi.
        Fiksi bukuFiksi = new Fiksi("Hainuwele: Sang Putri Kelapa", "Lilis Hu", "Dongeng"); //membuat objek bukuFiksi dari kelas Fiksi.
        System.out.println(); // Mencetak baris kosong

        Anggota anggota1 = new Anggota("Zaskia Ramadhani", "343"); //membuat objek anggota1 dari kelas Anggota
        Anggota anggota2 = new Anggota("Agni", "057"); //Membuat objek anggota2 dari kelas Anggota
        System.out.println(); // Mencetak baris kosong

        bukuNonFiksi.displayInfo();//menampilkan informasi dari kelas NonFiksi.
        bukuFiksi.displayInfo(); //menampilkan informasi dari kelas Fiksi.
        System.out.println(); // Mencetak baris kosong

        anggota1.displayInfo(); //menampilkan informasi dari kelas anggota1.
        anggota2.displayInfo(); //menampilkan informasi dari kelas anggota2.
        System.out.println(); // Mencetak baris kosong

        anggota1.pinjamBuku("Madilog"); //mendeklarasikan anggota1 meminjam buku.
        anggota2.pinjamBuku("Hainuwele: Sang Putri Kelapa", 7); //mendeklarasikan anggota1 meminjam buku.
        System.out.println(); // Mencetak baris kosong

        anggota1.kembalikanBuku("Madilog"); //mendeklarasikan anggota1 mengembalikan buku.
        anggota2.kembalikanBuku("Hainuwele: Sang Putri Kelapa"); //mendeklarasikan anggota1 mengembalikan buku.
    }
}