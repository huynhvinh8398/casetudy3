package com.cg.service;

import com.cg.model.Account;
import com.cg.untils.MySQLConnUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginService {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    public Account checkLogin(String user, String pass){
        try {
            String query = "SELECT * FROM case_study3.users WHERE user_name = ? and password = ? ;";
            conn = new MySQLConnUtils().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()){
                Account a = new Account(rs.getString(1), rs.getString(2));
                return a;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
