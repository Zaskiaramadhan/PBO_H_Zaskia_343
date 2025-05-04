package perpustakaan;
// mendeklarasikan bahwa antarmuka (interface) Fiksi berada di dalam paket (package) perpustakaan.

public class Fiksi extends Buku { //mendeklarasikan sebuah kelas publik (public class) bernama Fiksi.
    private String genre; //mendeklarasikan variabel  dengan hak akses private dan tipe data String bernama genre.

    public Fiksi(String judul, String penulis, String genre) { //Konstruktor publik untuk kelas Fiksi.
        super(judul, penulis); //Memanggil konstruktor kelas induk (Buku).
        this.genre = genre; //Menginisialisasi atribut genre.
    }

    @Override
    public void displayInfo() { //memanggil kelas induk.
        System.out.println("Buku Fiksi: " + judul + " oleh " + penulis + " (Genre: " + genre + ")"); //mencetak pesan ke layar.
    }
}