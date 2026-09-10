package com.libis.controller;

import com.libis.data.DataStore;
import com.libis.model.Member;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1. Read submitted values
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // 2. Validate against the List<Member>
        Member authenticatedMember = null;
        for (Member m : DataStore.MEMBERS) {
            if (m.getEmail().equalsIgnoreCase(email) && m.getPassword().equals(password)) {
                authenticatedMember = m;
                break;
            }
        }

        // 3. Branch on the result
        if (authenticatedMember != null) {
            // Success: Create session, store member identity
            HttpSession session = request.getSession();
            session.setAttribute("loggedInMember", authenticatedMember);

            // Set books as a request attribute for the JSP to read
            request.setAttribute("bookList", DataStore.BOOKS);

            // Forward to welcome page
            request.getRequestDispatcher("welcome.jsp").forward(request, response);
        } else {
            // Failure: Set error message and return to login page
            request.setAttribute("error", "Invalid email or password. Please try again.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}