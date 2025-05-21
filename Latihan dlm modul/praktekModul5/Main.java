public class Main {
    public static void main(String[] args) {
        String[] namaHari = new String[4];
        namaHari[0] = "Jumat";
        namaHari[1] = "Sabtu";
        namaHari[2] = "Minggu";
        namaHari[3] = "Hari Raya";

        int[] angkaKeberuntungan = {7, 11, 21, 4};
        System.out.println("Hari Pertama: " + namaHari[0]);
        System.out.println("Hari Terakhir: " + namaHari[namaHari.length - 1]);
        System.out.println("Panjang array keberuntungan: " + angkaKeberuntungan.length);

        System.out.println("\n Nama-Nama Hari : ");
        for (int i = 0; i < namaHari.length; i++) {
            System.out.println(" Hari ke-" + i + ":" + namaHari[i]);
        }
        System.out.println("\n Angka Keberuntungan anda yaituuu (for-each):");
        for (int angka : angkaKeberuntungan) {
            System.out.println(angka);
        }
    }
}