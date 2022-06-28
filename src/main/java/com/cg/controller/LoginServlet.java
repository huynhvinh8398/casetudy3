package com.cg.controller;

import com.cg.model.Account;
import com.cg.service.LoginService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html/charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/cp/login.jsp");
        dispatcher.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset =UTF-8");
        try {
            String user = req.getParameter("Username");
            String pass = req.getParameter("password");
            String message;

            LoginService loginService = new LoginService();
            Account a = loginService.checkLogin(user, pass);

            boolean success = false;;
            req.setAttribute("success", true);
            boolean error = true;;
            if (a == null) {
                resp.sendRedirect("login");
            }
            else {
                resp.sendRedirect("users");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

