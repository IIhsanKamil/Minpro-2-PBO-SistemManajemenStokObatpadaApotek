package Controller;

import java.util.ArrayList;
import Model.Obat;

public class ManajemenStok {
    private ArrayList<Obat> daftarObat = new ArrayList<>();

    // Method Overloading (Versi 1: Menerima Objek Obat secara langsung)
    public void tambahObat(Obat obat) {
        daftarObat.add(obat);
        System.out.println("Data obat berhasil ditambahkan!");
    }

    // Method Overloading (Versi 2: Menambahkan daftar obat baru secara sekaligus)
    public void tambahObat(ArrayList<Obat> listBaru) {
        daftarObat.addAll(listBaru);
        System.out.println("Beberapa data obat berhasil ditambahkan!");
    }
    
    // READ
    public void tampilkanSemuaObat() {
        if (daftarObat.isEmpty()) {
            System.out.println("Stok obat masih kosong.");
            return;
        }
        
        System.out.println("\n--------------------------------------------------------------------------------------------------");
        System.out.printf("| %-8s | %-18s | %-15s | %-6s | %-13s | %-22s |\n", "ID", "Nama Obat", "Kategori", "Stok", "Harga", "Keterangan Khusus");
        System.out.println("--------------------------------------------------------------------------------------------------");

        for (Obat o : daftarObat) {
            o.tampilkanInfo();
        }
        System.out.println("--------------------------------------------------------------------------------------------------");
    }

    // UPDATE
    public boolean updateObat(String id, String namaBaru, int stokBaru, double hargaBaru) {
        Obat o = cariObatById(id);
        if (o != null) {
            o.setNamaObat(namaBaru);
            o.setStok(stokBaru);
            o.setHarga(hargaBaru);
            return true;
        }
        return false;
    }

    // DELETE
    public boolean hapusObat(String id) {
        Obat o = cariObatById(id);
        if (o != null) {
            daftarObat.remove(o);
            return true;
        }
        return false;
    }

    // Helper Method
    public Obat cariObatById(String id) {
        for (Obat o : daftarObat) {
            if (o.getIdObat().equalsIgnoreCase(id)) {
                return o;
            }
        }
        return null;
    }
    // Method agar tidak ada pesan konfirmasi saat program baru berjalan
    public void tambahObatAwal(Obat obat) {
    daftarObat.add(obat);
    }
    
}