package com.tutorial.servlet.dwonloadfile;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@WebServlet(urlPatterns = "/dwonload")
public class DwonloadServlet extends HttpServlet {

    /**
     * Download File
     * ● Sebelumnya kita selalu menggunakan Writer pada ServletResponse
     * ● Writer digunakan untuk mengirim response body dalam bentuk Text, bagaimana jika datanya dalam bentuk binary? Seperti gambar, video dan lain-lain
     * ● Kita bisa menggunakan method getOutputStream() untuk melakukan itu
     */

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String file = req.getParameter("file"); // String getParameter(String var1) // get type text data    request client url
        Path path = Path.of("upload/" + file); // mengambil name file yang cocok dengan parameter url
        byte[] bytes = Files.readAllBytes(path); // file akan di baca array bytes

        // jika true akan di dwonload langsung, jika false maka akan preview image
        String force = req.getParameter("force"); // jika tru maka akan di dwonload,
        if ("true".equals(force)){
            resp.setHeader("Content-Disposition", "attachment; filename=\"" + path.getFileName() + "\"");
        }

        // int getBufferSize() // mengirim response body file, gambar, musik, vidio
        // void write(byte b[]) //
        resp.getOutputStream().write(bytes);

    }

    /**
     * result:
     * http://localhost:8080/dwonload?file=318cf713-ce96-47ad-aec4-8df403c66353infografik-mozaik-agresi-militer-belanda-i--sabit_ratio-9x16.jpg
     * preview image
     *
     * http://localhost:8080/dwonload?file=318cf713-ce96-47ad-aec4-8df403c66353infografik-mozaik-agresi-militer-belanda-i--sabit_ratio-9x16.jpg&force=true
     * bisa langsung dwonload tanpa preview
     */

}
