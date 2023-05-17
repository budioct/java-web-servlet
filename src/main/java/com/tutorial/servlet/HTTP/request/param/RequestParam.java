package com.tutorial.servlet.HTTP.request.param;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.function.ToIntFunction;
import java.util.stream.Stream;

@WebServlet(urlPatterns = "/query")
public class RequestParam extends HttpServlet {

    /**
     * Request Param
     * ● Saat membuat Web, kadang kita mengirim data melalui Query Parameter
     * ● Untuk mengambil data Query Parameter yang dikirim oleh user, kita bisa menggunakan HttpServletRequest
     *
     * ● String getParameter(String var1) untuk mengambil parameter berdasarkan nama
     * ● Enumeration<String> getParameterNames() untuk mengambil semua nama parameter yang ada
     * ● Map<String, String[]> getParameterMap() untuk mengambil semua nama parameter beserta value nya
     * ● String[] getParameterValues(String var1) untuk mengambil parameter yang value nya lebih dari satu
     *
     */

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String[] numbers = req.getParameterValues("number"); // String[] getParameterValues(String var1) // menerima parameter request dari url user dengan bentuk array[]

        // static<T> Stream<T> of(T... values) // convert to Stream
        // IntStream mapToInt(ToIntFunction<? super T> mapper) // convert dari String to Integer
        // int parseInt(String s) // paksa data String to Integer
        // int sum() // jumlah data setiap stream
        int sum = Stream.of(numbers).mapToInt(new ToIntFunction<String>() {
            @Override
            public int applyAsInt(String value) {
                return Integer.parseInt(value);
            }
        }).sum();

        resp.getWriter().println("Total Numbers is: " + sum); // PrintWriter getWriter() // mengembalikan teks ke client

        /**
         * result
         * url : http://localhost:8080/query?number=1&number=14&number=20&number=15
         * body: Total Numbers is: 50
         *
         */

    }
}
