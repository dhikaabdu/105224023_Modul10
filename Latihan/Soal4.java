import java.util.*;

class Buku {
    String isbn;
    String judul;

    public Buku(String isbn, String judul) {
        this.isbn = isbn;
        this.judul = judul;
    }
}

class Anggota {
    String idAnggota;
    String nama;

    public Anggota(String idAnggota, String nama) {
        this.idAnggota = idAnggota;
        this.nama = nama;
    }
}

public class Soal4 {
    public static void main(String[] args) {

        // Katalog Buku
        Map<String, Buku> katalogBuku = new HashMap<>();

        katalogBuku.put("B001", new Buku("B001", "Pemrograman Java"));
        katalogBuku.put("B002", new Buku("B002", "Struktur Data"));

        // Daftar Anggota
        List<Anggota> daftarAnggota = new ArrayList<>();

        daftarAnggota.add(new Anggota("A001", "Budi"));
        daftarAnggota.add(new Anggota("A002", "Siti"));

        // Antrean
        LinkedList<String> antrean = new LinkedList<>();

        antrean.add("A001#B001");
        antrean.add("A002#B002");
        antrean.add("A001#B001"); // buku sudah dipinjam

        // Buku sedang dipinjam
        Set<String> bukuDipinjam = new HashSet<>();

        while (!antrean.isEmpty()) {

            String data = antrean.removeFirst();

            String[] pecah = data.split("#");

            String idAnggota = pecah[0];
            String isbn = pecah[1];

            boolean anggotaValid = false;

            // cek anggota
            for (Anggota a : daftarAnggota) {
                if (a.idAnggota.equals(idAnggota)) {
                    anggotaValid = true;
                    break;
                }
            }

            // cek buku
            boolean bukuValid = katalogBuku.containsKey(isbn);

            // cek buku sedang dipinjam
            boolean sedangDipinjam = bukuDipinjam.contains(isbn);

            System.out.println("\nMemproses: " + data);

            if (!anggotaValid) {
                System.out.println("GAGAL: Anggota tidak ditemukan");
            }
            else if (!bukuValid) {
                System.out.println("GAGAL: Buku tidak ditemukan");
            }
            else if (sedangDipinjam) {
                System.out.println("GAGAL: Buku sedang dipinjam");
            }
            else {
                bukuDipinjam.add(isbn);

                System.out.println("PEMINJAMAN BERHASIL");
                System.out.println("ID Anggota : " + idAnggota);
                System.out.println("Judul Buku : " + katalogBuku.get(isbn).judul);
            }
        }
    }
}