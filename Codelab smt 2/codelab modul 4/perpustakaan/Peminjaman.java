package perpustakaan;
// mendeklarasikan bahwa antarmuka (interface) Peminjaman berada di dalam paket (package) perpustakaan.

public interface Peminjaman { //mendeklarasikan sebuah antarmuka publik (public interface) dengan nama Peminjaman.
    void pinjamBuku(String judul); //mendeklarasikan sebuah metode abstrak bernama pinjamBuku.
    void kembalikanBuku(String judul); //mendeklarasikan sebuah metode abstrak bernama kembalikanBuku.
}
