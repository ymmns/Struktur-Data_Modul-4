import java.util.HashMap;
import java.util.Scanner;

public class DataPraktikan {
    static String nimPraktikan, namaAsisten;
    static Scanner a = new Scanner(System.in);
    static HashMap<String, String > tabelData = new HashMap<>();

    public static boolean tambahData(String nimPrak, String namaAslab){
        if (!nimPrak.contains("IF")) {
            return false;
        }
            tabelData.put(nimPrak,namaAslab);
            return true;
    }

    public static void Tampil(){
        System.out.println("Total Data Yang Tersimpan : " +tabelData.size());
        for (String Praktikan : tabelData.keySet()) {
            String Aslab = tabelData.get(Praktikan);
            System.out.println("NIM: " + Praktikan + ", Nama Asisten: " + Aslab);
        }
    }

    public static void listNimPraktikan(){
        for (String NIM : tabelData.keySet()) {
            System.out.println("List NIM: " + NIM);
        }
    }

    public static void listNamaAsisten(){
        for (String Aslab : tabelData.keySet()) {
            String Aslab1 = tabelData.get(Aslab);
            System.out.println("List NIM: " + Aslab1);
        }
    }



    public static void main(String[] args) {
        while (true){
            System.out.print("Masukkan Pilihan \n 1. Input Data \n 2. Tampil \n 3. List NIM Praktikan \n 4. List Nama Asisten \n");
            System.out.print("Input: ");
            int choose = a.nextInt();

            if (choose == 1 ){
                System.out.print("Masukkan NIM: ");
                nimPraktikan  = a.next();
                System.out.print("Masukkan Nama Asisten: ");
                namaAsisten  = a.next();

                boolean inputed = tambahData(nimPraktikan,namaAsisten);
                if (inputed){
                    System.out.println("Success");
                }else {
                    System.out.println("Mohon Maaf Harus Ada Inputan Dengan Kombinasi Kata 'IF' ");
                }

            } else if (choose == 2) {
                Tampil();
            }else if(choose == 3){
                listNimPraktikan();
            }else if(choose == 4){
                listNamaAsisten();
            }
        }
    }

}