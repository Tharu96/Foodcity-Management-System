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
import lk.ijse.foodcitysystem.core.dto.StockDTO;
import lk.ijse.foodcitysystem.dao.custom.StockDAO;
import lk.ijse.foodcitysystem.dao.db.DBConnection;

/**
 *
 * @author Lenovo™
 */
public class StockDAOImpl implements StockDAO{

    @Override
    public boolean add(StockDTO stock) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO Stock VALUES (?,?,?,?,?,?,?)";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, stock.getItemCode());
        pstm.setObject(2, stock.getDescription());
        pstm.setObject(3, stock.getSupplier());
        pstm.setObject(4, stock.getQtyOnHand());
        pstm.setObject(5, stock.getCostPrice());
        pstm.setObject(6, stock.getSellingPrice());
        pstm.setObject(7, stock.getDiscount());
        int affectedRows = pstm.executeUpdate();
        return (affectedRows > 0);
    }

    @Override
    public boolean update(StockDTO stock) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "UPDATE Stock SET Description=?, =?, Supplier=?,QtyOnHand=?,CostPricce=?,SellingPrice=?,Discount=? WHERE ItemCode=?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        
        pstm.setObject(1, stock.getDescription());
        pstm.setObject(2, stock.getSupplier());
        pstm.setObject(3, stock.getQtyOnHand());
        pstm.setObject(4, stock.getCostPrice());
        pstm.setObject(5, stock.getSellingPrice());
        pstm.setObject(6, stock.getDiscount());
        pstm.setObject(7, stock.getItemCode());
        int affectedRows = pstm.executeUpdate();
        return (affectedRows > 0);
    }

  

    @Override
    public boolean delete(StockDTO stock) throws Exception {
       Connection connection = DBConnection.getInstance().getConnection();
        String sql = "DELETE FROM Stock WHERE ItemCode = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, stock.getItemCode());
        int affectedRows = pstm.executeUpdate();
        return (affectedRows > 0);
    }

    @Override
    public StockDTO search(StockDTO stock) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM Stock WHERE ItemCode='" + stock.getItemCode() + "'";
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);

        if (rst.next()) {
            return new StockDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getInt(4),
                    rst.getDouble(5),
                    rst.getDouble(6),
                    rst.getDouble(7));
                    
        }

        return null;
    }

    @Override
    public ArrayList<StockDTO> getAll() throws Exception {
         Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM Stock";
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);

        ArrayList<StockDTO> allItems = null;

        while (rst.next()) {
            if (allItems == null) {
                allItems = new ArrayList<>();
            }

            allItems.add(new StockDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getInt(4),
                    rst.getDouble(5),
                    rst.getDouble(6),
                    rst.getDouble(7)
            ));

        }
        

        return allItems;
    }
    
}
