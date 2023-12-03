import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author warda
 */
class superAdmin extends login {
    private Map<String, String> nasabahDatabase = new HashMap<>();

    // Constructor untuk inisialisasi data nasabah
    public superAdmin() {
        // Inisialisasi data nasabah (Nomor Rekening, Nama)
        nasabahDatabase.put("7", "Cristiano Ronaldo");
        nasabahDatabase.put("10", "Lionel Messiun");
        nasabahDatabase.put("22", "Kaka");
        nasabahDatabase.put("9", "Inzaghi");
        nasabahDatabase.put("11", "Neymar");
        nasabahDatabase.put("21", "Andrea Pirlo");
        nasabahDatabase.put("8", "Toni Kroos");
    }

    // Method untuk menampilkan menu tambah nasabah
    public void displayMenu(Scanner scanner) {
        int choice;
        do {
            System.out.println("\nMenu Tambah Nasabah:");
            System.out.println("1. Tambah Nasabah");
            System.out.println("2. Edit Nasabah");
            System.out.println("3. Hapus Nasabah");
            System.out.println("4. Tampilkan Nasabah");
            System.out.println("5. Keluar");
            System.out.print("Pilih opsi: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Membersihkan newline setelah nextInt

            switch (choice) {
                case 1:
                    tambahNasabah(scanner);
                    break;
                case 2:
                    editNasabah(scanner);
                    break;
                case 3:
                    hapusNasabah(scanner);
                    break;
                case 4:
                    tampilkanNasabah();
                    break;
                case 5:
                    System.out.println("Keluar dari menu Tambah Nasabah.");
                    break;
                default:
                    System.out.println("Opsi tidak valid. Coba lagi.");
            }

        } while (choice != 5);
    }

    // Method untuk menambah nasabah
    private void tambahNasabah(Scanner scanner) {
        System.out.print("Masukkan nomor rekening nasabah baru: ");
        String nomorRekening = scanner.nextLine();

        // Memeriksa apakah nomor rekening sudah ada
        if (nasabahDatabase.containsKey(nomorRekening)) {
            System.out.println("Nasabah dengan nomor rekening tersebut sudah ada.");
            return;
        }

        System.out.print("Masukkan nama nasabah baru: ");
        String namaNasabah = scanner.nextLine();

        // Menambahkan nasabah baru ke database
        nasabahDatabase.put(nomorRekening, namaNasabah);

        System.out.println("Nasabah baru berhasil ditambahkan!");
    }

    // Method untuk mengedit nasabah
    private void editNasabah(Scanner scanner) {
        System.out.print("Masukkan nomor rekening nasabah yang ingin diedit: ");
        String nomorRekening = scanner.nextLine();

        // Memeriksa apakah nomor rekening ada dalam database
        if (!nasabahDatabase.containsKey(nomorRekening)) {
            System.out.println("Nasabah dengan nomor rekening tersebut tidak ditemukan.");
            return;
        }

        System.out.print("Masukkan nama baru untuk nasabah: ");
        String namaNasabahBaru = scanner.nextLine();

        // Mengupdate nama nasabah
        nasabahDatabase.put(nomorRekening, namaNasabahBaru);

        System.out.println("Nasabah berhasil diedit!");
    }

    // Method untuk menghapus nasabah
    private void hapusNasabah(Scanner scanner) {
        System.out.print("Masukkan nomor rekening nasabah yang ingin dihapus: ");
        String nomorRekening = scanner.nextLine();

        // Memeriksa apakah nomor rekening ada dalam database
        if (!nasabahDatabase.containsKey(nomorRekening)) {
            System.out.println("Nasabah dengan nomor rekening tersebut tidak ditemukan.");
            return;
        }

        // Menghapus nasabah dari database
        nasabahDatabase.remove(nomorRekening);

        System.out.println("Nasabah berhasil dihapus!");
    }

    // Method untuk menampilkan semua nasabah
    private void tampilkanNasabah() {
        System.out.println("\nDaftar Nasabah:");
        for (Map.Entry<String, String> entry : nasabahDatabase.entrySet()) {
            System.out.println("Nomor Rekening: " + entry.getKey() + ", Nama: " + entry.getValue());
        }
    }
}