package com.yb;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet("/hehe")
public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://zhouxin.chhkfjisj1vc.us-east-2.rds.amazonaws.com:3305/zhouxin?useUnicode=true&characterEncoding=UTF-8&useSSL=false"
                    , "zhouxin","zhouxin36");
            String sql = "select * from user where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,"dc1dc52e-79b9-11e8-9c15-fdc7eb479f4a");
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            String str = "id"+resultSet.getString("id")+"\n"
                    +"user_name11" + resultSet.getString("user_name") + "\n"
                    +"age" + resultSet.getString("age") + "\n"
                    +"sex" + resultSet.getString("sex") + "\n"
                    +"tel_no" + resultSet.getString("tel_no") + "\n";
            resp.getWriter().write(str);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }
}
