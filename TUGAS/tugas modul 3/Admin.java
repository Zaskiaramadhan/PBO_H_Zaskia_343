class Admin extends User {
    private String username;
    private String password;
    public Admin(String nama, String nim, String username, String password) {
        super(nama, nim);
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean login() {
        return username.equals("Zaskia343") && password.equals("0343");
    }
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Status: Admin");
        System.out.println("Login berhasil sebagai Admin!");
    }
}
