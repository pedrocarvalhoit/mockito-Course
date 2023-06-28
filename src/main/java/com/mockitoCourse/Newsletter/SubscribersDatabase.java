package com.mockitoCourse.Newsletter;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SubscribersDatabase {

    public List<String> getSubscribers(){
        List<String> subscribers = new ArrayList<String>();
//        try
//        {
//            Connection connection = DriverManager.getConnection("DB_URL");
//            Statement s = connection.createStatement();
//            ResultSet rs = s.executeQuery("SELECT EMAIL FROM SUBSCRIBER_TABLE");
//            while (rs.next()) {
//                subscribers.add(rs.toString());
//            }
//        }catch(
//                SQLException e)
//
//        {
//            e.printStackTrace();
//        }

        return subscribers;

    }

}
