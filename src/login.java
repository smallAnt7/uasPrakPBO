import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class login {

    private static Map<String, String> userDatabase = new HashMap<>();

    static {
        // Inisialisasi data pengguna (Username, Password)
        userDatabase.put("superadmin", "admin123");
        userDatabase.put("user", "user123");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Meminta pengguna untuk memasukkan username dan password
        System.out.print("Masukkan username: ");
        String username = scanner.nextLine();

        System.out.print("Masukkan password: ");
        String password = scanner.nextLine();

        // Memeriksa apakah informasi login valid
        if (login(username, password)) {
            System.out.println("Login berhasil! Selamat datang, " + username);

            if (isSuperAdmin(username)) {
                System.out.println("Anda memiliki hak akses sebagai super admin.");

                // Membuat objek dari kelas TambahNasabah
                superAdmin tambahMenu = new superAdmin();

                // Menampilkan menu untuk super admin
                tambahMenu.displayMenu(scanner);
            } else {
                System.out.println("Anda memiliki hak akses sebagai user.");

                // Membuat objek dari kelas UserBiasa
                UserBiasa tambahUser= new UserBiasa(username);

                // Menampilkan menu untuk user biasa
                tambahUser.displayMenu(scanner);
            }
        } else {
            System.out.println("Login gagal. Periksa kembali username dan password Anda.");
        }
    }

    // Method untuk memeriksa informasi login
    private static boolean login(String username, String password) {
        // Memeriksa apakah username ada dalam database dan password cocok
        return userDatabase.containsKey(username) && userDatabase.get(username).equals(password);
    }

    // Method untuk memeriksa apakah pengguna memiliki hak akses sebagai super admin
    private static boolean isSuperAdmin(String username) {
        return "superadmin".equals(username);
    }
}
