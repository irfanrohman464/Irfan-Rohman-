import java.util.ArrayList;
import java.util.Scanner;

public class Mahasiswa {
    private String namaApp = "Aplikasi Data Mahasiswa";
    protected ArrayList<String> daftarNama = new ArrayList<>();

    public String getNamaApp() {
        return namaApp;
    }

    protected void tambahData(String nama) {
        daftarNama.add(nama);
    }

    protected void tampilData() {
        if (daftarNama.isEmpty()) {
            System.out.println("Belum ada data mahasiswa.");
            return;
        }

        for (int i = 0; i < daftarNama.size(); i++) {
            System.out.println((i + 1) + ". " + daftarNama.get(i));
        }
    }

    protected boolean nomorValid(int nomor) {
        return nomor >= 1 && nomor <= daftarNama.size();
    }

    protected void ubahData(int nomor, String nama) {
        if (nomorValid(nomor)) {
            daftarNama.set(nomor - 1, nama);
        }
    }

    protected void hapusData(int nomor) {
        if (nomorValid(nomor)) {
            daftarNama.remove(nomor - 1);
        }
    }

    public static void main(String[] args) {
        Mahasiswa app = new Mahasiswa();
        Scanner input = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\n=== " + app.getNamaApp() + " ===");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Tampilkan Mahasiswa");
            System.out.println("3. Ubah Mahasiswa");
            System.out.println("4. Hapus Mahasiswa");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");

            while (!input.hasNextInt()) {
                System.out.print("Masukkan angka: ");
                input.next();
            }
            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("Nama mahasiswa: ");
                    app.tambahData(input.nextLine());
                    System.out.println("Data berhasil ditambahkan.");
                    break;

                case 2:
                    app.tampilData();
                    break;

                case 3:
                    app.tampilData();
                    System.out.print("Nomor yang diubah: ");
                    int ubah = input.nextInt();
                    input.nextLine();

                    if (app.nomorValid(ubah)) {
                        System.out.print("Nama baru: ");
                        app.ubahData(ubah, input.nextLine());
                        System.out.println("Data berhasil diubah.");
                    } else {
                        System.out.println("Nomor tidak valid.");
                    }
                    break;

                case 4:
                    app.tampilData();
                    System.out.print("Nomor yang dihapus: ");
                    int hapus = input.nextInt();
                    input.nextLine();

                    if (app.nomorValid(hapus)) {
                        app.hapusData(hapus);
                        System.out.println("Data berhasil dihapus.");
                    } else {
                        System.out.println("Nomor tidak valid.");
                    }
                    break;

                case 0:
                    System.out.println("Program selesai.");
                    break;

                default:
                    System.out.println("Pilihan tidak tersedia.");
            }
        } while (pilihan != 0);

        input.close();
    }
}