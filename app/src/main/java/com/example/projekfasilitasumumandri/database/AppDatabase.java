package com.example.projekfasilitasumumandri.database;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.example.projekfasilitasumumandri.database.dbJarak.Jarak;
import com.example.projekfasilitasumumandri.database.dbJarak.JarakDAO;
import com.example.projekfasilitasumumandri.database.dbLokasi.Lokasi;
import com.example.projekfasilitasumumandri.database.dbLokasi.LokasiDAO;
import com.example.projekfasilitasumumandri.database.dbSOS.SOS;
import com.example.projekfasilitasumumandri.database.dbSOS.SOSDAO;

@Database(entities = {Lokasi.class, SOS.class, Jarak.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase instance;

    public abstract LokasiDAO lokasiDAO();
    public abstract SOSDAO sosDAO();
    public abstract JarakDAO jarakDAO();

    public static synchronized AppDatabase getInstance(Context context){
        if (instance==null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class, "database_lokasi").
                    fallbackToDestructiveMigration().
                    addCallback(roomCallBack).
                    build();
        }
        return instance;
    }

    public static RoomDatabase.Callback roomCallBack = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void>{
        LokasiDAO lokasiDAO;
        SOSDAO sosDAO;

        private PopulateDbAsyncTask(AppDatabase db){
            lokasiDAO = db.lokasiDAO();
            sosDAO = db.sosDAO();
        }

        @Override
        protected Void doInBackground(Void... voids) {

            lokasiDAO.insert(new Lokasi("Kantor Lurah Sungai Andai"
                    , "-3.292602", "114.606322", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("Jl. Sultan Adam No.2"
                    , "-3.296981", "114.604160", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("Kantor BP2TPM Kota Banjarmaain"
                    , "-3.296649", "114.603820", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("Dinas Penanaman Modal dan Pelayanan Terpadu Satu Pintu / DPMPTSP Kota Banjarmasin"
                    , "-3.296564", "114.603772", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("Kantor Perwakilan Dagang"
                    , "-3.295613", "114.602701", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("KOPERTIS WILAYAH XI"
                    , "-3.288647", "114.594362", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("Dinas Perindustrian Dan Perdagangan"
                    , "-3.285239", "114.590708", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("Kementrian Hukum Dan Hak Asasi Manusia RI"
                    , "-3.288018", "114.588985", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("Kejaksaan Negeri Banjarmasin"
                    , "-3.289657", "114.589173", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("BPJS Ketenagakerjaan Kacab Banjarmasin"
                    , "-3.294928", "114.589239", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("Dinas Pekerjaan Umum Dan Penataan Ruang"
                    , "--3.295832", "114.589229", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("Kantor Kelurahan Sungai Miai"
                    , "-3.297150", "114.590602", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("Balai Besar Pelaksanaan Jalan Nasional XI"
                    , "-3.300644", "114.589132", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("Kantor Kelurahan Antasan Kecil Timur"
                    , "-3.303380", "114.596392", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("Kantor Kelurahan Pangeran"
                    , "-3.289199", "114.587389", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("Pusat Layanan Disabilitas dan Pendidikan Inklusi Prov. Kalsel (PLDPI)"
                    , "--3.288557", "114.581957", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("Kantor Balai Teknologi Informasi Komunikasi Pendidikan (BTIKP) DINAS PENDIDIKAN PROVINSI KALIMANTAN SELATAN"
                    , "-3.289426", "114.581177", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("Balai Penyuluhan KKBPK Kec Bjm Utara"
                    , "-3.285861", "114.575486", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("Dinas Bina Marga"
                    , "-3.295829", "114.589086", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("Dinas Pendapatan Daerah Provinsi Kalimantan Selatan"
                    , "-3.296626", "114.590066", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("Pengaduan P2KP", "-3.296937"
                    , "114.590503", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("Badan Penanggulangan Bencana Daerah (BPBD) Provinsi Kalsel"
                    , "-3.299986", "114.589406", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("Kantor Perwakilan Dagang"
                    , "-3.295610", "114.602701", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("Kantor Kecamatan Banjarmasin Utara"
                    , "-3.280088", "114.577544", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("DPPKBPM Kota Banjarmasin"
                    , "-3.291918", "114.588065", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("Kantor Kelurahan Alalak Utara"
                    , "-3.275579", "114.582890", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("Pemerintah Kota Banjarmasin"
                    , "-3.327420", "114.588529", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("Kantor Kelurahan Kuin Selatan"
                    , "-3.301530", "114.576117", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("Dinas Pemberdayaan Perempuan dan Perlindungan Anak"
                    , "-3.296664", "114.603822", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("Pemerintah Provinsi Kalimantan Selatan"
                    , "-3.313859", "114.591678", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("Kantor Kelurahan Kuin Selatan"
                    , "-3.301529", "114.576119", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("Ombudsman RI Perwakilan Kalsel"
                    , "-3.311337", "114.589057", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("Kantor Kelurahan Antasan Kecil Timur"
                    , "-3.303383", "114.596394", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("Sekretariat KPU Kota Banjarmasin"
                    , "-3.289304", "114.588207", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("Kantor Sekda Pemerintah Provinsi Kalsel"
                    , "-3.313921", "114.591702", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("Komisi Penyiaran Indonesia"
                    , "-3.299957", "114.571956", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("Kantor Kelurahan Surgi Mufti"
                    , "-3.308184", "114.601270", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("Kementerian Agama Republik Indonesia Kanwil Prop Kalsel"
                    , "-3.316050", "114.590845", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("LPSE Provinsi Kalimantan Selatan"
                    , "-3.313634", "114.589884", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("Kantor Kelurahan Seberang Mesjid"
                    , "-3.311310", "114.595710", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("Kantor Kecamatan Banjarmasin Tengah"
                    , "-3.314377", "114.587785", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("Dinas Penanaman Modal dan Pelayanan Terpadu Satu Pintu / DPMPTSP Kota Banjarmasin"
                    , "-3.296558", "114.603770", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("Kantor Kelurahan Alalak Tengah"
                    , "-3.273187", "114.567629", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("Kantor Pelayanan Perbendaharaan Negara Banjarmasin"
                    , "-3.312753", "114.591710", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("Kantor Kelurahan Belitung Selatan"
                    , "-3.308860", "114.577986", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("KANTOR KEPALA DESA PULAU ALALAK"
                    , "-3.275003", "114.565931", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("Direktorat Jenderal Perbendaharaan"
                    , "-3.315147", "114.590799", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("Kantor Gubernur Kalimantan Selatan"
                    , "-3.314325", "114.591954", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("Pemerintah Kota Banjarmasin Sekretariat Tim Pembina Usaha Kesehatan Sekolah"
                    , "-3.314509", "114.587648", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("Kantor Korem"
                    , "-3.316234", "114.592061", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("Kantor Biro Sarpras Polda Kalsel"
                    , "-3.316345", "114.590987", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("Kantor Kelurahan Gadang"
                    , "-3.317798", "114.595681", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("KANTOR KEPALA DESA SEMANGAT DALAM"
                    , "-3.263424", "114.620710", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("BBPOM di BANJARMASIN"
                    , "-3.294308", "114.589191", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("Kantor Desa Tatah Mesjid"
                    , "-3.263991", "114.583540", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("Kementerian Pekerjaan Umum"
                    , "-3.325617", "114.566733", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("BKKBN Prov. Kalimantan Selatan"
                    , "-3.330563", "114.615064", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("Kantor Badan Perencanaan, Penelitan dan Pengembangan Daerah Kota Banjarmasin"
                    , "-3.327245", "114.588393", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("Kantor Kelurahan Kuripan"
                    , "-3.320371", "114.610221", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("Kantor Kelurahan KERTAK BARU ULU"
                    , "-3.321377", "114.585749", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("Kantor Kementrian Agama"
                    , "-3.315676", "114.588800", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("Kantor Kelurahan Handil Bakti"
                    , "-3.257414", "114.607998", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("Kantor Lurah Kertak Baru Ilir"
                    , "-3.325358", "114.586079", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("Kantor Badan Kesatuan Bangsa & Politik Pemerintahan"
                    , "-3.327182", "114.588428", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("Balai Besar Pelaksanaan Jalan Nasional XI"
                    , "-3.300660", "114.589132", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("Kantor Kelurahan Sungai Baru"
                    , "-3.322106", "114.599165", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("Kantor Kepala Desa Pulau Sugara"
                    , "-3.257475", "114.565224", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("Kantor Administrasi Veteran dan Cadangan VI/08-K-I"
                    , "-3.325739", "114.606244", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("Kantor Dewan Kelurahan Telaga Biru"
                    , "-3.273187", "114.567629", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("Dinas Tata Ruang,Cipta Karya & Perumahan Kota Banjarmasin"
                    , "-3.328355", "114.586162", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("Kantor Kelurahan Belitung Utara"
                    , "-3.302032", "114.579233", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("UPT PENDIDIKAN KEC. BANJARMASIN TIMUR"
                    , "-3.318519", "114.621352", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("Kantor Urusan Agama Alalak"
                    , "-3.254537", "114.563932", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("Kantor Kelurahan Kelayan Luar"
                    , "-3.329297", "114.596487", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("Kantor Dinas Pelabuhan Perikanan Banjarmasin"
                    , "-3.320397", "114.563019", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("Kantor PU Kementrian"
                    , "-3.325093", "114.566467", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("Kantor Kelurahan Kelayan Barat"
                    , "-3.330645", "114.594039", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("Kantor Kelurahan Berangas Barat"
                    , "-3.254667", "114.563933", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("Kantor Kelurahan Kelayan Dalam"
                    , "-3.333699", "114.596277", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("Kementerian Sosial RI"
                    , "-3.318651", "114.583126", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("Kementerian Komunikasi & Informatika"
                    , "-3.320704", "114.623518", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("Kementerian Agraria dan Tata Ruang / Kantor Pertanahan Nasional Banjarmasin"
                    , "-3.337126", "114.631574", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("Kantor Pembakal Sungai Bakung"
                    , "-3.308218", "114.635324", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("Kantor Kelurahan Sungai Lulut"
                    , "-3.323158", "114.626619", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("Kantor Walikota Banjarmasin"
                    , "-3.327775", "114.588716", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("TIPIKOR PENGADILAN TIPIKOR - PHI"
                    , "-3.325190", "114.624703", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("KPUD Kota Banjarmasin"
                    , "-3.289311", "114.588231", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("DINAS PEMUDA OLAHRAGA KEBUDAYAAN DAN PARIWISATA"
                    , "-3.326566", "114.625726", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("Kantor Kelurahan Teluk Tiram"
                    , "-3.338735", "114.582098", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("Kantor OJK Regional 9 Kalimantan"
                    , "-3.340516", "114.619922", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("Kantor BULOG Kalimantan Selatan"
                    , "-3.349161", "114.626583", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("Perbendaharaan Departemen Keuangan Republik Indonesia"
                    , "-3.313073", "114.589339", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("Kantor Kelurahan Murung Raya"
                    , "-3.344689", "114.595985", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("Kantor Kecamatan Banjarmasin Barat"
                    , "-3.318939", "114.564996", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("Dinas Pendapatan Daerah"
                    , "-3.337460", "114.631263", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("Dinas Perhubungan Provinsi Kalimantan Selatan"
                    , "-3.312105", "114.578863", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("Kantor Kelurahan Gadang"
                    , "-3.317728", "114.595715", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("Kantor Wilayah DJP Kalselteng"
                    , "-3.325613", "114.590873", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("Kantor Bagian Pemerintahan Setdako Banjarmasin"
                    , "-3.327421", "114.588535", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("Badan Lingkungan Hidup"
                    , "-3.327221", "114.588333", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("Badan Narkotika Nasional Prov.Kalsel"
                    , "-3.312280", "114.591161", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("Kecamatan Banjarmasin Timur"
                    , "-3.322597", "114.610530", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("DPRD Kota Banjarmasin"
                    , "-3.325042", "114.590438", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("Kantor Pos Cemara Raya"
                    , "-3.292523", "114.592271", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("Kantor DPD RI Perwakilan Kalimantan Selatan"
                    , "--3.324603", "114.617895", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("Badan Pusat Statistik Kota Banjarmasin"
                    , "-3.328075", "114.616772", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("Kantor Kecamatan Banjarmasin Selatan"
                    , "-3.344229", "114.585655", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("Bawaslu Kota Banjarmasin"
                    , "-3.339558", "114.621375", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("Kantor Pelayanan Kekayaan Negara Dan Lelang"
                    , "-3.342337", "114.628728", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("Badan Pemeriksa Keuangan Republik Indonesia Perwakilan Provinsi Kalimantan Selatan"
                    , "-3.445970", "114.811697", "pemerintahan"));
            lokasiDAO.insert(new Lokasi("Kantor Dinas Kependudukan dan Pencatatan Sipil"
                    , "-3.296602", "114.603902", "pemerintahan"));

            lokasiDAO.insert(new Lokasi("Rumah Sakit Islam Banjarmasin"
                    , "-3.307338", "114.589078", "rumahsakit"));
            lokasiDAO.insert(new Lokasi("Rumah Sakit Sjachriel Darham"
                    , "-3.308853", "114.587087", "rumahsakit"));
            lokasiDAO.insert(new Lokasi("Rumah Sakit Mata Banjarmasin"
                    , "-3.313454", "114.584630", "rumahsakit"));
            lokasiDAO.insert(new Lokasi("Rumah Sakit Umum Suaka Insan"
                    , "-3.312889", "114.579323", "rumahsakit"));
            lokasiDAO.insert(new Lokasi("Rumah Sakit Umum Daerah Ulin"
                    , "-3.322837", "114.601188", "rumahsakit"));
            lokasiDAO.insert(new Lokasi("Rumah Sakit Sari Mulia"
                    , "-3.327619", "114.605174", "rumahsakit"));
            lokasiDAO.insert(new Lokasi("Rumah Sakit Bersalin Amanda"
                    , "-3.314714", "114.583174", "rumahsakit"));
            lokasiDAO.insert(new Lokasi("Rumah Sakit Gigi dan Mulut GUSTI HASAN AMAN"
                    , "-3.321931", "114.601660", "rumahsakit"));
            lokasiDAO.insert(new Lokasi("Rumah Sakit Umum Daerah Sultan Suriansyah Banjarmasin"
                    , "-3.298226", "114.604738", "rumahsakit"));
            lokasiDAO.insert(new Lokasi("Rumah Sakit TPT Dr. R. Soeharsono"
                    , "-3.323479", "114.564907", "rumahsakit"));
            lokasiDAO.insert(new Lokasi("Ciputra Mitra Hospital"
                    , "-3.327619", "114.605174", "rumahsakit"));
            lokasiDAO.insert(new Lokasi("Rumah Sakit Sari Mulia"
                    , "-3.327619", "114.605174", "rumahsakit"));
            lokasiDAO.insert(new Lokasi("Rumah Sakit Sari Mulia"
                    , "-3.327619", "114.605174", "rumahsakit"));
            lokasiDAO.insert(new Lokasi("Rumah Sakit Sari Mulia"
                    , "-3.327619", "114.605174", "rumahsakit"));

            lokasiDAO.insert(new Lokasi("SPBU Pertamina Sultan Adam"
                    , "-3.298226", "114.604738", "spbu"));
            lokasiDAO.insert(new Lokasi("SPBU 64.701.02 Adhiyaksa"
                    , "-3.289582", "114.591166", "spbu"));
            lokasiDAO.insert(new Lokasi("SPBU 64.701.10 Banua Anyar"
                    , "-3.311525", "114.616053", "spbu"));
            lokasiDAO.insert(new Lokasi("SPBU 64.701.08 Belitung Darat"
                    , "-3.301973", "114.575350", "spbu"));
            lokasiDAO.insert(new Lokasi("SPBU Pertamina Kayu Tangi"
                    , "-3.281060", "114.589185", "spbu"));
            lokasiDAO.insert(new Lokasi("SPBU Alalak Berangas"
                    , "-3.276185", "114.592921", "spbu"));
            lokasiDAO.insert(new Lokasi("SPBU 64.701.03 S.Parman"
                    , "-3.316135", "114.589913", "spbu"));
            lokasiDAO.insert(new Lokasi("SPBU Sabilal Muhtadin"
                    , "-3.317382", "114.591893", "spbu"));
            lokasiDAO.insert(new Lokasi("SPBU Teluk Dalam 64.701.01"
                    , "-3.317382", "114.591893", "spbu"));
            lokasiDAO.insert(new Lokasi("SPBU Pertamina 64.701.11"
                    , "-3.324533", "114.625195", "spbu"));
            lokasiDAO.insert(new Lokasi("Spbu 63.701.003 VETERAN"
                    , "-3.319399", "114.618686", "spbu"));
            lokasiDAO.insert(new Lokasi("SPBU PERTAMINA 63.701.001"
                    , "-3.345887", "114.608686", "spbu"));
            lokasiDAO.insert(new Lokasi("SPBU PERTAMINA 64.701.07"
                    , "-3.345887", "114.608686", "spbu"));
            lokasiDAO.insert(new Lokasi("SPBU 64.705.01 Handil Bakti"
                    , "-3.251674", "114.611055", "spbu"));
            lokasiDAO.insert(new Lokasi("SPBU Sungai Tabuk Kota"
                    , "-3.315742", "114.694886", "spbu"));

            lokasiDAO.insert(new Lokasi("Polda Kalimantan Selatan"
                    , "-3.312777", "114.589940", "polisi"));
            lokasiDAO.insert(new Lokasi("Polsek Banjarmasin Tengah"
                    , "-3.315866", "114.587455", "polisi"));
            lokasiDAO.insert(new Lokasi("Polsek Banjarmasin Barat"
                    , "-3.318182", "114.564671", "polisi"));
            lokasiDAO.insert(new Lokasi("Polsek Banjarmasin Utara"
                    , "-3.280259", "114.587881", "polisi"));
            lokasiDAO.insert(new Lokasi("Polsek Banjarmasin Timur"
                    , "-3.335337", "114.616243", "polisi"));
            lokasiDAO.insert(new Lokasi("Polsek Banjarmasin Selatan"
                    , "-3.340109", "114.588834", "polisi"));
            lokasiDAO.insert(new Lokasi("Polresta Banjarmasin"
                    , "-3.328758", "114.610971", "polisi"));
            lokasiDAO.insert(new Lokasi("Polsek Kertak Hanyar"
                    , "-3.354847", "114.630048", "polisi"));
            lokasiDAO.insert(new Lokasi("Polsek Sungai Tabuk"
                    , "-3.322753", "114.699481", "polisi"));
            lokasiDAO.insert(new Lokasi("Polisi Perairan Marnit"
                    , "-3.288506", "114.567511", "polisi"));
            lokasiDAO.insert(new Lokasi("Pos Polisi Pasar Lama"
                    , "-3.311730", "114.593111", "polisi"));
            lokasiDAO.insert(new Lokasi("Pos Polisi Handil Bakti"
                    , "-3.276725", "114.597870", "polisi"));
            lokasiDAO.insert(new Lokasi("Pos Polisi Pangeran Samudera"
                    , "-3.324630", "114.591198", "polisi"));
            lokasiDAO.insert(new Lokasi("Pos Polisi Antasari"
                    , "-3.325744", "114.594915", "polisi"));
            lokasiDAO.insert(new Lokasi("Pos Polisi Kayu Tangi"
                    , "-3.303061", "114.589257", "polisi"));
            lokasiDAO.insert(new Lokasi("Pos Polisi Kuripan"
                    , "-3.320296", "114.605274", "polisi"));
            lokasiDAO.insert(new Lokasi("Pos Polisi Pemurus"
                    , "-3.358162", "114.623070", "polisi"));
            lokasiDAO.insert(new Lokasi("Pos Polisi Ujung Panti"
                    , "-3.230319", "114.546519", "polisi"));
            lokasiDAO.insert(new Lokasi("Pos Polisi Barito Kuala"
                    , "-3.241231", "114.616326", "polisi"));
            lokasiDAO.insert(new Lokasi("Pos Polisi Jaga"
                    , "-3.325407", "114.604759", "polisi"));
            lokasiDAO.insert(new Lokasi("Pos Polisi Merdeka"
                    , "-3.320089", "114.592776", "polisi"));
            lokasiDAO.insert(new Lokasi("Pos Polisi Sungai Baru"
                    , "-3.323548", "114.599493", "polisi"));
            lokasiDAO.insert(new Lokasi("Pos Polisi Sudimampir"
                    , "-3.325138", "114.595066", "polisi"));
            lokasiDAO.insert(new Lokasi("Pos SATPOL PP"
                    , "-3.348698", "114.625435", "polisi"));
            lokasiDAO.insert(new Lokasi("Gedung Satpas SIM"
                    , "-3.444317", "114.714443", "polisi"));

            lokasiDAO.insert(new Lokasi("Pasar Terapung Siring Banjarmasin"
                    , "-3.319483", "114.593348", "wisata"));
            lokasiDAO.insert(new Lokasi("Pasar Terapung Lok Baintan"
                    , "-3.288923", "114.664518", "wisata"));
            lokasiDAO.insert(new Lokasi("Museum WASAKA"
                    , "-3.303852", "114.609080", "wisata"));
            lokasiDAO.insert(new Lokasi("Waterboom Pesona Modern"
                    , "-3.388479", "114.649159", "wisata"));
            lokasiDAO.insert(new Lokasi("Waterboom Banua Anyar"
                    , "-3.308396", "114.619254", "wisata"));
            lokasiDAO.insert(new Lokasi("Aquatica Waterpark & Playground"
                    , "-3.463103", "114.776734", "wisata"));
            lokasiDAO.insert(new Lokasi("Taman Kamboja"
                    , "-3.322095", "114.587213", "wisata"));
            lokasiDAO.insert(new Lokasi("Taman Budaya Kalimantan Selatan"
                    , "-3.298213", "114.589889", "wisata"));
            lokasiDAO.insert(new Lokasi("Masjid Sultan Suriansyah"
                    , "-3.294310", "114.576065", "wisata"));
            lokasiDAO.insert(new Lokasi("Masjid Raya Sabilal Muhtadin"
                    , "-3.318948", "114.591266", "wisata"));
            lokasiDAO.insert(new Lokasi("Kelenteng Soetji Nurani"
                    , "-3.320818", "114.594275", "wisata"));
            lokasiDAO.insert(new Lokasi("Menara Pandang Banjarmasin"
                    , "-3.316979", "114.593122", "wisata"));
            lokasiDAO.insert(new Lokasi("Jembatan Barito", "-3.215137"
                    , "114.557972", "wisata"));
            lokasiDAO.insert(new Lokasi("Taman Wisata Alam Pulau Bakut"
                    , "-3.215223", "114.557636", "wisata"));
            lokasiDAO.insert(new Lokasi("Rumah Jomblo", "-3.473684"
                    , "114.859688", "wisata"));
            lokasiDAO.insert(new Lokasi("Bekantan park", "-3.482360"
                    , "114.776468", "wisata"));
            lokasiDAO.insert(new Lokasi("Agrowisata Kebun Durian (Meek Farm)"
                    , "-3.467595", "114.792244", "wisata"));
            lokasiDAO.insert(new Lokasi("Kebun Raya Banua"
                    , "-3.489793", "114.816577", "wisata"));
            lokasiDAO.insert(new Lokasi("Taman Labirin Banua"
                    , "-3.483847", "114.819480", "wisata"));
            lokasiDAO.insert(new Lokasi("Hutan Pinus Mentaos"
                    , "-3.434582", "114.833611", "wisata"));
            lokasiDAO.insert(new Lokasi("Taman Kota Van Der Peijl"
                    , "-3.442612", "114.832405", "wisata"));
            lokasiDAO.insert(new Lokasi("Danau Galuh Cempaka"
                    , "-3.507582", "114.774822", "wisata"));
            lokasiDAO.insert(new Lokasi("Wisata Danau Seran"
                    , "-3.489301", "114.791415", "wisata"));
            lokasiDAO.insert(new Lokasi("Pulau Kembang"
                    , "-3.299805", "114.560724", "wisata"));
            lokasiDAO.insert(new Lokasi("Danau Caramin"
                    , "-3.492646", "114.762873", "wisata"));
            lokasiDAO.insert(new Lokasi("Bukit Teletubbies"
                    , "-3.848581", "114.789870", "wisata"));
            lokasiDAO.insert(new Lokasi("Taman Hutan Raya Sultan Adam"
                    , "-3.519027", "114.950231", "wisata"));
            lokasiDAO.insert(new Lokasi("Bukit Matang Kaladan"
                    , "-3.525415", "115.009422", "wisata"));

            lokasiDAO.insert(new Lokasi("Toilet Umum Ujung Murung"
                    , "-3.324165", "114.595982", "toilet"));
            lokasiDAO.insert(new Lokasi("WC Umum Pasar Batuah"
                    , "-3.320238", "114.609238", "toilet"));
            lokasiDAO.insert(new Lokasi("Toilet Umum Seberang Mesjid"
                    , "-3.311307", "114.597557", "toilet"));
            lokasiDAO.insert(new Lokasi("WC KSM Wijaya Permai"
                    , "-3.324165", "114.595982", "toilet"));
            lokasiDAO.insert(new Lokasi("Toilet Umum Ujung Murung"
                    , "-3.324165", "114.595982", "toilet"));

            lokasiDAO.insert(new Lokasi("Bank Kalsel"
                    , "-3.317338", "114.584142", "atm"));
            lokasiDAO.insert(new Lokasi("Bank Kalsel"
                    , "-3.322898", "114.591383", "atm"));
            lokasiDAO.insert(new Lokasi("Bank Kalsel"
                    , "-3.320237", "114.583038", "atm"));
            lokasiDAO.insert(new Lokasi("Bank Kalsel"
                    , "-3.302228", "114.575506", "atm"));
            lokasiDAO.insert(new Lokasi("Bank Kalsel"
                    , "-3.317646", "114.590867", "atm"));
            lokasiDAO.insert(new Lokasi("Bank Kalsel"
                    , "-3.328891", "114.601569", "atm"));
            lokasiDAO.insert(new Lokasi("Bank Kalsel"
                    , "-3.325584", "114.604025", "atm"));
            lokasiDAO.insert(new Lokasi("Bank Kalsel"
                    , "-3.327570", "114.604758", "atm"));
            lokasiDAO.insert(new Lokasi("Bank Kalsel"
                    , "-3.313750", "114.591428", "atm"));
            lokasiDAO.insert(new Lokasi("Bank Kalsel"
                    , "-3.307163", "114.596091", "atm"));
            lokasiDAO.insert(new Lokasi("Bank Kalsel"
                    , "-3.311573", "114.589586", "atm"));
            lokasiDAO.insert(new Lokasi("Bank Kalsel"
                    , "-3.308221", "114.597898", "atm"));
            lokasiDAO.insert(new Lokasi("Bank Kalsel"
                    , "-3.330691", "114.589357", "atm"));
            lokasiDAO.insert(new Lokasi("Bank Kalsel"
                    , "-3.333425", "114.579530", "atm"));
            lokasiDAO.insert(new Lokasi("Bank Kalsel"
                    , "-3.310518", "114.567698", "atm"));
            lokasiDAO.insert(new Lokasi("Bank Kalsel"
                    , "-3.325666", "114.585898", "atm"));
            lokasiDAO.insert(new Lokasi("Bank Kalsel"
                    , "-3.308651", "114.588614", "atm"));
            lokasiDAO.insert(new Lokasi("Bank Kalsel"
                    , "-3.288822", "114.589230", "atm"));
            lokasiDAO.insert(new Lokasi("Bank Kalsel"
                    , "-3.325675", "114.605923", "atm"));
            lokasiDAO.insert(new Lokasi("Bank Kalsel"
                    , "-3.315936", "114.592277", "atm"));
            lokasiDAO.insert(new Lokasi("Bank Kalsel"
                    , "-3.323966", "114.591123", "atm"));
            lokasiDAO.insert(new Lokasi("Bank Kalsel"
                    , "-3.325752", "114.617209", "atm"));
            lokasiDAO.insert(new Lokasi("Bank Kalsel"
                    , "-3.322859", "114.601561", "atm"));
            lokasiDAO.insert(new Lokasi("Bank Kalsel"
                    , "-3.331019", "114.612384", "atm"));
            lokasiDAO.insert(new Lokasi("Bank Kalsel"
                    , "-3.308593", "114.588451", "atm"));
            lokasiDAO.insert(new Lokasi("Bank Kalsel"
                    , "-3.323584", "114.617687", "atm"));
            lokasiDAO.insert(new Lokasi("Bank Kalsel"
                    , "-3.323819", "114.601300", "atm"));
            lokasiDAO.insert(new Lokasi("Bank Kalsel"
                    , "-3.327906", "114.589220", "atm"));
            lokasiDAO.insert(new Lokasi("Bank Kalsel"
                    , "-3.297164", "114.590017", "atm"));
            lokasiDAO.insert(new Lokasi("Bank Kalsel"
                    , "-3.319403", "114.608371", "atm"));
            lokasiDAO.insert(new Lokasi("Bank Kalsel"
                    , "-3.285033", "114.581909", "atm"));
            lokasiDAO.insert(new Lokasi("Bank Kalsel"
                    , "-3.300545", "114.589633", "atm"));
            lokasiDAO.insert(new Lokasi("Bank Kalsel"
                    , "-3.289179", "114.594494", "atm"));
            lokasiDAO.insert(new Lokasi("Bank Kalsel"
                    , "-3.320413", "114.564046", "atm"));
            lokasiDAO.insert(new Lokasi("Bank Kalsel"
                    , "-3.325849", "114.590182", "atm"));
            lokasiDAO.insert(new Lokasi("Bank Kalsel"
                    , "-3.327553", "114.598362", "atm"));
            lokasiDAO.insert(new Lokasi("Bank Kalsel"
                    , "-3.352136", "114.622463", "atm"));
            lokasiDAO.insert(new Lokasi("Bank Kalsel"
                    , "-3.337157", "114.631276", "atm"));
            lokasiDAO.insert(new Lokasi("Bank Kalsel"
                    , "-3.312005", "114.616895", "atm"));
            lokasiDAO.insert(new Lokasi("Bank Kalsel"
                    , "-3.338469", "114.616121", "atm"));


            lokasiDAO.insert(new Lokasi("Bank BRI"
                    , "-3.336838", "114.616290", "atm"));
            lokasiDAO.insert(new Lokasi("Bank BRI"
                    , "-3.339291", "114.618933", "atm"));
            lokasiDAO.insert(new Lokasi("Bank BRI"
                    , "-3.338195", "114.618312", "atm"));
            lokasiDAO.insert(new Lokasi("Bank BRI"
                    , "-3.333482", "114.615052", "atm"));
            lokasiDAO.insert(new Lokasi("Bank BRI"
                    , "-3.344188", "114.621878", "atm"));
            lokasiDAO.insert(new Lokasi("Bank BRI"
                    , "-3.328524", "114.609860", "atm"));
            lokasiDAO.insert(new Lokasi("Bank BRI"
                    , "-3.327361", "114.608198", "atm"));
            lokasiDAO.insert(new Lokasi("Bank BRI"
                    , "-3.321196", "114.596672", "atm"));
            lokasiDAO.insert(new Lokasi("Bank BRI"
                    , "-3.321236", "114.623061", "atm"));
            lokasiDAO.insert(new Lokasi("Bank BRI"
                    , "-3.324552", "114.601710", "atm"));
            lokasiDAO.insert(new Lokasi("Bank BRI"
                    , "-3.318554", "114.604104", "atm"));
            lokasiDAO.insert(new Lokasi("Bank BRI"
                    , "-3.322195", "114.605458", "atm"));
            lokasiDAO.insert(new Lokasi("Bank BRI"
                    , "-3.327505", "114.597277", "atm"));
            lokasiDAO.insert(new Lokasi("Bank BRI"
                    , "-3.319439", "114.618000", "atm"));
            lokasiDAO.insert(new Lokasi("Bank BRI"
                    , "-3.333406", "114.614125", "atm"));
            lokasiDAO.insert(new Lokasi("Bank BRI"
                    , "-3.311991", "114.616923", "atm"));
            lokasiDAO.insert(new Lokasi("Bank BRI"
                    , "-3.319891", "114.609899", "atm"));
            lokasiDAO.insert(new Lokasi("Bank BRI"
                    , "-3.301495", "114.608583", "atm"));
            lokasiDAO.insert(new Lokasi("Bank BRI"
                    , "-3.324412", "114.625134", "atm"));
            lokasiDAO.insert(new Lokasi("Bank BRI"
                    , "-3.298553", "114.604544", "atm"));
            lokasiDAO.insert(new Lokasi("Bank BRI"
                    , "-3.349839", "114.617385", "atm"));
            lokasiDAO.insert(new Lokasi("Bank BRI"
                    , "-3.320309", "114.596317", "atm"));
            lokasiDAO.insert(new Lokasi("Bank BRI"
                    , "-3.343855", "114.629568", "atm"));
            lokasiDAO.insert(new Lokasi("Bank BRI"
                    , "-3.305549", "114.602230", "atm"));
            lokasiDAO.insert(new Lokasi("Bank BRI"
                    , "-3.325040", "114.592352", "atm"));
            lokasiDAO.insert(new Lokasi("Bank BRI"
                    , "-3.352176", "114.622445", "atm"));
            lokasiDAO.insert(new Lokasi("Bank BRI"
                    , "-3.317457", "114.591874", "atm"));
            lokasiDAO.insert(new Lokasi("Bank BRI"
                    , "-3.330746", "114.589390", "atm"));
            lokasiDAO.insert(new Lokasi("Bank BRI"
                    , "-3.307164", "114.596080", "atm"));
            lokasiDAO.insert(new Lokasi("Bank BRI"
                    , "-3.330746", "114.589390", "atm"));
            lokasiDAO.insert(new Lokasi("Bank BRI"
                    , "-3.330746", "114.589390", "atm"));

            lokasiDAO.insert(new Lokasi("Bank BNI"
                    , "-3.290233", "114.596481", "atm"));
            lokasiDAO.insert(new Lokasi("Bank BNI"
                    , "-3.296441", "114.609426", "atm"));
            lokasiDAO.insert(new Lokasi("Bank BNI"
                    , "-3.273029", "114.599723", "atm"));
            lokasiDAO.insert(new Lokasi("Bank BNI"
                    , "-3.276371", "114.596570", "atm"));
            lokasiDAO.insert(new Lokasi("Bank BNI"
                    , "-3.291631", "114.594237", "atm"));
            lokasiDAO.insert(new Lokasi("Bank BNI"
                    , "-3.280953", "114.589118", "atm"));
            lokasiDAO.insert(new Lokasi("Bank BNI"
                    , "-3.289650", "114.591060", "atm"));
            lokasiDAO.insert(new Lokasi("Bank BNI"
                    , "-3.288850", "114.589287", "atm"));
            lokasiDAO.insert(new Lokasi("Bank BNI"
                    , "-3.282078", "114.579482", "atm"));
            lokasiDAO.insert(new Lokasi("Bank BNI"
                    , "-3.298584", "114.604572", "atm"));
            lokasiDAO.insert(new Lokasi("Bank BNI"
                    , "-3.297789", "114.587841", "atm"));
            lokasiDAO.insert(new Lokasi("Bank BNI"
                    , "-3.294519", "114.601061", "atm"));
            lokasiDAO.insert(new Lokasi("Bank BNI"
                    , "-3.300899", "114.589726", "atm"));
            lokasiDAO.insert(new Lokasi("Bank BNI"
                    , "-3.302553", "114.588786", "atm"));
            lokasiDAO.insert(new Lokasi("Bank BNI"
                    , "-3.305368", "114.601919", "atm"));
            lokasiDAO.insert(new Lokasi("Bank BNI"
                    , "-3.294510", "114.601062", "atm"));
            lokasiDAO.insert(new Lokasi("Bank BNI"
                    , "-3.302804", "114.589141", "atm"));
            lokasiDAO.insert(new Lokasi("Bank BNI"
                    , "-3.309324", "114.585873", "atm"));
            lokasiDAO.insert(new Lokasi("Bank BNI"
                    , "-3.309336", "114.585878", "atm"));
            lokasiDAO.insert(new Lokasi("Bank BNI"
                    , "-3.310670", "114.590297", "atm"));
            lokasiDAO.insert(new Lokasi("Bank BNI"
                    , "-3.326904", "114.590321", "atm"));
            lokasiDAO.insert(new Lokasi("Bank BNI"
                    , "-3.301164", "114.572713", "atm"));
            lokasiDAO.insert(new Lokasi("Bank BNI"
                    , "-3.314988", "114.591305", "atm"));
            lokasiDAO.insert(new Lokasi("Bank BNI"
                    , "-3.311967", "114.616966", "atm"));
            lokasiDAO.insert(new Lokasi("Bank BNI"
                    , "-3.315081", "114.610997", "atm"));
            lokasiDAO.insert(new Lokasi("Bank BNI"
                    , "-3.302263", "114.575458", "atm"));
            lokasiDAO.insert(new Lokasi("Bank BNI"
                    , "-3.310710", "114.588979", "atm"));
            lokasiDAO.insert(new Lokasi("Bank BNI"
                    , "-3.315796", "114.599053", "atm"));
            lokasiDAO.insert(new Lokasi("Bank BNI"
                    , "-3.312409", "114.589561", "atm"));
            lokasiDAO.insert(new Lokasi("Bank BNI"
                    , "-3.322678", "114.603108", "atm"));
            lokasiDAO.insert(new Lokasi("Bank BNI"
                    , "-3.320256", "114.597303", "atm"));
            lokasiDAO.insert(new Lokasi("Bank BNI"
                    , "-3.296435", "114.609391", "atm"));
            lokasiDAO.insert(new Lokasi("Bank BNI"
                    , "-3.276314", "114.596626", "atm"));
            lokasiDAO.insert(new Lokasi("Bank BNI"
                    , "-3.305427", "114.601987", "atm"));
            lokasiDAO.insert(new Lokasi("Bank BNI"
                    , "-3.322159", "114.605489", "atm"));
            lokasiDAO.insert(new Lokasi("Bank BNI"
                    , "-3.278708", "114.588146", "atm"));
            lokasiDAO.insert(new Lokasi("Bank BNI"
                    , "-3.322060", "114.589344", "atm"));
            lokasiDAO.insert(new Lokasi("Bank BNI"
                    , "-3.232319", "114.600177", "atm"));
            lokasiDAO.insert(new Lokasi("Bank BNI"
                    , "-3.330787", "114.589636", "atm"));
            lokasiDAO.insert(new Lokasi("Bank BNI"
                    , "-3.324982", "114.561831", "atm"));

            sosDAO.insert(new SOS("Polda Kalimantan Selatan-Jl. Let. Jend. S. Parman No.16, Antasan Besar, Kec. Banjarmasin Tengah, Kota Banjarmasin, Kalimantan Selatan 70123"
                    , "-3.312777", "114.589935", "0511-3368571", "kepolisian"));
            sosDAO.insert(new SOS("Polresta Banjarmasin-Jl. Jend. A Yani Km. 3,5, Kebun Bunga, Kec. Banjarmasin Tim., Kota Banjarmasin, Kalimantan Selatan 70237"
                    , "-3.328758", "114.610971", "0511-3251411", "kepolisian"));
            sosDAO.insert(new SOS("Polsekta Banjarmasin Tengah-Jl. Meratus, Antasan Besar, Banjarmasin, Kota Banjarmasin, Kalimantan Selatan 70114"
                    , "-3.315861", "114.587456", "0511-53003", "kepolisian"));
            sosDAO.insert(new SOS("Polsekta Banjarmasin Barat-Jl. Ir. P. M. Noor No. 50, Banjarmasin Barat, Pelambuan, Banjarmasin Bar., Kota Banjarmasin, Kalimantan Selatan 70118"
                    , "-3.318179", "114.564670", "0511-4412952", "kepolisian"));
            sosDAO.insert(new SOS("Polsekta Banjarmasin Timur-Jalan A. Yani Km 4.5, Banjarmasin Selatan, Kebun Bunga, Kec. Banjarmasin Tim., Kota Banjarmasin, Kalimantan Selatan 70238"
                    , "-3.312777", "114.589935", "0511-3252473", "kepolisian"));
            sosDAO.insert(new SOS("Polsekta Banjarmasin Selatan-Jl. Tembus Mantuil, Kelayan Sel., Kec. Banjarmasin Sel., Kota Banjarmasin, Kalimantan Selatan 70233"
                    , "-3.340111", "114.588836", "0511-3261244", "kepolisian"));
            sosDAO.insert(new SOS("Polsekta Banjarmasin Utara-Jl. Brig Jend. Hasan Basri, Alalak Utara, Kec. Banjarmasin Utara, Kota Banjarmasin, Kalimantan Selatan 70123"
                    , "-3.280266", "114.587881", "0511-3300463", "kepolisian"));

            sosDAO.insert(new SOS("Bpk Rajawali-Jl. Keramat Raya No.5, Sungai Bilu, Kec. Banjarmasin Tim., Kota Banjarmasin, Kalimantan Selatan 70239"
                    , "-3.318244", "114.606151", "(0511) 253435", "bpk"));
            sosDAO.insert(new SOS("Posko Bpk Seberang Mesjid-Jl. Kamp Melayu, Seberang Mesjid, Kec. Banjarmasin Tengah, Kota Banjarmasin, Kalimantan Selatan 70122"
                    , "-3.313796", "114.597641", "0812-5007-939", "bpk"));
            sosDAO.insert(new SOS("BPK KPI Ton II-Jl. Sultan Adam, Surgi Mufti, Kec. Banjarmasin Utara, Kota Banjarmasin, Kalimantan Selatan 70122"
                    , "-3.308564", "114.602058", "(0511) 6245670", "bpk"));
            sosDAO.insert(new SOS("POSKO BPK AMPERA 1-Bengkel Hafidz, Jalan Ampera Raya, Basirih, Banjarmasin Barat, Basirih, Banjarmasin Bar., Kota Banjarmasin, Kalimantan Selatan 70114"
                    , "-3.334362", "114.577488", "0821-5794-5561", "bpk"));
            sosDAO.insert(new SOS("Posko BPK Loksado-Jl. Prona III, Pemurus Baru, Kec. Banjarmasin Sel., Kota Banjarmasin, Kalimantan Selatan 70235"
                    , "-3.340261", "114.606168", "0812-5190-6600", "bpk"));
            sosDAO.insert(new SOS("BPK Ramin-Jl. Raya Banjar Indah Permai Jl. Ramin 1 No.14, Pemurus Dalam, Kec. Banjarmasin Sel., Kota Banjarmasin, Kalimantan Selatan 70248"
                    , "-3.351561", "114.617461", "(0511) 6774170", "bpk"));
            sosDAO.insert(new SOS("POS BPK Nurul Iman-Gg. Hikmah Jl. Belitung Darat, Belitung Sel., Banjarmasin Bar., Kota Banjarmasin, Kalimantan Selatan 70124"
                    , "-3.306658", "114.577992", "0823-5734-6223", "bpk"));
            sosDAO.insert(new SOS("Posko BPK Palm 21-Pasar Cemara Ujung, Jl. Cemara Ujung, Handil Bakti, Kec. Alalak, Kota Banjarmasin, Kalimantan Selatan 70123"
                    , "-3.288096", "114.598275", "0813-5196-6099", "bpk"));
            sosDAO.insert(new SOS("BPK MARGASARI-Komplek Margasari Permai, Jalan Ahmad Yani Km. 6900, Kertak Hanyar, Kertak Hanyar 1, Pemurus Luar, Kec. Banjarmasin Tim., Kota Banjarmasin, Kalimantan Selatan 70654"
                    , "-3.352211", "114.630217", "0812-5166-0100", "bpk"));
            sosDAO.insert(new SOS("Posko BPK BSC Cendrawasih-Kelurahan Selatan,, Jl. Cendrawasih, Belitung Sel., Banjarmasin Bar., Kota Banjarmasin, Kalimantan Selatan 70116"
                    , "-3.310650", "114.579436", "0813-4935-5354", "bpk"));
            sosDAO.insert(new SOS("Seketariat BPK Berjaya 45-Jl. Beruntung Jaya, RT.45, Pemurus Dalam, Kec. Banjarmasin Sel., Kota Banjarmasin, Kalimantan Selatan 70248"
                    , "-3.352021", "114.623190", "(0511) 3263962", "bpk"));
            sosDAO.insert(new SOS("Posko BPK Kumara-Jl. Kuin Utara, RT.10, Kuin Utara, Kec. Banjarmasin Utara, Kota Banjarmasin, Kalimantan Selatan 70124"
                    , "-3.293404", "114.570133", "(0511) 6334123", "bpk"));
            sosDAO.insert(new SOS("POSKO BPK RTD-Kelayan Sel., Kec. Banjarmasin Sel., Kota Banjarmasin, Kalimantan Selatan 70231"
                    , "-3.334426", "114.584420", "0852-4879-5267", "bpk"));
            sosDAO.insert(new SOS("Posko BPK SAGA-Jl. Salatiga, Tlk. Dalam, Kec. Banjarmasin Tengah, Kota Banjarmasin, Kalimantan Selatan 70123"
                    , "-3.313840", "114.584187", "0853-9167-6699", "bpk"));
            sosDAO.insert(new SOS("BPK SP 01 Baldez-Jl. Teluk Tiram Darat No.89 A, Tlk. Tiram, Banjarmasin Bar., Kota Banjarmasin, Kalimantan Selatan 70114"
                    , "-3.333986", "114.579631", "0878-1525-1330", "bpk"));
            sosDAO.insert(new SOS("BPK Garuda-Jl. Pulau Alalak, Pulau Sewangi, Kec. Alalak, Kabupaten Barito Kuala, Kalimantan Selatan 70582"
                    , "-3.266174", "114.568194", "0852-5140-4305", "bpk"));
            sosDAO.insert(new SOS("Pos BPK Putra AMD-Jl. HKSN Komp. Amd Permai, RT.23/RW.02, Alalak Utara, Kec. Banjarmasin Utara, Kota Banjarmasin, Kalimantan Selatan 70125"
                    , "-3.280225", "114.575767", "0888-0409-1566", "bpk"));
            sosDAO.insert(new SOS("Posko BPK MARKAS-Pengambangan, Kec. Banjarmasin Tim., Kota Banjarmasin, Kalimantan Selatan 70239"
                    , "-3.316614", "114.618853", "0838-4430-0658", "bpk"));
            sosDAO.insert(new SOS("BPK Bersi Banjarmasin-Jl. Let. Jend. S. Parman No.88, Ps. Lama, Kec. Banjarmasin Tengah, Kota Banjarmasin, Kalimantan Selatan 70115"
                    , "-3.307894", "114.589247", "(0511) 7103290", "bpk"));
            sosDAO.insert(new SOS("Posko Induk BPK NOORBIE-Komp. Subur Indah, Jl. Pramuka No.RT.26, Sungai Lulut, Kec. Banjarmasin Tim., Kota Banjarmasin, Kalimantan Selatan 70653"
                    , "-3.326950", "114.625992", "0812-5495-1299", "bpk"));
            sosDAO.insert(new SOS("UM Diesel BPK Al Amin-Jalan Kelayan Besar 1 No.3, RT.01, Tj. Pagar, Kec. Banjarmasin Sel., Kota Banjarmasin, Kalimantan Selatan 70247"
                    , "-3.345432", "114.595957", "(0511) 7440318", "bpk"));
            sosDAO.insert(new SOS("Hippindo-Jl. Pangeran Samudera, Kertak Baru Ilir, Kec. Banjarmasin Tengah, Kota Banjarmasin, Kalimantan Selatan 70231"
                    , "-3.325377", "114.592299", "(0511) 7500911", "bpk"));
            sosDAO.insert(new SOS("BPK Global-Jl. Yos Sudarso No.10, Telaga Biru, Banjarmasin Bar., Kota Banjarmasin, Kalimantan Selatan 70119"
                    , "-3.325799", "114.566381", "(0511) 7555091", "bpk"));
            sosDAO.insert(new SOS("Posko BPK MTB-Pemurus Dalam, Kec. Banjarmasin Sel., Kota Banjarmasin, Kalimantan Selatan 70235"
                    , "-3.345460", "114.605210", "0859-4400-2032", "bpk"));
            sosDAO.insert(new SOS("POSKO BPK Nyata Baru-Jln.A.Yani Gg. Karya Baru No.km 5,700, Pemurus Luar, Kec. Banjarmasin Tim., Kota Banjarmasin, Kalimantan Selatan 70238"
                    , "-3.344250", "114.624589", "0813-4935-7075", "bpk"));
            sosDAO.insert(new SOS("POSKO BPK NURUL IMAN BELDA-Gg. Hikmah Jl. Belitung Darat No.36, Belitung Sel., Banjarmasin Bar., Kota Banjarmasin, Kalimantan Selatan 70124"
                    , "-3.306629", "114.578067", "0813-5155-8720", "bpk"));
            sosDAO.insert(new SOS("POSKO Bpk Marma-Sungai Lulut, Kec. Banjarmasin Tim., Kota Banjarmasin, Kalimantan Selatan 70653"
                    , "-3.316322", "114.634703", "0853-4872-8302", "bpk"));
            sosDAO.insert(new SOS("POSKO BPK WARGA INDAH-Jl. Tembus Mantuil Rt 23 Basirih, Kelayan Sel., Kec. Banjarmasin Sel., Kota Banjarmasin, Sulawesi Selatan 70112"
                    , "-3.348743", "114.565914", "0877-2038-6637", "bpk"));
            sosDAO.insert(new SOS("POSKO BPK SWADAYA-Pelambuan, Banjarmasin Bar., Kota Banjarmasin, Kalimantan Selatan 70116"
                    , "-3.318149", "114.568927", "0812-5109-7369", "bpk"));
            sosDAO.insert(new SOS("POSKO Induk BPK Putra WBC-Jalan Wira Bakti, Handil Bakti, Kec. Alalak, Kabupaten Barito Kuala, Kalimantan Selatan 70582"
                    , "-3.275551", "114.609462", "0812-9580-6788", "bpk"));
            sosDAO.insert(new SOS("BPK FASIH-Jln. Flamboyan III RT.06 UKA UJUNG KEL, Basirih, Banjarmasin Bar., Kota Banjarmasin, Kalimantan Selatan 70117"
                    , "-3.334458", "114.563892", "0852-5161-0880", "bpk"));
            sosDAO.insert(new SOS("PMK Pp 4,5 HBI Fire-Jl. Komp. Amanda, Karang Mekar, Kec. Banjarmasin Tim., Kota Banjarmasin, Kalimantan Selatan 70237"
                    , "-3.335621", "114.615822", "0812-5564-6888", "bpk"));
            sosDAO.insert(new SOS("POSKO BPK Andika-Jl. A. Yani No.9, Tatah Belayung Baru, Kertak Hanyar, Banjar, Kalimantan Selatan 70654"
                    , "-3.368586", "114.641031", "0813-4705-4761", "bpk"));

            sosDAO.insert(new SOS("RSUD Dr. H. Moch. Ansari Saleh-Jl. Brig. Jend. H. Hasan Basri No. 1, Alalak Utara, Kec. Banjarmasin Utara, Kota Banjarmasin, Kalimantan Selatan 70125"
                    , "-3.344250", "114.624589", "0511-6710000", "rs"));
            sosDAO.insert(new SOS("Rumah Sakit Islam Banjarmasin-Jalan Letjen S. Parman, Gang Purnama No.88, Pasar Lama, Banjarmasin Tengah, Ps. Lama, Kec. Banjarmasin Tengah, Kota Banjarmasin, Kalimantan Selatan 70115"
                    , "-3.344250", "114.624589", "0511-3354896", "rs"));
            sosDAO.insert(new SOS("Rumah Sakit Umum Suaka Insan-Jalan H Zafri Zam Zam No.60, Belitung Selatan, Banjarmasin Barat, Belitung Sel., Banjarmasin Bar., Kota Banjarmasin, Kalimantan Selatan 70124"
                    , "-3.344250", "114.624589", "(0511) 3353335", "rs"));
            sosDAO.insert(new SOS("Rumah Sakit Umum Daerah Ulin-Jalan A. Yani No. 43, Sungai Baru, Banjarmasin Tengah, Sungai Baru, Kec. Banjarmasin Tengah, Kota Banjarmasin, Kalimantan Selatan 70233"
                    , "-3.344250", "114.624589", "(0511) 3252229", "rs"));
            sosDAO.insert(new SOS("Rumah Sakit Sari Mulia Banjarmasin-Jl. Pangeran Antasari No.139, Sungai Baru, Kec. Banjarmasin Tengah, Kota Banjarmasin, Kalimantan Selatan 70233"
                    , "-3.344250", "114.624589", "(0511) 3252570", "rs"));
            sosDAO.insert(new SOS("Rumah Sakit Khusus Bedah Banjarmasin Siaga-Jalan Jenderal Ahmad Yani KM.4,5 No.73, Kebun Bunga, Kec. Banjarmasin Tim., Kota Banjarmasin, Kalimantan Selatan 70235"
                    , "-3.344250", "114.624589", "(0511) 3267532", "rs"));
            sosDAO.insert(new SOS("Rumah Sakit TPT Dr. R. Soeharsono-Jl. Mayjen Sutoyo S, Pelambuan, Banjarmasin Bar., Kota Banjarmasin, Kalimantan Selatan 70129"
                    , "-3.344250", "114.624589", "(0511) 4368422", "rs"));


            return null;
        }
    }

}

