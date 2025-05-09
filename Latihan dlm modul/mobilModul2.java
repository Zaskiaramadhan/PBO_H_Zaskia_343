public class mobilModul2 {
    String merk;
    String model;
    String spekMesin;
    int tahun;

    void menyalakanMesin() {
        System.out.println("Mesin mobil menyala");
    }
    String mengemudi(String arah) {
        return "Mobil bergerak ke arah" + arah;
    }
    String mengerem() {
        return "Berhenti";
    }
    int topSpeed(int topSpeed) {
        return topSpeed;
    }

    public static void main(String[] args) {
        mobilModul2 mobil = new mobilModul2();
    }
}