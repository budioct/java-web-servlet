package com.tutorial;

public class MembuatWarFile {

    /**
     * Membuat War File
     * ● Seperti yang pernah kita bahas di kelas Apache Maven
     * ● Untuk membuat distribution file, kita bisa gunakan perintah : mvn package
     * ● Sama juga untuk membuat War File, kita bisa gunakan perintah yang sama
     * ● Hasil War File dari project yang kita buat akan tersedia di folder target
     *
     * Deploy ke Apache Tomcat
     * ● Setelah membuat War File, untuk deploy aplikasi Java Web yang sudah kita buat, kita bisa pindahkan War File nya ke folder webapps di Apache Tomcat
     * ● Secara otomatis Tomcat akan mendeteksi War File baru dan mengextract menjadi sebuah folder
     * ● Kita bisa mengakses Web yang sudah kita deploy lewat url : http://localhost:8080/nama-folder
     * // belajar adalah folder.war/ context path dalan endpoint
     * http://localhost:8080/belajar
     * http://localhost:8080/belajar/hello
     * http://localhost:8080/belajar/world
     *
     * Undeploy dari Apache Tomcat
     * ● Jika kita mau menghapus Java Web yang sudah kita deploy dari Apache Tomcat, kita bisa dengan mudah menghapus folder yang terdapat di webapps dan juga War File nya
     */

}
