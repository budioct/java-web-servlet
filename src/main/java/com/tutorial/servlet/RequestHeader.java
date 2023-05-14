package com.tutorial.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

@WebServlet(urlPatterns = "/header")
public class RequestHeader extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Enumeration<String> names = req.getHeaderNames(); // Enumeration<String> getHeaderNames() // get key header dan value http response

        String name;

        // E nextElement() // get key header
        // String getHeader(String var1) // get value header
        while ((name = names.nextElement()) != null) {
            resp.getWriter().println("Header: " + name + ", value: " + req.getHeader(name)); // PrintWriter getWriter() // mengembalikan teks ke client
        }

        /**
         * result:
         * Header: x-api, value: rahasia // hasil di tambahkan sendiri
         * Header: xxx, value: apa coba  // hasil di tambahkan sendiri
         * Header: host, value: localhost:8080
         * Header: connection, value: keep-alive
         * Header: sec-ch-ua, value: "Chromium";v="112", "Google Chrome";v="112", "Not:A-Brand";v="99"
         * Header: sec-ch-ua-mobile, value: ?0
         * Header: sec-ch-ua-platform, value: "Windows"
         * Header: upgrade-insecure-requests, value: 1
         * Header: user-agent, value: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/112.0.0.0 Safari/537.36
         */
         // Header: accept, value: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7
         // Header: sec-fetch-site, value: none
         // Header: sec-fetch-mode, value: navigate
         // Header: sec-fetch-user, value: ?1
         // Header: sec-fetch-dest, value: document
         // Header: accept-encoding, value: gzip, deflate, br
         // Header: accept-language, value: id-ID,id;q=0.9,en-US;q=0.8,en;q=0.7


    }
}
