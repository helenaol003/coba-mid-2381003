import java.util.ArrayList;

public class HelloWorld {
    static class Event {
        private String namaEvent;
        private String tanggalEvent;
        private String waktuEvent;
        private String tempatEvent;
        private ArrayList<Peserta> pesertaList = new ArrayList<>();

        public Event(String namaEvent, String tanggalEvent, String waktuEvent, String tempatEvent) {
            this.namaEvent = namaEvent;
            this.tanggalEvent = tanggalEvent;
            this.waktuEvent = waktuEvent;
            this.tempatEvent = tempatEvent;
        }

        public String getNamaEvent() {
            return namaEvent;
        }

        public void tambahPeserta(Peserta peserta) {
            pesertaList.add(peserta);
        }

        public void hapusPeserta(Peserta peserta) {
            pesertaList.remove(peserta);
        }

        public ArrayList<Peserta> getPesertaList() {
            return pesertaList;
        }

        public void tampilkanDetailEvent() {
            System.out.println("Nama Event : " + namaEvent);
            System.out.println("Tanggal    : " + tanggalEvent);
            System.out.println("Waktu      : " + waktuEvent);
            System.out.println("Tempat     : " + tempatEvent);
            System.out.println("Jumlah Peserta: " + pesertaList.size());
        }
    }

    static class Peserta {
        private String namaPeserta;
        private String nimPeserta;
        private Event event;

        public Peserta(String namaPeserta, String nimPeserta, Event event) {
            this.namaPeserta = namaPeserta;
            this.nimPeserta = nimPeserta;
            this.event = event;
        }

        public String getNamaPeserta() {
            return namaPeserta;
        }

        public String getNimPeserta() {
            return nimPeserta;
        }

        public Event getEvent() {
            return event;
        }

        public void tampilkanDetailPeserta() {
            System.out.println("Nama Peserta: " + namaPeserta);
            System.out.println("NIM Peserta : " + nimPeserta);
            System.out.println("Event yang diikuti: " + event.getNamaEvent());
        }
    }
}
