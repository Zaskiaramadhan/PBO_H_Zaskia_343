public class Main { //Membuat kelas main
    public static void main(String[] args) { //Methodnya
        Hewan hewan1 = new Hewan("Kucing", "Mamalia", "Meong~"); //Membuat objek untuk hewan 1
        Hewan hewan2 = new Hewan("Anjing", "Mamalia", "Guk Gukk!!"); // Membuat objek untuk hewan 2

        hewan1.tampilkanInfo();// Memanggil metode tampilakanInfo dari kelas hewan
        hewan2.tampilkanInfo(); // Memanggil metode tampilakanInfo dari kelas hewan
    }
}