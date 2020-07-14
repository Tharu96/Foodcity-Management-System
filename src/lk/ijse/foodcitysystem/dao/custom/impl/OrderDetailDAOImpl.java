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
import lk.ijse.foodcitysystem.core.dto.OrderDetailDTO;
import lk.ijse.foodcitysystem.dao.custom.OrderDetailDAO;
import lk.ijse.foodcitysystem.dao.db.DBConnection;

/**
 *
 * @author Lenovo™
 */
public class OrderDetailDAOImpl implements OrderDetailDAO{

    @Override
    public boolean add(OrderDetailDTO orderDetail) throws Exception {
         Connection connection = DBConnection.getInstance().getConnection();
       String sql = "INSERT INTO OrderDetail VALUES (?,?,?,?,?,?,?,?)";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, orderDetail.getPlaceOrderNo());
        pstm.setObject(2, orderDetail.getPlaceOrderdate());
        pstm.setObject(3, orderDetail.getItemCode());
        pstm.setObject(4, orderDetail.getDescription());
        pstm.setObject(5, orderDetail.getOrderQty());
        pstm.setObject(6, orderDetail.getUnitPrice());
        pstm.setObject(7, orderDetail.getOrderQty());
        pstm.setObject(8, orderDetail.getTotalAmount());
        int affectedRows = pstm.executeUpdate();
        return (affectedRows > 0);
    }
    @Override
    public boolean update(OrderDetailDTO orderDetail) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "UPDATE OrderDetail SET placeOrdeerdate=?, itemCode=?,"
                + " descriptioon=?,orderQty=?,unitPrice=?,totalAmount=? WHERE placeOrderNo=?";
        PreparedStatement pstm = connection.prepareStatement(sql);
       
        pstm.setObject(1, orderDetail.getPlaceOrderdate());
        pstm.setObject(2, orderDetail.getItemCode());
        pstm.setObject(3, orderDetail.getDescription());
        pstm.setObject(4, orderDetail.getOrderQty());
        pstm.setObject(5, orderDetail.getUnitPrice());
        pstm.setObject(6, orderDetail.getOrderQty());
        pstm.setObject(7, orderDetail.getTotalAmount());
        pstm.setObject(8, orderDetail.getPlaceOrderNo());
        int affectedRows = pstm.executeUpdate();
        return (affectedRows > 0);
    }

    @Override
    public boolean delete(OrderDetailDTO orderDetail) throws Exception {
       Connection connection = DBConnection.getInstance().getConnection();
        String sql = "DELETE FROM OrderDetail WHERE placeOrderNo = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, orderDetail.getPlaceOrderNo());
        int affectedRows = pstm.executeUpdate();
        return (affectedRows > 0);
    }

    @Override
    public OrderDetailDTO search(OrderDetailDTO orderDetail) throws Exception {
         Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM OrderDetail WHERE placeOrderNo='" + orderDetail.getPlaceOrderNo() + "'";
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);

        if (rst.next()) {
            return new OrderDetailDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getInt(5),
                    rst.getInt(6),
                    rst.getDouble(7),
                    rst.getInt(8));
                    
        }

        return null;
    }

    @Override
    public ArrayList<OrderDetailDTO> getAll() throws Exception {
         Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM OrderDetail";
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);

        ArrayList<OrderDetailDTO> allOrders = null;

        while (rst.next()) {
            if (allOrders == null) {
                allOrders = new ArrayList<>();
            }

            allOrders.add(new OrderDetailDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getInt(5),
                    rst.getInt(6),
                    rst.getDouble(7),
                    rst.getInt(8)
            ));

        }
        

        return allOrders;
    }
    
    
}
