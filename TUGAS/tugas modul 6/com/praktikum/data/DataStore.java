package com.praktikum.data;

import com.praktikum.users.User;
import com.praktikum.users.Admin;
import com.praktikum.users.Mahasiswa;
import java.util.ArrayList;

public class DataStore {
    private static DataStore instance;
    private ArrayList<User> userList;
    private ArrayList<Item> reportedItems;

    private DataStore() {
        userList = new ArrayList<>();
        reportedItems = new ArrayList<>();
        initializeDefaultUsers();
    }

    public static DataStore getInstance() {
        if (instance == null) {
            instance = new DataStore();
        }
        return instance;
    }

    private void initializeDefaultUsers() {
        userList.add(new Admin("Admin Z", "000", "zaskia", "0343"));
        userList.add(new Admin("Admin R", "001", "admin", "admin123"));
        userList.add(new Mahasiswa("zaskia", "343"));
        userList.add(new Mahasiswa("kiaaa", "123"));
    }

    public ArrayList<User> getUserList() {
        return userList;
    }

    public ArrayList<Item> getReportedItems() {
        return reportedItems;
    }

    public void addUser(User user) {
        userList.add(user);
    }

    public void addReportedItem(Item item) {
        reportedItems.add(item);
    }

    public User authenticateAdmin(String username, String password) {
        for (User user : userList) {
            if (user instanceof Admin) {
                Admin admin = (Admin) user;
                if (admin.getUsername().equals(username) &&
                        admin.getPassword().equals(password)) {
                    return admin;
                }
            }
        }
        return null;
    }

    public User authenticateMahasiswa(String nama, String nim) {
        for (User user : userList) {
            if (user instanceof Mahasiswa) {
                Mahasiswa mahasiswa = (Mahasiswa) user;
                if (mahasiswa.getNama().equals(nama) &&
                        mahasiswa.getNim().equals(nim)) {
                    return mahasiswa;
                }
            }
        }
        return null;
    }

    public void markItemAsClaimed(int index) {
        if (index >= 0 && index < reportedItems.size()) {
            Item item = reportedItems.get(index);
            if (item.getStatus().equals("Reported")) {
                item.setStatus("Claimed");
            }
        }
    }

    public ArrayList<Item> getReportedOnlyItems() {
        ArrayList<Item> reportedOnly = new ArrayList<>();
        for (Item item : reportedItems) {
            if (item.getStatus().equals("Reported")) {
                reportedOnly.add(item);
            }
        }
        return reportedOnly;
    }
}
