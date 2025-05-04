package perpustakaan;
// mendeklarasikan bahwa antarmuka (interface) Buku berada di dalam paket (package) perpustakaan.

public abstract class Buku { //mendeklarasikan kelas abstrak publik bernama Buku.
    protected String judul; //atribut judul.
    protected String penulis; //atribut penulis.

    public Buku(String judul, String penulis) { //konstruktor.
        this.judul = judul; //menginisialisasi atribut judul.
        this.penulis = penulis; //menginisialisasi atribut penulis.
    }

    public abstract void displayInfo(); //mendeklarasikan metode abstrak publik displayInfo.
    public String getJudul() { //metode publik getJudul
        return judul; //mengambalikan nilai.
    }
    public String getPenulis() { //metode publik getPenulis
        return penulis; //mengambalikan nilai.
    }
}
