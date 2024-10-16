import java.util.ArrayList;
import java.util.Scanner;

public class EventManager {
        static ArrayList<HelloWorld.Event> eventList = new ArrayList<>();
        static ArrayList<HelloWorld.Peserta> pesertaList = new ArrayList<>();
        static Scanner input = new Scanner(System.in);

        public static void main(String[] args) {
            while (true) {
                System.out.println("\n=== Sistem Manajemen Event ===");
                System.out.println("1. Event");
                System.out.println("2. Peserta");
                System.out.println("0. Keluar");
                System.out.print("Pilih menu: ");
                int pilihan = input.nextInt();
                input.nextLine(); // clear buffer

                switch (pilihan) {
                    case 1:
                        menuEvent();
                        break;
                    case 2:
                        menuPeserta();
                        break;
                    case 0:
                        System.out.println("Terima kasih!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Pilihan tidak valid.");
                }
            }
        }

        public static void menuEvent() {
            System.out.println("\n=== Menu Event ===");
            System.out.println("1. Tambah Event");
            System.out.println("2. Hapus Event");
            System.out.println("3. Edit Event");
            System.out.println("4. Lihat Semua Event");
            System.out.println("5. Cari Event");
            System.out.print("Pilih menu: ");
            int pilihan = input.nextInt();
            input.nextLine(); // clear buffer

            switch (pilihan) {
                case 1:
                    tambahEvent();
                    break;
                case 2:
                    hapusEvent();
                    break;
                case 3:
                    editEvent();
                    break;
                case 4:
                    lihatSemuaEvent();
                    break;
                case 5:
                    cariEvent();
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }

        public static void tambahEvent() {
            System.out.println("=== Tambah Event ===");
            System.out.print("Nama Event: ");
            String namaEvent = input.nextLine();
            System.out.print("Tanggal (DD/MM/YYYY): ");
            String tanggalEvent = input.nextLine();
            System.out.print("Waktu (HH:MM): ");
            String waktuEvent = input.nextLine();
            System.out.print("Tempat Event: ");
            String tempatEvent = input.nextLine();

            HelloWorld.Event newEvent = new HelloWorld.Event(namaEvent, tanggalEvent, waktuEvent, tempatEvent);
            eventList.add(newEvent);
            System.out.println("Event berhasil ditambahkan.");
        }

        public static void hapusEvent() {
            System.out.println("=== Hapus Event ===");
            lihatSemuaEvent();
            System.out.print("Pilih nomor event yang ingin dihapus: ");
            int index = input.nextInt() - 1;

            if (index >= 0 && index < eventList.size()) {
                eventList.remove(index);
                System.out.println("Event berhasil dihapus.");
            } else {
                System.out.println("Event tidak ditemukan.");
            }
        }

        public static void editEvent() {
            System.out.println("=== Edit Event ===");
            lihatSemuaEvent();
            System.out.print("Pilih nomor event yang ingin diedit: ");
            int index = input.nextInt() - 1;
            input.nextLine(); // clear buffer

            if (index >= 0 && index < eventList.size()) {
                HelloWorld.Event event = eventList.get(index);
                System.out.print("Nama Event baru: ");
                String namaEvent = input.nextLine();
                System.out.print("Tanggal baru (DD/MM/YYYY): ");
                String tanggalEvent = input.nextLine();
                System.out.print("Waktu baru (HH:MM): ");
                String waktuEvent = input.nextLine();
                System.out.print("Tempat baru: ");
                String tempatEvent = input.nextLine();

                eventList.set(index, new HelloWorld.Event(namaEvent, tanggalEvent, waktuEvent, tempatEvent));
                System.out.println("Event berhasil diedit.");
            } else {
                System.out.println("Event tidak ditemukan.");
            }
        }

        public static void lihatSemuaEvent() {
            if (eventList.isEmpty()) {
                System.out.println("Belum ada event yang tersedia.");
                return;
            }

            for (int i = 0; i < eventList.size(); i++) {
                System.out.println((i + 1) + ". " + eventList.get(i).getNamaEvent());
            }
        }

        public static void cariEvent() {
            System.out.print("Masukkan nama event yang dicari: ");
            String namaEvent = input.nextLine();
            boolean found = false;

            for (HelloWorld.Event event : eventList) {
                if (event.getNamaEvent().equalsIgnoreCase(namaEvent)) {
                    event.tampilkanDetailEvent();
                    found = true;
                }
            }

            if (!found) {
                System.out.println("Event tidak ditemukan.");
            }
        }

        public static void menuPeserta() {
            System.out.println("\n=== Menu Peserta ===");
            System.out.println("1. Tambah Peserta");
            System.out.println("2. Hapus Peserta");
            System.out.println("3. Lihat Total Peserta");
            System.out.println("4. Lihat Detail Peserta");
            System.out.print("Pilih menu: ");
            int pilihan = input.nextInt();
            input.nextLine(); // clear buffer

            switch (pilihan) {
                case 1:
                    tambahPeserta();
                    break;
                case 2:
                    hapusPeserta();
                    break;
                case 3:
                    lihatTotalPeserta();
                    break;
                case 4:
                    cariPeserta();
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }

        public static void tambahPeserta() {
            System.out.println("=== Tambah Peserta ===");
            System.out.print("Nama Peserta: ");
            String namaPeserta = input.nextLine();
            System.out.print("NIM Peserta: ");
            String nimPeserta = input.nextLine();

            if (eventList.isEmpty()) {
                System.out.println("Tidak ada event yang tersedia. Tambahkan event terlebih dahulu.");
                return;
            }

            System.out.println("Daftar Event: ");
            lihatSemuaEvent();
            System.out.print("Pilih event yang diikuti (nomor): ");
            int eventIndex = input.nextInt() - 1;
            input.nextLine(); // clear buffer

            if (eventIndex >= 0 && eventIndex < eventList.size()) {
                HelloWorld.Event event = eventList.get(eventIndex);
                HelloWorld.Peserta newPeserta = new HelloWorld.Peserta(namaPeserta, nimPeserta, event);
                pesertaList.add(newPeserta);
                event.tambahPeserta(newPeserta);
                System.out.println("Peserta berhasil ditambahkan.");
            } else {
                System.out.println("Event tidak ditemukan.");
            }
        }

        public static void hapusPeserta() {
            System.out.println("=== Hapus Peserta ===");
            cariPeserta();
            System.out.print("Masukkan NIM peserta yang akan dihapus: ");
            String nim = input.nextLine();

            HelloWorld.Peserta pesertaToRemove = null;
            for (HelloWorld.Peserta peserta : pesertaList) {
                if (peserta.getNimPeserta().equalsIgnoreCase(nim)) {
                    pesertaToRemove = peserta;
                    break;
                }
            }

            if (pesertaToRemove != null) {
                pesertaList.remove(pesertaToRemove);
                pesertaToRemove.getEvent().hapusPeserta(pesertaToRemove);
                System.out.println("Peserta berhasil dihapus.");
            } else {
                System.out.println("Peserta tidak ditemukan.");
            }
        }

        public static void lihatTotalPeserta() {
            if (eventList.isEmpty()) {
                System.out.println("Belum ada event yang tersedia.");
                return;
            }

            for (HelloWorld.Event event : eventList) {
                System.out.println("Nama Event: " + event.getNamaEvent() + ", Total Peserta: " + event.getPesertaList().size());
            }
        }

        public static void cariPeserta() {
            System.out.print("Masukkan NIM peserta: ");
            String nim = input.nextLine();

            boolean found = false;
            for (HelloWorld.Peserta peserta : pesertaList) {
                if (peserta.getNimPeserta().equalsIgnoreCase(nim)) {
                    peserta.tampilkanDetailPeserta();
                    found = true;
                }
            }

            if (!found) {
                System.out.println("Peserta tidak ditemukan.");
            }
        }
}
