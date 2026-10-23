package com.example.contactmanager.model;

import com.example.contactmanager.database.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContactDAO {

    public List<Contact> findAllContacts() throws SQLException{
        String sql = "SELECT first_name, last_name, phone_number FROM contact";
        List<Contact> liste = new ArrayList<>();

        try (Connection cn = DBConnection.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()){
            while (rs.next()){
                Contact C = new Contact(
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("phone_number")
                );
                liste.add(C);
            }
        }
        return liste;
    }

    public int updatePhoneNumber(Long id, String newPhoneNumber) throws SQLException {
        String sql = "UPDATE contact SET phone_number = ?, updated_at = CURRENT_TIMESTAMP WHERE id = ?";

        try (Connection cn = DBConnection.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, newPhoneNumber);
            ps.setLong(2, id);

            return ps.executeUpdate();
        }
    }

    public int addContact(Contact c) throws SQLException{
        String sql =
                "INSERT INTO contact(first_name, last_name, phone_number, email, description) VALUES (?, ?, ?, ?, ?)";

        try (Connection cn = DBConnection.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)){
             ps.setString(1, c.getFirstName());
             ps.setString(2, c.getLastName());
             ps.setString(3, c.getPhoneNumber());
             ps.setString(4, c.getEmail());
             ps.setString(5, c.getDescription());

            return ps.executeUpdate();
        }
    }



    public int deleteContact(String contactNum) throws SQLException{
        String sql =
                "DELETE FROM contact WHERE phone_number = ?";
        try (Connection cn = DBConnection.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)){
            ps.setString(1, contactNum);
            return ps.executeUpdate();
        }
    }

}
