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

@WebServlet("/login")
public class LoginController extends HttpServlet {

    public static final String SESSION_MEMBER = "loggedInMember";
    private static final String LOGIN_VIEW = "/WEB-INF/views/login.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute(SESSION_MEMBER) != null) {
            response.sendRedirect(request.getContextPath() + "/catalogue");
            return;
        }
        request.getRequestDispatcher(LOGIN_VIEW).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Member authenticated = findMember(email, password);

        if (authenticated != null) {
            HttpSession session = request.getSession();
            request.changeSessionId();
            session.setAttribute(SESSION_MEMBER, authenticated);
            response.sendRedirect(request.getContextPath() + "/catalogue");
        } else {
            request.setAttribute("error", "Invalid email or password. Please try again.");
            request.getRequestDispatcher(LOGIN_VIEW).forward(request, response);
        }
    }

    private Member findMember(String email, String password) {
        if (email == null || password == null) {
            return null;
        }
        for (Member m : DataStore.MEMBERS) {
            if (m.getEmail().equalsIgnoreCase(email.trim()) && m.getPassword().equals(password)) {
                return m;
            }
        }
        return null;
    }
}