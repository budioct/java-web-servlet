package com.tutorial.servlet.cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CookieValue;

import java.io.IOException;

@Slf4j
@WebServlet(urlPatterns = "/cookie")
public class CookieServlet extends HttpServlet {

    /**
     * Cookie
     * ● Cookie adalah informasi yang dibuat di Server dan disimpan di Client (Browser)
     * ● Cookie akan selalu dikirim ulang oleh Browser setiap melakukan request selanjutnya
     * ● Detail Cookie sudah dibahas di kelas HTTP
     * ● HttpServletResponse.addCookie(cookie) // Untuk membuat Cookie, kita bisa menggunakan
     * ● HttpServletRequest.getCookies() // untuk membaca Cookie yang dikirim oleh Browser, kita bisa menggunakan
     * ● https://tomcat.apache.org/tomcat-10.0-doc/servletapi/jakarta/servlet/http/Cookie.html
     *
     * note: cookie itu bentuknya serpti Map<K,V> ada key dan value
     *
     * Bagaimana Menghapus Cookie?
     * ● Tidak ada cara untuk menghapus Cookie
     * ● Namun kita bisa memaksa agar Cookie secara otomatis expire, dengan cara mengubah waktu
     *   expire menjadi negative menggunakan Cookie.setMaxAge(-1)
     */

    // add cookie request
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String cookieName = req.getParameter("name"); // String getParameter(String var1) // retrieve data request client url
        String cookieValau = req.getParameter("value");

        Cookie cookie = new Cookie(cookieName, cookieValau);
        cookie.setPath("/"); // void setPath(String uri) // Menentukan jalur untuk cookie tempat klien harus mengembalikan cookie.

        //cookie.setMaxAge(-1); // void setMaxAge(int expiry) // memaksa agar Cookie secara otomatis expire

        log.info("Age cookie: {}", cookie.getMaxAge());

        resp.addCookie(cookie); // void addCookie(Cookie var1) // Untuk membuat Cookie
        resp.getWriter().println("Success add cookie " + cookieName + ":" + cookieValau);

    }

    // get cookie Response
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Cookie[] getCookies() // membaca Cookie yang dikirim oleh Browser
        if (req.getCookies() != null){
            for (Cookie cookie : req.getCookies()){

                resp.getWriter().println("Cookie " + cookie.getName() + ":" + cookie.getValue());
            }
        }
    }

    /**
     * Result:
     * url: localhost:8080/cookie?name=marwan&value=Type-X
     * Success add cookie indah:Type-B
     *
     * dikolom Cookie ada
     * Name     Value
     * marwan   Type-X
     *
     * url: localhost:8080/cookie
     * akan return cookie yang sudah di request, sebagai response nya
     *
     *
     */

}
