import java.util.*;

// CLASS FILM
class Film {
    String judul;
    int hargaTiket;

    public Film(String judul, int hargaTiket) {
        this.judul = judul;
        this.hargaTiket = hargaTiket;
    }
}
// CLASS TRANSAKSI
class Transaksi {
    String namaPemesan;
    String judulFilm;
    String nomorKursi;
    int harga;

    public Transaksi(String namaPemesan, String judulFilm, String nomorKursi, int harga) {
        this.namaPemesan = namaPemesan;
        this.judulFilm = judulFilm;
        this.nomorKursi = nomorKursi;
        this.harga = harga;
    }

    public void tampilkanTransaksi() {
        System.out.println("Nama Pemesan : " + namaPemesan);
        System.out.println("Judul Film   : " + judulFilm);
        System.out.println("Nomor Kursi  : " + nomorKursi);
        System.out.println("Harga Tiket  : Rp " + harga);
        System.out.println("---------------------------");
    }
}

// MAIN CLASS
public class PostTestBioskop {

    public static void main(String[] args) {
        // 1. MENYIMPAN DATA FILM (MAP)
        // Key = Kode Film
        // Value = Objek Film
        Map<String, Film> daftarFilm = new HashMap<>();

        daftarFilm.put("F01", new Film("Avengers", 50000));
        daftarFilm.put("F02", new Film("Interstellar", 45000));
        daftarFilm.put("F03", new Film("Inception", 40000));

        // 2. MENYIMPAN KURSI YANG SUDAH DIPESAN (SET)

        // Menyimpan kursi unik
        Set<String> kursiTerpesan = new HashSet<>();

        // 3. MENYIMPAN RIWAYAT TRANSAKSI (LIST)
        List<Transaksi> riwayatTransaksi = new ArrayList<>();

        // SIMULASI PEMESANAN
        prosesPemesanan(
                "Andhika",
                "F01",
                "A1",
                daftarFilm,
                kursiTerpesan,
                riwayatTransaksi
        );

        prosesPemesanan(
                "Wisnu",
                "F02",
                "B3",
                daftarFilm,
                kursiTerpesan,
                riwayatTransaksi
        );

        prosesPemesanan(
                "Bagas",
                "F03",
                "C2",
                daftarFilm,
                kursiTerpesan,
                riwayatTransaksi
        );

        // GAGAL karena kursi sudah dipakai
        prosesPemesanan(
                "Acep",
                "F01",
                "A1",
                daftarFilm,
                kursiTerpesan,
                riwayatTransaksi
        );

        // CETAK RIWAYAT TRANSAKSI
        System.out.println("\nRIWAYAT TRANSAKSI");

        for (Transaksi transaksi : riwayatTransaksi) {
            transaksi.tampilkanTransaksi();
        }
    }
    // METHOD PEMESANAN
    public static void prosesPemesanan(
            String namaPemesan,
            String kodeFilm,
            String nomorKursi,
            Map<String, Film> daftarFilm,
            Set<String> kursiTerpesan,
            List<Transaksi> riwayatTransaksi
    ) {

        System.out.println("\nMemproses Pemesanan...");
        System.out.println("Nama  : " + namaPemesan);
        System.out.println("Film  : " + kodeFilm);
        System.out.println("Kursi : " + nomorKursi);

        // VALIDASI FILM
        if (!daftarFilm.containsKey(kodeFilm)) {
            System.out.println("GAGAL: Kode film tidak valid!");
            return;
        }

        // VALIDASI KURSI
        if (kursiTerpesan.contains(nomorKursi)) {
            System.out.println("GAGAL: Kursi sudah dipesan!");
            return;
        }

        // Ambil data film
        Film film = daftarFilm.get(kodeFilm);

        // Simpan kursi ke Set
        kursiTerpesan.add(nomorKursi);

        // Simpan transaksi ke List
        riwayatTransaksi.add(
                new Transaksi(
                        namaPemesan,
                        film.judul,
                        nomorKursi,
                        film.hargaTiket
                )
        );

        System.out.println("PEMESANAN BERHASIL!");
    }
}