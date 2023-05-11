package com.example.raihanuts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(){

    companion object{
        val EXTRA_CLUB = "EXTRA_CLUB"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val clubList = listOf<Club>(
            Club(
                R.drawable.arema,
                nameclub = "Arema FC",
                jlkclub = "Singo Edan",
                yearclub = "11 Agustus 1987",
                homeclub = "Stadion Kanjuruhan Malang Jawa Timur",
                supclub = "Kapasitas 42.500 Penonton",
                deskripclub = "Arema Football Club adalah sebuah klub sepak bola profesional yang berasal dari Malang, Jawa Timur, Indonesia. Arema berkompetisi di Liga 1 yang merupakan kasta tertinggi sepak bola Indonesia. Arema juga dikenal dengan sebutan Singo Edan"),
            Club(
                R.drawable.bali,
                nameclub = "Bali United FC",
                jlkclub = "Serdadu Tridatu",
                yearclub = "15 Februari 2015",
                homeclub = "Stadion Kapten I Wayan Dipta Gianyar Bali",
                supclub = "Kapasitas 25.000 Penonton",
                deskripclub = "Bali United FC sebelumnya bernama Persisam Putra Samarinda adalah klub sepak bola profesional Indonesia yang berbasis di Kabupaten Gianyar, Bali. Klub ini sebelumnya bernama Persatuan Sepak Bola Indonesia Samarinda (Persisam) yang merupakan eks tim Perserikatan dan Putra Samarinda dari Galatama."),
            Club(
                R.drawable.bhayangkara,
                nameclub = "Bhayangkara FC",
                jlkclub = "The Guardian",
                yearclub = "08 September 2016",
                homeclub = "Stadion Wibawa Mukti Bekasi Jawa Barat",
                supclub = "Kapasitas 30.000 Penonton",
                deskripclub = "Bhayangkara Football Club adalah sebuah tim sepak bola Indonesia yang dimiliki oleh Polri. Klub ini bermain di Liga 1. Klub ini juga memegang rekor sebagai klub dengan pergantian nama terbanyak di Indonesia, semuanya karena dualisme yang pernah terjadi antara klub ini dengan klub Persebaya Surabaya pada rentang waktu 2010 sampai 2016."),
            Club(
                R.drawable.borneo,
                nameclub = "Borneo FC",
                jlkclub = "Pesut Etam",
                yearclub = "07 Maret 2014",
                homeclub = "Stadion Segiri Samarinda Kalimantan Timur",
                supclub = "Kapasitas 16.000 Penonton",
                deskripclub = "Borneo FC Samarinda sering juga disebut Borneo FC adalah klub sepak bola Indonesia yang berbasis di Kota Samarinda, Kalimantan Timur. Pada awal berdirinya klub ini bermain di Divisi Utama Liga Indonesia 2014 setelah mengakuisisi klub Perseba Super Bangkalan pada 19 Maret 2014."),
            Club(
                R.drawable.dewa,
                nameclub = "Dewa United FC",
                jlkclub = "Tangsel Warrior",
                yearclub = "30 Mei 2022",
                homeclub = "Stadion Indomilk Arena Tanggerang banten",
                supclub = "Kapasitas 15.000 Penonton",
                deskripclub = "Dewa United Football Club atau disingkat sebagai Dewa United FC adalah klub sepak bola Indonesia yang berdiri pada 22 Februari 2021 dan bermarkas di Indomilk Arena, Kabupaten Tangerang, Banten. Dewa United FC memiliki julukan yaitu Tangsel Warrior."),
            Club(
                R.drawable.madura,
                nameclub = "Madura United",
                jlkclub = "Laskar Sape Kerrab",
                yearclub = "10 Januari 2016",
                homeclub = "Stadion Ratu Pamelingan Pamekasan Jawa Timur",
                supclub = "Kapasitas 15.000 Penonton",
                deskripclub = "Madura United FC adalah klub sepak bola profesional asal Indonesia yang berbasis di Pulau Madura, tepatnya di Kabupaten Pamekasan, Jawa Timur. Klub ini resmi didirikan pada 10 Januari 2016 melalui proses akuisisi. Madura United FC sebelumnya bernama Pelita Jaya dan Pelita Bandung Raya."),
            Club(
                R.drawable.persebaya,
                nameclub = "Persebaya FC",
                jlkclub = "Bajul Ijo",
                yearclub = "18 Juni 1927",
                homeclub = "Stadion GBT Surabaya Jawa Timur ",
                supclub = "Kapasitas 55.000 Penonton",
                deskripclub = "Persatuan Sepak Bola Surabaya atau biasa disebut Persebaya Surabaya, disingkat Persebaya adalah sebuah klub sepak bola profesional Indonesia yang berbasis di kota Surabaya, Jawa Timur. Saat ini Persebaya berkompetisi Liga 1 Indonesia. Persebaya berdiri pada 18 Juni 1927 sebagai Soerabajasche Indonesische Voetbal Bond (SIVB)."),
            Club(
                R.drawable.persib,
                nameclub = "Persib Bandung",
                jlkclub = "Maung Bandung",
                yearclub = "14 Maret 1933",
                homeclub = "Stadion GBLA Bandung Jawa Barat",
                supclub = "Kapasitas 27.000 Penonton",
                deskripclub = "Persib atau singkatan dari Persatuan Sepak Bola Indonesia Bandung adalah klub sepak bola Indonesia yang berbasis di Kota Bandung, Jawa Barat. Klub ini mulai berdiri pada 14 Maret 1933. Persib saat ini bermain di Liga 1 Indonesia. Julukan mereka adalah Maung Bandung dan Pangeran Biru."),
            Club(
                R.drawable.persija,
                nameclub = "Persija Jakarta",
                jlkclub = "Macan Kemayoran",
                yearclub = "28 November 1928",
                homeclub = "Stadion GBK Jakarta DKI Jakarta",
                supclub = "Kapasitas 77.000 Penonton",
                deskripclub = "Persija singkatan dari Persatuan Sepak Bola Indonesia Jakarta, dahulu pernah dikenal juga dengan nama Persija Pusat adalah klub sepak bola Indonesia yang berbasis di Jakarta, Indonesia. Persija saat ini berlaga di Liga 1. Persija didirikan pada 28 November 1928, tepat sebulan setelah Sumpah Pemuda."),
            Club(
                R.drawable.persik,
                nameclub = "Persik Kediri",
                jlkclub = "Laskar Jayabaya",
                yearclub = "19 Mei 1950",
                homeclub = "Stadion Brawijaya Kediri Jawa timur",
                supclub = "Kapasitas 20.000 Penonton",
                deskripclub = "Persatuan Sepak Bola Indonesia Kediri disingkat Persik Kediri merupakan klub sepak bola profesional Indonesia yang berbasis di Kota Kediri, Jawa Timur. Klub didirikan tahun 1950 dan bermarkas di Stadion Brawijaya, Kota Kediri. Klub saat ini berkompetisi di Liga 1 yang merupakan kasta tertinggi sepak bola di liga Indonesia."),
            Club(
                R.drawable.persikabo,
                nameclub = "Persikabo 1973",
                jlkclub = "Laskar Padjajaran",
                yearclub = "23 Desember 1973",
                homeclub = "Stadion Pakansari Bogor Jawa Barat",
                supclub = "Kapasitas 30.000 Penonton",
                deskripclub = "Persikabo 1973 singkatan dari Persatuan Sepakbola Indonesia Kabupaten Bogor 1973 adalah klub sepak bola Indonesia yang bermarkas di Stadion Pakansari, Kabupaten Bogor, Provinsi Jawa Barat, Indonesia dan berkompetisi di Liga 1."),
            Club(
                R.drawable.persis,
                nameclub = "Persis Solo",
                jlkclub = "Laskar Sambernyawa",
                yearclub = "08 November 1923",
                homeclub = "Stadion Manahan Solo Jawa Tengah",
                supclub = "Kapasitas 20.000 Penonton",
                deskripclub = "Persatuan Sepak Bola Indonesia Surakarta disingkat PERSIS, umumnya di kenal sebagai Persis Solo adalah sebuah klub sepak bola profesional Indonesia yang berbasis di Kota Surakarta, Jawa Tengah. Klub ini awalnya menggunakan nama Vorstenlandsche Voetbal Bond (VVB), yang didirikan oleh Sastrosaksono, Raden Ngabehi Reksodiprojo dan Sutarman pada 8 November 1923."),
            Club(
                R.drawable.persita,
                nameclub = "Persita Tanggerang",
                jlkclub = "Pendekar Cisadane",
                yearclub = "09 September  1953",
                homeclub = "Stadion Indomilk Arena Tanggerang banten",
                supclub = "Kapasitas 15.000 Penonton",
                deskripclub = "Persatuan Sepak bola Indonesia Tangerang disingkat Persita atau Persita Tangerang adalah sebuah klub sepak bola Indonesia yang bermarkas di Kabupaten Tangerang. Tim berjuluk Pendekar Cisadane yang identik dengan jersey berwarna violet. Persita Tangerang saat ini bermain di liga tertinggi Indonesia, Liga 1."),
            Club(
                R.drawable.barito,
                nameclub = "PS Barito Putera",
                jlkclub = "Laskar Antasari",
                yearclub = "21 April 1988",
                homeclub = "Stadion 17 Mei Banjarmasin Kalimantan Selatan",
                supclub = "Kapasitas 15.000 Penonton",
                deskripclub = "PS Barito Putera singkatan dari Persatuan Sepak Bola Barito Putera adalah klub sepak bola profesional Indonesia yang berbasis di Kota Banjarmasin, Kalimantan Selatan, yang bermain di Liga 1 sejak musim 2017. Barito Putera didirikan pada tahun 1988 dan bermarkas di Stadion 17 Mei Banjarmasin."),
            Club(
                R.drawable.psis,
                nameclub = "PSIS Semarang",
                jlkclub = "Laskar Mahesa Jenar",
                yearclub = "18 mei 1932",
                homeclub = "Stadion Jatidiri Semarang Jawa Tengah",
                supclub = "Kapasitas 25.000 Penonton",
                deskripclub = "Persatuan Sepak Bola Indonesia Semarang atau biasa disingkat PSIS Semarang adalah klub sepak bola profesional yang berbasis di Kota Semarang, Jawa Tengah, Indonesia dengan bermarkas di Stadion Jatidiri, Semarang. Julukan klub ini adalah Laskar Mahesa Jenar. "),
            Club(
                R.drawable.psm,
                nameclub = "PSM Makassar",
                jlkclub = "Juku Eja",
                yearclub = "02 November 1915",
                homeclub = "Stadion BJ Habibie Makassar Sulawesi Selatan",
                supclub = "Kapasitas 20.000 Penonton",
                deskripclub = "Persaudaraan Sepak bola Makassar disingkat PSM Makassar adalah sebuah tim sepak bola profesional Indonesia yang berbasis di Kota Makassar, Sulawesi Selatan. PSM Makassar didirikan pada 1915 sebagai Macassarche Voetbalbond (MVB) membuat PSM menjadi klub sepak bola tertua di Indonesia. Saat ini klub tersebut bermain di BRI Liga 1. "),
            Club(
                R.drawable.pss,
                nameclub = "PSS Sleman",
                jlkclub = "Super Elang Jawa",
                yearclub = "20 Mei 1976",
                homeclub = "Stadion Maguwoharjo Sleman DI Yogyakarta",
                supclub = "Kapasitas 32.000 Penonton",
                deskripclub = "Perserikatan Sepakbola Sleman (PSS) merupakan klub sepak bola professional yang bermain di liga indonesia dan berbasis di Kabupaten Sleman, Daerah Istimewa Yogyakarta, Indonesia. PSS didirikan pada tanggal 20 Mei 1976. PSS memliliki julukan Super Elang Jawa (disingkat Super Elja)."),
            Club(
                R.drawable.rans,
                nameclub = "Rans Nusantara FC",
                jlkclub = "The Prestige Phoenix",
                yearclub = "30 Mei 2022",
                homeclub = "Stadion Pakansari Bogor Jawa Barat",
                supclub = "Kapasitas 42.500 Penonton",
                deskripclub = "RANS Nusantara FC atau dikenal sebagai RANS FC, sebelumnya pernah dikenal sebagai Cilegon United dan RANS Cilegon FC adalah sebuah klub sepak bola Indonesia yang berbasis di Jakarta, Indonesia. Saat ini klub tersebut berkandang di Stadion Pakansari, Cibinong, Bogor. Julukan RANS Nusantara FC adalah Magenta Force dan The Prestige Phoenix.")
        )
        val recyclerView = findViewById<RecyclerView>(R.id.rv_club)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = ClubAdapter(this,clubList){

            val intent = Intent (this@MainActivity, DetailClubActivity::class.java)
            intent.putExtra(EXTRA_CLUB, it)
            startActivity(intent)
        }
    }
}