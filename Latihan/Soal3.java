import java.util.*;

public class Soal3 {
    public static void main(String[] args) {

        LinkedList<String> antrean = new LinkedList<>();

        // Mahasiswa -> belakang
        antrean.addLast("A001#B001");

        // Dosen -> depan
        antrean.addFirst("A002#B002");

        // Mahasiswa -> belakang
        antrean.addLast("A003#B003");

        // Dosen -> depan
        antrean.addFirst("A004#B001");

        System.out.println("Isi Antrean:");

        for (String data : antrean) {
            System.out.println(data);
        }
    }
}