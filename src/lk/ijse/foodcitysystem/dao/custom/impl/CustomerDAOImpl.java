/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.foodcitysystem.dao.custom.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import lk.ijse.foodcitysystem.core.dto.CustomerDTO;
import lk.ijse.foodcitysystem.dao.custom.CustomerDAO;
import lk.ijse.foodcitysystem.dao.db.DBConnection;


public class CustomerDAOImpl implements CustomerDAO {

    @Override
    public boolean add(CustomerDTO customer) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO Customer VALUES (?,?,?,?,?,?)";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, customer.getCustId());
        pstm.setObject(2, customer.getCustName());
        pstm.setObject(3, customer.getAddress());
        pstm.setObject(4, customer.getContact());
        pstm.setObject(5, customer.getCreditLimit());
        pstm.setObject(6, customer.getCreditDays());
        int affectedRows = pstm.executeUpdate();
        return (affectedRows > 0);
    }

    @Override
    public boolean update(CustomerDTO customer) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "UPDATE Customer SET custName=?, address=?, contact=?,creditLimit=?,creditDays=? WHERE custId=?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, customer.getCustName());
        pstm.setObject(2, customer.getAddress());
        pstm.setObject(3, customer.getContact());
        pstm.setObject(4, customer.getCreditLimit());
        pstm.setObject(5, customer.getCreditDays());
        pstm.setObject(6, customer.getCustId());
        int affectedRows = pstm.executeUpdate();
        return (affectedRows > 0);
    }

    @Override
    public boolean delete(CustomerDTO customer) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "DELETE FROM Customer WHERE custId = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, customer.getCustId());
        int affectedRows = pstm.executeUpdate();
        return (affectedRows > 0);
    }

    @Override
    public CustomerDTO search(CustomerDTO customer) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM Customer WHERE custId='" + customer.getCustId() + "'";
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);

        if (rst.next()) {
            return new CustomerDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getInt(4),
                    rst.getDouble(5),
                    rst.getInt(6));
                    
        }

        return null;
    }

    @Override
    public ArrayList<CustomerDTO> getAll() throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM Customer";
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);

        ArrayList<CustomerDTO> allCustomers = null;

        while (rst.next()) {
            if (allCustomers == null) {
                allCustomers = new ArrayList<>();
            }

            allCustomers.add(new CustomerDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getInt(4),
                    rst.getDouble(5),
                    rst.getInt(6)
            ));

        }
        

        return allCustomers;
    }
    

    
    
}
