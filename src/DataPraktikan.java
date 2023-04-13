import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DataPraktikan {
    static String nimPraktikan, namaAsisten , loginEmail , loginPassword;
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
        System.out.println("-- List Nim Praktikan --");
        for (String NIM : tabelData.keySet()) {
            System.out.println("List NIM: " + NIM);
        }
    }

    public static void listNamaAsisten(){
        System.out.println("-- List Nama Asisten --");
        for (String Aslab : tabelData.keySet()) {
            String Aslab1 = tabelData.get(Aslab);
            System.out.println("List Nama Asisten: " + Aslab1);
        }
    }

    public static boolean hapusData(String nimPrak, String namaAslab){
        if (tabelData.containsKey(nimPrak)){
            tabelData.remove(nimPrak);
            return true;
        }
        return false;
    }

    public static void editData(String nimPrak, String namaAslab){
        if(tabelData.containsKey(nimPrak)){
            tabelData.remove(nimPrak);
            System.out.print("Masukkan NIM Baru : ");
            nimPraktikan = a.next();
            System.out.print("Masukkan Nama Asisten Baru: ");
            namaAsisten = a.next();
            tabelData.put(nimPraktikan, namaAsisten);
        }else{
            System.out.println("Data Tidak Di Temukan");
        }
    }

    public static void cariData(){
        HashMap<String, String> sameData = new HashMap<>();
        System.out.print("Masukkan Nama Asisten: ");
        namaAsisten = a.next();
        for (Map.Entry<String ,String> entry : tabelData.entrySet()){
            if (entry.getValue().equals(namaAsisten)) {
                sameData.put(entry.getKey(), entry.getValue());
            }
        }

        if (sameData.isEmpty()){
            System.out.println("Nama Asisten : " + namaAsisten + " Yang Anda Cari Tidak Tersedia");
        }else {
            System.out.println("List NIM Dengan Nama Asisten " +namaAsisten);
            for (Map.Entry<String ,String> entry : sameData.entrySet()){
                System.out.println(entry.getKey());
            }
        }
    }

    public static void tabelSesiLogin(){
        HashMap <String, String > login = new HashMap<>();
        login.put("ahmad@umm.ac.id","yumens");

        while (true){
            System.out.println("-- Login --");
            System.out.print("Masukkan Email Anda: ");
            loginEmail = a.next();
            System.out.print("Masukkan Password Anda : ");
            loginPassword = a.next();
            if (login.containsKey(loginEmail) && login.get(loginEmail).equals(loginPassword) ){
                System.out.println("Selamat Datang " +loginEmail);
                Menus();

            }else{
                System.out.println("Maaf Anda Gagal Login");
            }
        }
    }

    public static void tabelLogout(){
        System.out.println("Sampai Jumpa " + loginEmail + " Di Lain Waktu");
        System.exit(0);
    }

    public static void Menus(){
        while (true){
            System.out.print("\nMasukkan Pilihan \n 1. Input Data \n " +
                    "2. Tampil \n " +
                    "3. List NIM Praktikan \n " +
                    "4. List Nama Asisten \n " +
                    "5. Hapus Data \n " +
                    "6. Edit Data \n " +
                    "7. Cari Data \n " +
                    "8. Logout \n");
            System.out.print("Input: ");
            int choose = a.nextInt();

            if (choose == 1 ){
                System.out.println("--Tambah Data Baru--");
                System.out.print("Masukkan NIM: ");
                nimPraktikan  = a.next();
                System.out.print("Masukkan Nama Asisten: ");
                namaAsisten  = a.next();

                boolean inputed = tambahData(nimPraktikan,namaAsisten);
                if (inputed){
                    System.out.println("Data Telah Di Tambahkan");
                }else {
                    System.out.println("Mohon Maaf Harus Ada Inputan Dengan Kombinasi Kata 'IF' ");
                }

            }else if (choose == 2) {
                Tampil();
            }else if(choose == 3){
                listNimPraktikan();
            }else if(choose == 4){
                listNamaAsisten();
            }else if(choose == 5){
                System.out.println("-- Hapus Data --");
                System.out.print("Masukkan NIM: ");
                nimPraktikan = a.next();

                boolean deleted = hapusData(nimPraktikan,namaAsisten);
                if (deleted){
                    System.out.println("Data Dengan NIM " + nimPraktikan + " Telah Di Hapus");
                }else {
                    System.out.println("NIM " + nimPraktikan + " Tidak Terdaftar");
                }
            }else if (choose == 6) {
                System.out.println("-- Edit Data --");
                System.out.print("Masukkan NIM: ");
                nimPraktikan = a.next();
                editData(nimPraktikan,namaAsisten);
            }else if (choose == 7) {
                System.out.println("-- Cari Data --");
                cariData();
            } else if (choose == 8) {
                tabelLogout();
            } else {
                System.out.println("Mohon Maaf, Inputan Anda Salah");
            }
        }
    }


    public static void main(String[] args) {
        tabelSesiLogin();
        System.out.println();

    }

}