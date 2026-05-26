import java.util.*;

class Buku {
    String isbn;
    String judul;

    public Buku(String isbn, String judul) {
        this.isbn = isbn;
        this.judul = judul;
    }

    public void tampilkanInfo() {
        System.out.println(isbn + " - " + judul);
    }
}

public class Soal1 {
    public static void main(String[] args) {

        // Key = ISBN
        // Value = Objek Buku
        Map<String, Buku> katalogBuku = new HashMap<>();

        katalogBuku.put("B001", new Buku("B001", "Pemrograman Java"));
        katalogBuku.put("B002", new Buku("B002", "Struktur Data"));
        katalogBuku.put("B003", new Buku("B003", "Basis Data"));

        // Cari buku berdasarkan ISBN
        String cariISBN = "B002";

        if (katalogBuku.containsKey(cariISBN)) {
            System.out.println("Buku ditemukan:");
            katalogBuku.get(cariISBN).tampilkanInfo();
        } else {
            System.out.println("Buku tidak ditemukan");
        }
    }
}