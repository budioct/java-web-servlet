package com.tutorial;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan // akan membaca annotation Web Servlet
@SpringBootApplication
public class EmbededServletApp {

    /**
     * class ini yang akan menangani tomcat supaya bisa di running di project kita atau di embbed
     * tidak perlu build ulang dan menaruh file.war hasil build ke path: apache-tomcat-10.1.8\webapps. untuk melihat hasil web servlet
     * untuk menjalankan file.war di tomcat, karena itu akan melelahkan sekalai!!
     *
     * jika class ini di running, akan keluar log port 8080 jika berhasil
     * 2023-05-04T13:53:46.468+07:00  INFO 3196 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
     * with context path '' // default kosong
     * jadi kita tidak perlu menyebutkan nama folder seperti path di apache-tomcat-10.1.8\webapps. jika kita ketahui untuk mengaksesnya
     * // http://localhost:8080/belajar/hello // kita harus menyebutkan folder setelah port nya
     * // http://localhost:8080/belajar/world
     *
     * jika sudah di embeded tidak perlu menambhkan foldernya, tinggal urlPattenr saja maka dia akan mengembalikan response dari method
     *
     * // kesimpulan nya: kita tidak perlu build package WAR, tidak perlu mendeploy file hasil package ke path apache-tomcat-10.1.8\webapps
     */

    public static void main(String[] args) {
        SpringApplication.run(EmbededServletApp.class); // ConfigurableApplicationContext run(Class<?> primarySource, String... args) // java reflection
    }

}
