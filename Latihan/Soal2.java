import java.util.*;

class Anggota {
    String idAnggota;
    String nama;
    String tipe;

    public Anggota(String idAnggota, String nama, String tipe) {
        this.idAnggota = idAnggota;
        this.nama = nama;
        this.tipe = tipe;
    }

    // Override equals()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Anggota)) return false;

        Anggota anggota = (Anggota) o;

        return idAnggota.equals(anggota.idAnggota);
    }

    // Override hashCode()
    @Override
    public int hashCode() {
        return Objects.hash(idAnggota);
    }

    @Override
    public String toString() {
        return idAnggota + " - " + nama + " (" + tipe + ")";
    }
}

public class Soal2 {
    public static void main(String[] args) {

        Set<Anggota> daftarAnggota = new HashSet<>();

        daftarAnggota.add(new Anggota("A001", "Andhika", "Mahasiswa"));
        daftarAnggota.add(new Anggota("A002", "Zaky", "Dosen"));
        daftarAnggota.add(new Anggota("A003", "Devano", "Mahasiswa"));

        // Data duplikat
        daftarAnggota.add(new Anggota("A001", "Zaky Duplicate", "Dosen"));

        System.out.println("Daftar Anggota:");

        for (Anggota a : daftarAnggota) {
            System.out.println(a);
        }
    }
}