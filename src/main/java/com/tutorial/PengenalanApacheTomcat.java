package com.tutorial;

public class PengenalanApacheTomcat {

    /**
    * Pengenalan Apache Tomcat
     * ● Apache Tomcat adalah salah satu Web Server yang sangat populer digunakan untuk menjalankan Java Web
     * ● Di kelas ini, kita akan menggunakan Apache Tomcat sebagai Web Server untuk menjalankan aplikasi Java Web yang kita buat menggunakan Servlet
     * ● https://tomcat.apache.org/ --> saat ini menggunakan versi 10 saat ini yang stabil
     * di sarankan dwonload yang .zip
     *
     * Kenapa Apache Tomcat?
     * ● Apache Tomcat adalah aplikasi Open Source dan Multi Platform, sehingga kita bisa jalankan secara gratis dan juga di sistem operasi apapun
     * ● Selain itu, Apache Tomcat sangat ringan, sehingga tidak butuh resource Hardware yang besar untuk menjalankannya
     *
     * Menginstall Apache Tomcat
     * ● Download Apache Tomcat
     * ● https://tomcat.apache.org/  --> saat ini menggunakan versi 10 saat ini yang stabil
     * di sarankan dwonload yang .zip
     *
     * Menjalankan dan Menghentikan Apache Tomcat
     * ● Untuk menjalankan Apache Tomcat, kita bisa jalankan file catalina di folder bin dengan parameter :
     * ● run untuk menjalankan di terminal saat ini
     * ● start untuk menjalankan di background
     * ● stop untuk menghentikan aplikasi
     * ● Setelah jalan, kita bisa lihat Apache Tomcat di : http://localhost:8080
     *
     * command:
     * $ bin/catalina.sh run   -> menjalankan tomcat
     * $ bin/catalina.sh start -> menjalankan tomcat di latar belakang
     * $ bin/catalina.sh stop  -> hentikan tomcat
     * $ bin/shutdown.sh       -> hentikan tomcat
     *
     * Pengenalan War File
     * ● Saat kita membuat aplikasi Java, kebanyakan kita akan membuat distribution file dalam bentuk jar(Java Archive) file
     * ● Namun khusus aplikasi Java Web, kita akan membuat distribution file dalam bentuk war (Web Archive) file
     *
     * Perbedaan War dan Jar File
     * ● Isi War dan Jar file sebenarnya sama, berisikan class-class Java yang sudah di compile menjadi binary code
     * ● Salah satu yang membedakan adalah, di War file biasanya tidak terdapat main class, karena memang War file itu akan dijalankan di dalam Web Server
     *
     */

}
