public class arraytotal {
   public static void main(String[] args) {
     int angka[] = {10,20,30,40};
     int total = 0;
        for(int nilai : angka){
            total += nilai;
        }
        System.err.println(total);
   } 
}
