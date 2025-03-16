public class Main { //Membuat kelas dengan nama main
    public static void main(String[] args) { //Methodnya

        RekeningBank rekening1 = new RekeningBank("202410370110343", "Zaskia", 900000.0); // // Membuat objek untuk rekening1
        rekening1.tampilkanInfo(); // Memanggil metode tampilakanInfo dari kelas RekeningBank
        System.out.println(); //Mencetak baris kosong

        RekeningBank rekening2 = new RekeningBank("2409036057", "Agni", 1000000.0);  // Membuat objek untuk rekening2
        rekening2.tampilkanInfo();
        System.out.println();

        // Transaksi untuk rekening1
        rekening1.setorUang(150000.0); //Memanggil metode setorUang pada kelas RekeningBank
        rekening1.tarikUang(150000.0); //Memanggil metode tarikUang dari kelas RekeningBank

        // Transaksi untuk rekening2
        rekening2.setorUang(260000.0);
        rekening2.tarikUang(260000.0);

        // untuk menampilkan informasi akhir
        System.out.println();
        rekening1.tampilkanInfo();
        rekening2.tampilkanInfo();
    }
}