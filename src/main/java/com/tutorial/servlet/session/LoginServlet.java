package com.tutorial.servlet.session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(urlPatterns = "/session/login")
public class LoginServlet extends HttpServlet {

    /**
     * Session
     * ● Session adalah informasi yang disimpan di Server untuk digunakan kembali oleh Client
     * ● Contoh misal ketika user melakukan login ke Web, kita menyimpan informasi user yang sudah login tersebut, agar request yang dilakukan selanjutnya bisa didapat lagi
     * ● Data Session disimpan di memory Java Web, oleh karena itu kadang ketika kita membuat Java Web yang berjalan di beberapa Server, hal ini agak menyulitkan untuk melakukan management Session nya
     * ● Oleh karena itu, sebenarnya membuat Session sangat direkomendasikan menggunakan Cookie atau disimpan di Database, jangan di Memory aplikasi Java Web
     *
     * note: untuk management session sebaiknya secure session atau session disimpan di database
     *
     * HttpSession
     * ● Representasi dari Session di Servlet adalah class HttpSession
     * ● https://tomcat.apache.org/tomcat-10.0-doc/servletapi/jakarta/servlet/http/HttpSession.html
     * ● Untuk membuat Session, kita bisa menggunakan HttpServletRequest.getSession(isAutoCreate), jika parameter isAutoCreate true, maka session akan dibuat otomatis jika belum
     * HttpServletRequest.getSession(isAutoCreate) -> untuk membuat session otomatis
     *
     * HttpSession Method
     * ● HttpSession bisa digunakan untuk menyimpan banyak informasi, mirip seperti Map, dimana kita
     *   bisa menyimpan key-value menggunakan method HttpSession.setAttribute(key, value)
     * ●  mengambil data, kita bisa gunakan HttpSession.getAttribute(name)
     * ●  menghapus data, kita bisa gunakan HttpSession.removeAttribute(name)
     * ●  menghapus semua data, kita bisa gunakan HttpSession.invalidate()
     *
     */

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username"); // String getParameter(String var1) // retrieve data request client url

        HttpSession session = req.getSession(true); // HttpSession getSession(boolean var1) //  untuk membuat session otomatis
        session.setAttribute("username", username); // void setAttribute(String var1, Object var2) // menyimpan key-value session

        resp.getWriter().println("Login Success: " + username); // tampilkan response ke client

        /**
         * Result:
         * url: localhost:8080/session/login?username=sasuke
         * Login Success: sasuke
         *
         *
         */

    }
}
