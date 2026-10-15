package com.libis.controller;

import com.libis.data.DataStore;
import com.libis.model.Book;
import com.libis.model.Member;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/catalogue")
public class CatalogueController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Member member = (Member) request.getSession().getAttribute(LoginController.SESSION_MEMBER);

        String term = request.getParameter("q");
        term = (term == null) ? "" : term.trim();

        List<Book> results;
        if (term.isEmpty()) {
            results = DataStore.BOOKS;
        } else {
            String needle = term.toLowerCase();
            results = new ArrayList<>();
            for (Book book : DataStore.BOOKS) {
                if (book.getTitle().toLowerCase().contains(needle)) {
                    results.add(book);
                }
            }
        }

        request.setAttribute("member", member);
        request.setAttribute("bookList", results);
        request.setAttribute("searchTerm", term);

        request.getRequestDispatcher("/WEB-INF/views/welcome.jsp").forward(request, response);
    }
}