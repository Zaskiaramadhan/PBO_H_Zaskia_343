package perpustakaan; // mendeklarasikan bahwa antarmuka (interface) Anggota berada di dalam paket (package) perpustakaan.

public class Anggota implements Peminjaman { //mendeklarasikan sebuah kelas publik bernama Anggota.
    private String nama; //atribut privat nama
    private String idAnggota; //atribut privat idAnggota

    public Anggota(String nama, String idAnggota) { //kontruktor
        this.nama = nama; //menginisialisasi atribut nama.
        this.idAnggota = idAnggota; //menginisialisasi atribut idAnggota.
    }
    public void displayInfo() { //menampilkan info.
        System.out.println("Anggota: " + nama + " (ID: " + idAnggota + ")"); //mencetak pesan informasi anggota.
    }
    public void pinjamBuku(String judul) { //mencatat peminjaman buku berdasarkan judul.
        System.out.println(nama + " meminjam buku berjudul: " + judul); //mencetak pesan peminjaman buku.
    }
    public void pinjamBuku(String judul, int durasiPeminjaman) { //mencatat peminjaman buku dengan durasi.
        System.out.println(nama + " meminjam buku \"" + judul + "\" selama " + durasiPeminjaman + " hari."); //peminjaman buku dengan judul dan durasi.
    }
    @Override
    public void kembalikanBuku(String judul) { //mencatat pengembalian buku.
        System.out.println(nama + " mengembalikan buku berjudul: " + judul); //mencetak pesan.
    }
    public String getNama() { //mencari nama anggota.
        return nama; //mengembalikan nilai.
    }
    public String getIdAnggota() { //mencari nama anggota.
        return idAnggota; //menganbaliikan nilai.
    }
}
