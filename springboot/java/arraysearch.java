public class arraysearch {
     public static void main(String[] args) {

        int[] angka = {40, 10, 30, 20, 50};
        int cari = 30;

        boolean ditemukan = false;

        for (int i = 0; i < angka.length; i++) {
            if (angka[i] == cari) {
                System.out.println("Data ditemukan di index ke-" + i);
                ditemukan = true;
                break;
            }
        }

        if (!ditemukan) {
            System.out.println("Data tidak ditemukan");
        }
    }
}
