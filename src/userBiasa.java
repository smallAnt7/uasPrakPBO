import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class UserBiasa extends login {
    private Map<String, Double> saldoPockets = new HashMap<>();
    private String namaUser;

    // Constructor untuk inisialisasi data user biasa
    public UserBiasa(String username) {
        this.namaUser = username;
    }

    // Method untuk menampilkan menu user biasa
    public void displayMenu(Scanner scanner) {
        int choice;
       
      
        
        do {
            System.out.println("\nMenu User Biasa:");
            System.out.println("1. Setor Tunai");
            System.out.println("2. Tarik Tunai");
            System.out.println("3. Cek Saldo Poket Tertentu");
            System.out.println("4. Mutasi Poket Tertentu");
            System.out.println("5. Cek Saldo Keseluruhan");
            System.out.println("6. Tambah Poket");
            System.out.println("7. Transfer Antar Poket");
            System.out.println("8. Transfer Beda User");
            System.out.println("9. Update Profile");
            System.out.println("10. Ganti Password");
            System.out.println("11. Hapus Poket");
            System.out.println("12. Keluar");
            System.out.print("Pilih opsi: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Membersihkan newline setelah nextInt

            switch (choice) {
                case 1:
                    setorTunai(scanner);
                    break;
                case 2:
                    tarikTunai(scanner);
                    break;
                case 3:
                    cekSaldoPoket(scanner);
                    break;
                case 4:
                    mutasiPoket(scanner);
                    break;
                case 5:
                    cekSaldoKeseluruhan();
                    break;
                case 6:
                    tambahPoket(scanner);
                    break;
                case 7:
                    transferAntarPoket(scanner);
                    break;
                case 8:
                    updateProfile(scanner);
                    break;
                case 9:
                    gantiPassword(scanner);
                    break;
                case 10:
                    hapusPoket(scanner);
                    break;
                case 11:
                    System.out.println("Keluar dari menu User Biasa.");
                    break;
                default:
                    System.out.println("Opsi tidak valid. Coba lagi.");
            }

        } while (choice != 1);
    }

    // Method untuk menambah saldo poket
    private void setorTunai(Scanner scanner) {
        System.out.print("Masukkan jumlah setoran tunai: ");
        double setoran = scanner.nextDouble();
        scanner.nextLine(); // Membersihkan newline setelah nextDouble

        if (setoran > 0) {
            // Menambahkan setoran tunai ke saldo poket
            saldoPockets.put("Poket Utama", saldoPockets.getOrDefault("Poket Utama", 0.0) + setoran);
            System.out.println("Setoran tunai sebesar " + setoran + " berhasil dilakukan.");
        } else {
            System.out.println("Jumlah setoran tunai tidak valid. Harap masukkan nilai positif.");
        }
    }

    // Method untuk melakukan tarik tunai
    private void tarikTunai(Scanner scanner) {
        System.out.print("Masukkan jumlah penarikan tunai: ");
        double penarikan = scanner.nextDouble();
        scanner.nextLine(); // Membersihkan newline setelah nextDouble

        if (penarikan > 0) {
            // Memeriksa apakah saldo cukup untuk melakukan penarikan
            double saldoUtama = saldoPockets.getOrDefault("Poket Utama", 0.0);
            if (penarikan <= saldoUtama) {
                // Melakukan penarikan tunai dari saldo poket utama
                saldoPockets.put("Poket Utama", saldoUtama - penarikan);
                System.out.println("Penarikan tunai sebesar " + penarikan + " berhasil dilakukan.");
            } else {
                System.out.println("Saldo poket utama tidak mencukupi untuk penarikan tunai tersebut.");
            }
        } else {
            System.out.println("Jumlah penarikan tunai tidak valid. Harap masukkan nilai positif.");
        }
    }

    // Method untuk mengecek saldo poket tertentu
    private void cekSaldoPoket(Scanner scanner) {
        System.out.print("Masukkan nama poket yang ingin dicek saldonya: ");
        String namaPoket = scanner.nextLine();

        double saldo = saldoPockets.getOrDefault(namaPoket, 0.0);
        System.out.println("Saldo poket " + namaPoket + ": " + saldo);
    }

    // Method untuk melihat mutasi poket tertentu
    private void mutasiPoket(Scanner scanner) {
        System.out.print("Masukkan nama poket untuk melihat mutasi: ");
        String namaPoket = scanner.nextLine();

        double saldo = saldoPockets.getOrDefault(namaPoket, 0.0);
        System.out.println("Mutasi poket " + namaPoket + ": " + saldo);
    }

    // Method untuk melihat saldo keseluruhan
    private void cekSaldoKeseluruhan() {
        System.out.println("\nSaldo Keseluruhan:");

        saldoPockets.entrySet().forEach((entry) -> {
            System.out.println("Poket " + entry.getKey() + ": " + entry.getValue());
        });
    }

    // Method untuk menambah poket baru
    private void tambahPoket(Scanner scanner) {
        System.out.print("Masukkan nama poket baru: ");
        String namaPoketBaru = scanner.nextLine();

        if (!saldoPockets.containsKey(namaPoketBaru)) {
            saldoPockets.put(namaPoketBaru, 0.0);
            System.out.println("Paket baru \"" + namaPoketBaru + "\" berhasil ditambahkan.");
        } else {
            System.out.println("Paket dengan nama tersebut sudah ada.");
        }
    }

    // Method untuk melakukan transfer antar poket
    private void transferAntarPoket(Scanner scanner) {
        System.out.print("Masukkan nama poket asal: ");
        String namaPoketAsal = scanner.nextLine();

        System.out.print("Masukkan nama poket tujuan: ");
        String namaPoketTujuan = scanner.nextLine();

        if (saldoPockets.containsKey(namaPoketAsal) && saldoPockets.containsKey(namaPoketTujuan)) {
            System.out.print("Masukkan jumlah transfer: ");
            double jumlahTransfer = scanner.nextDouble();
            scanner.nextLine(); // Membersihkan newline setelah nextDouble

            // Memeriksa apakah saldo poket asal cukup untuk transfer
            double saldoAsal = saldoPockets.getOrDefault(namaPoketAsal, 0.0);
            if (jumlahTransfer <= saldoAsal) {
                // Melakukan transfer antar poket
                saldoPockets.put(namaPoketAsal, saldoAsal - jumlahTransfer);
                saldoPockets.put(namaPoketTujuan, saldoPockets.getOrDefault(namaPoketTujuan, 0.0) + jumlahTransfer);

                System.out.println("Transfer antar poket berhasil dilakukan.");
            } else {
                System.out.println("Saldo poket asal tidak mencukupi untuk transfer tersebut.");
            }
        } else {
            System.out.println("Salah satu atau kedua poket tidak ditemukan.");
        }
    }

    // Method untuk melakukan transfer beda user
    

    // Method untuk mengupdate profil
    private void updateProfile(Scanner scanner) {
        System.out.print("Masukkan nama baru: ");
        String namaBaru = scanner.nextLine();

        // Mengupdate nama user
        this.namaUser = namaBaru;
        System.out.println("Profil berhasil diperbarui.");
    }

    // Method untuk mengganti password
    private void gantiPassword(Scanner scanner) {
        System.out.print("Masukkan password lama: ");
        String passwordLama = scanner.nextLine();

        // Mengganti password (simulasi)
        System.out.print("Masukkan password baru: ");
        String passwordBaru = scanner.nextLine();
        System.out.println("Password berhasil diubah.");
    }

    // Method untuk menghapus poket
    private void hapusPoket(Scanner scanner) {
        System.out.print("Masukkan nama poket yang ingin dihapus: ");
        String namaPoket = scanner.nextLine();

        // Memeriksa apakah poket ada sebelum menghapus
        if (saldoPockets.containsKey(namaPoket)) {
            saldoPockets.remove(namaPoket);
            System.out.println("Poket \"" + namaPoket + "\" berhasil dihapus.");
        } else {
            System.out.println("Poket dengan nama tersebut tidak ditemukan.");
        }
    }
}
    // Method untuk memeriksa informasi login (simulasi)

