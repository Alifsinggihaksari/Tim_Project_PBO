package a1prak1evprak13020220042;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */

class ItemBelanjaan {
    private String nama;
    private double harga;

    public ItemBelanjaan(String nama, double harga) {
        this.nama = nama;
        this.harga = harga;
    }

    public String getNama() {
        return nama;
    }

    public double getHarga() {
        return harga;
    }

    @Override
    public String toString() {
        return nama + " - Rp" + harga;
    }
}

public class A1prak1evprak13020220042 {
    public static void main(String[] args) {
         Scanner input = new Scanner(System.in);
        ArrayList<ItemBelanjaan> daftarBelanjaan = new ArrayList<>();
        int pilihan;
        
        do {
            System.out.println("Menu:");
            System.out.println("1. Tambah Item Belanjaan");
            System.out.println("2. Hapus Item Belanjaan");
            System.out.println("3. Tampilkan Seluruh Item Belanjaan");
            System.out.println("4. Cari Item Belanjaan");
            System.out.println("0. Keluar dari program");
            System.out.print("Pilih menu: ");
            pilihan = input.nextInt();
            input.nextLine(); // Mengonsumsi karakter newline

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan Nama Item Belanjaan: ");
                    String nama = input.nextLine();
                    System.out.print("Masukkan Harga Item Belanjaan: ");
                    double harga = input.nextDouble();
                    daftarBelanjaan.add(new ItemBelanjaan(nama, harga));
                    System.out.println("Item Belanjaan Telah Ditambahkan!");
                    break;
                    
                case 2:
                    System.out.print("Masukkan Nama Item Belanjaan yang Akan Dihapus: ");
                    String namaHapus = input.nextLine();
                    boolean removed = false;
                    Iterator<ItemBelanjaan> iterator = daftarBelanjaan.iterator();
                    while (iterator.hasNext()) {
                        ItemBelanjaan item = iterator.next();
                        if (item.getNama().equalsIgnoreCase(namaHapus)) {
                            iterator.remove();
                            System.out.println("Item Belanjaan Telah Dihapus!");
                            removed = true;
                            break;
                        }
                    }
                    if (!removed) {
                        System.out.println("Tidak ada item yang dihapus, harap masukkan nama item yang sesuai!!!");
                    }
                    break;
                    
                case 3:
                    System.out.println("Seluruh Item");
                    System.out.println("============");
                    double totalHarga = 0;
                    for (ItemBelanjaan item : daftarBelanjaan) {
                        System.out.println(item);
                        totalHarga += item.getHarga();
                    }
                    System.out.println("Total Harga: Rp" + totalHarga);
                    break;
                    
                case 4:
                    System.out.print("Masukkan Nama Item Belanjaan yang Dicari: ");
                    String namaCari = input.nextLine();
                    boolean found = false;
                    for (ItemBelanjaan item : daftarBelanjaan) {
                        if (item.getNama().equalsIgnoreCase(namaCari)) {
                            System.out.println(item);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Item Belanjaan Tidak Ditemukan!");
                    }
                    break;
                    
                case 0:
                    System.out.println("Keluar dari program.");
                    break;
                    
                default:
                    System.out.println("Menu tidak tersedia!");
                    break;
            }

            System.out.println();
        } while (pilihan != 0);
        
        input.close();
    }
    
}
