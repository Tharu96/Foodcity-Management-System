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
import lk.ijse.foodcitysystem.core.dto.OrdersDTO;
import lk.ijse.foodcitysystem.dao.custom.OrdersDAO;
import lk.ijse.foodcitysystem.dao.db.DBConnection;

/**
 *
 * @author Lenovo™
 */
public class OrdersDAOImpl implements OrdersDAO{

    @Override
    public boolean add(OrdersDTO orders) throws Exception {
         Connection connection = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO Orders VALUES (?,?)";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, orders.getPlaceOrderNO());
        pstm.setObject(2, orders.getPlaceOrderDate());
        
        int affectedRows = pstm.executeUpdate();
        return (affectedRows > 0);
    }

    @Override
    public boolean update(OrdersDTO orders ) throws Exception {
       Connection connection = DBConnection.getInstance().getConnection();
        String sql = "UPDATE Orders SET placeOrderdate=? WHERE placeOrderNO=?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, orders.getPlaceOrderDate());
        pstm.setObject(2, orders.getPlaceOrderNO());
       
        int affectedRows = pstm.executeUpdate();
        return (affectedRows > 0); 
    }

    @Override
    public boolean delete(OrdersDTO orders) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "DELETE FROM Orders WHERE placeOrderNO = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, orders.getPlaceOrderNO());
        int affectedRows = pstm.executeUpdate();
        return (affectedRows > 0);
    }

    @Override
    public OrdersDTO search(OrdersDTO orders) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM Orders WHERE categoryName='" + orders.getPlaceOrderNO()+ "'";
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);

        if (rst.next()) {
            return new OrdersDTO(
                    rst.getString(1),
                    rst.getString(2));
                   
                    
        }

        return null;
    }

    @Override
    public ArrayList<OrdersDTO> getAll() throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM Orders";
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);

        ArrayList<OrdersDTO> allOrders = null;

        while (rst.next()) {
            if (allOrders == null) {
                allOrders = new ArrayList<>();
            }

            allOrders.add(new OrdersDTO(
                    rst.getString(1),
                    rst.getString(2)
                    
            ));

        }
        

        return allOrders;
    }
    
}
