class Hewan { //Membuat kelas hewan
    String nama, jenis, suara; //Mendeklarasikan nama,jenis, suara dengan string yang berarti teks

    public Hewan(String nama, String jenis, String suara) { //Konstruktor untuk membuat objek Hewan
        this.nama = nama; //Menyimpan nilai nama dari parameter ke atribut kelas.
        this.jenis = jenis;
        this.suara = suara;
    }

    public void tampilkanInfo() { //Metode ini menampilkan informasi tentang objek Hewan
        System.out.println("nama: " + nama); //Mencetak nama hewan ke layar.
        System.out.println("jenis: " + jenis);
        System.out.println("suara: " + suara);
        System.out.println(); //enampilkan baris kosong
    }
}
