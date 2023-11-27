package com.example.front.app;

import java.sql.*;
import com.example.front.util.DBMgr;
import org.json.*;

public class ToDoHelper {
    private ToDoHelper() {};

    private static ToDoHelper tdh;
    private Connection conn = null;
    private PreparedStatement pres = null;

    public static ToDoHelper getHelper() {
        if (tdh == null) tdh = new ToDoHelper();
        return tdh;
    }

    public void create(ToDo td) {
        try {
            conn = DBMgr.getConnection();
            String sql = "INSERT INTO `todo_list`.`todo_list`(`topic`, `content`) VALUES(?, ?)";
            pres = conn.prepareStatement(sql);
            pres.setString(1, td.getTopic());
            pres.setString(2, td.getContent());
            pres.execute();
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s\n%s", e.getErrorCode(), e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBMgr.close(pres, conn);
        }
    }

    public JSONObject selectAll() {
        ToDo td;
        ResultSet rs;
        JSONObject response;
        JSONArray jsa = new JSONArray();

        try {
            conn = DBMgr.getConnection();
            String sql = "SELECT * FROM `todo_list`.`todo_list`";
            pres = conn.prepareStatement(sql);
            rs = pres.executeQuery();

            while(rs.next()){
                td = new ToDo(
                        rs.getInt("id"),
                        rs.getString("topic"),
                        rs.getString("content"),
                        rs.getTimestamp("create_time"),
                        rs.getTimestamp("update_time")
                );
                jsa.put(td.getData());
            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s\n%s", e.getErrorCode(), e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBMgr.close(pres, conn);
        }

        response = new JSONObject();
        response.put("data", jsa);
        return response;
    }

    public void delete(ToDo td) {
        try {
            conn = DBMgr.getConnection();
            String sql = "DELETE FROM `todo_list`.`todo_list` WHERE id=?";
            pres = conn.prepareStatement(sql);
            pres.setInt(1 , td.getId());
            pres.execute();

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s\n%s", e.getErrorCode(), e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBMgr.close(pres, conn);
        }
    }

    public void update(ToDo td) {
        try {
            conn = DBMgr.getConnection();
            String sql = "UPDATE `todo_list`.`todo_list` SET topic=?, content=? WHERE id=?";
            pres = conn.prepareStatement(sql);
            pres.setString(1 , td.getTopic());
            pres.setString(2 , td.getContent());
            pres.setInt(3 , td.getId());
            pres.executeUpdate();
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s\n%s", e.getErrorCode(), e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBMgr.close(pres, conn);
        }
    }
}
