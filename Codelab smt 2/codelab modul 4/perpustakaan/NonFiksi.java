package perpustakaan;
// mendeklarasikan bahwa antarmuka (interface) NonFiksi berada di dalam paket (package) perpustakaan.

public class NonFiksi extends Buku { //mendeklarasikan sebuah kelas publik (public class) bernama NonFiksi.
    private String bidang; //mendeklarasikan variabel  dengan hak akses private dan tipe data String bernama bidang.

    public NonFiksi(String judul, String penulis, String bidang) { //Konstruktor publik untuk kelas NonFiksi.
        super(judul, penulis); //Memanggil konstruktor kelas induk (Buku).
        this.bidang = bidang; //Menginisialisasi atribut bidang.
    }

    @Override
    public void displayInfo() { //memanggil kelas induk.
        System.out.println("Buku Non-Fiksi: " + judul + " oleh " + penulis + " (Bidang: " + bidang + ")"); //mencetak pesan ke layar.
    }
}
