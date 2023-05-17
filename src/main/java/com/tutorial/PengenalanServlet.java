package com.tutorial;

public class PengenalanServlet {

    /**
     * Servlet
     * ● Interface Servlet adalah interface utama dari Servlet API
     * ● Servlet merupakan tempat dimana logika kode program kita tempatkan
     * ● HTTP Request yang masuk ke Java Web akan diterima oleh Servlet, dan HTTP Response nya akan dibuat di Servlet
     * ● https://tomcat.apache.org/tomcat-10.0-doc/servletapi/jakarta/servlet/Servlet.html
     *
     * HttpServlet
     * ● Servlet adalah sebuah Interface, kita bisa membuat class turunan dari Servlet, namun biasanya
     * kebanyakan programmer akan menggunakan class-class turunan Servlet, agar tidak perlu
     * mengimplementasikan semua method di interface Servlet
     * ● Salah satu class turunan Servlet yang biasa digunakan adalah HttpServlet
     * ● https://tomcat.apache.org/tomcat-10.0-doc/servletapi/jakarta/servlet/http/HttpServlet.html
     *
     * WebServlet Annotation
     * ● Saat kita membuat class Servlet, kita perlu meregistrasikan class tersebut ke Java Web agar bisa
     * diakses, caranya kita bisa tambahkan annotation WebServlet pada class Servlet nya
     * ● Kita bisa menentukan URL apa yang akan digunakan pada annotation WebServlet tersebut
     * ● https://tomcat.apache.org/tomcat-10.0-doc/servletapi/jakarta/servlet/annotation/WebServlet.html
     *
     */

}
