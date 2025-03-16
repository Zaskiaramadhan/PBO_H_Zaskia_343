public class RekeningBank { //Membuat kelas dengan nama Rekeningbank
    private String nomorRekening; //Menyimpang nomorRekening sebagai teks dan hanya dapat dilihat di kelas ini
    private String namaPemilik; //Menyimpang namaPemilik sebagai teks dan hanya dapat dilihat di kelas ini
    private double saldo; //Menyimpan saldo dengantipe data double

    public RekeningBank(String nomorRekening, String namaPemilik, double saldo) { //Konstruktor untuk membuat objek RekeningBank
        this.nomorRekening = nomorRekening; //Menyimpan nilai
        this.namaPemilik = namaPemilik;
        this.saldo = saldo;
    }

    public void tampilkanInfo() { //Mendeklarasikan tampilkanInfo
        System.out.println("Nomor Rekening: " + nomorRekening);
        System.out.println("Nama Pemilik: " + namaPemilik);
        System.out.println("Saldo: Rp" + saldo);
    }

    public void setorUang(double jumlah) { //Menerima jumlah uang yang disetorkan
        saldo += jumlah; //Menambahkan jumlah ke saldo saat ini.
        System.out.println(namaPemilik + " menyetor Rp" + jumlah + ". Saldo sekarang: Rp" + saldo); //Menampilkan hasil
    }

    public void tarikUang(double jumlah) { //Mendeklarasikan penarikan uang
        if (saldo >= jumlah) { //Mengecek apakah saldo cukup untuk penarikan.
            saldo -= jumlah;
            System.out.println(namaPemilik + " menarik Rp" + jumlah + ". (Berhasil) Saldo sekarang: Rp" + saldo); //menampilakn pesan jika saldo cukup
        } else {
            System.out.println(namaPemilik + " menarik Rp" + jumlah + ". (Gagal, Saldo tidak mencukupi) Saldo saat ini: Rp" + saldo); //Menampilkan pesan jika saldo tidak cukup
        }
    }
}