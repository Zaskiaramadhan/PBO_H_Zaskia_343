class Mahasiswa extends User {
    public Mahasiswa(String nama, String nim) {
        super(nama, nim);
    }
    @Override
    public boolean login() {
        return getNama().equals("Zaskia") && getNim().equals("343");
    }
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Status: Mahasiswa");
        System.out.println("Login berhasil sebagai Mahasiswa!");
    }
}
