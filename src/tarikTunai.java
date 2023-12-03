
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
class TarikTunai extends userBiasa {
    private Map<String, Double> saldoPockets;

    // Constructor untuk inisialisasi data saldoPockets
    public TarikTunai(Map<String, Double> saldoPockets) {
        this.saldoPockets = saldoPockets;
    }

    // Method untuk menangani tarik tunai
    public void handleTarikTunai(Scanner scanner) {
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
}
