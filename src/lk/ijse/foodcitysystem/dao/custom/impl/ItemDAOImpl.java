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
import lk.ijse.foodcitysystem.core.dto.ItemDTO;
import lk.ijse.foodcitysystem.dao.custom.ItemDAO;
import lk.ijse.foodcitysystem.dao.db.DBConnection;

/**
 *
 * @author Lenovo™
 */
public class ItemDAOImpl implements ItemDAO{

    @Override
    public boolean add(ItemDTO item) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO Item VALUES (?,?,?,?)";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, item.getItemCode());
        pstm.setObject(2, item.getDescription());
        pstm.setObject(3, item.getCategoryName());
        pstm.setObject(4, item.getCategoryCode());
        
        int affectedRows = pstm.executeUpdate();
        return (affectedRows > 0);
    }

    @Override
    public boolean update(ItemDTO item) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "UPDATE Item SET description=?, categoryName=?,categoryId=? WHERE itemCode=?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, item.getDescription());
        pstm.setObject(2, item.getCategoryName());
        pstm.setObject(3, item.getCategoryCode());
        pstm.setObject(4, item.getItemCode());
       
        int affectedRows = pstm.executeUpdate();
        return (affectedRows > 0); 
    }

    @Override
    public boolean delete(ItemDTO item) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "DELETE FROM Item WHERE itemCode = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, item.getItemCode());
        int affectedRows = pstm.executeUpdate();
        return (affectedRows > 0);
    }

    @Override
    public ItemDTO search(ItemDTO item) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM Item WHERE itemCode='" + item.getItemCode()+ "'";
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);

        if (rst.next()) {
            return new ItemDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4))
            ;
                   
                    
        }

        return null;
    }

    @Override
    public ArrayList<ItemDTO> getAll() throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM Item";
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);

        ArrayList<ItemDTO> allItems = null;

        while (rst.next()) {
            if (allItems == null) {
                allItems = new ArrayList<>();
            }

            allItems.add(new ItemDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4)
                    
            ));

        }
        return allItems;
   
    }
    
}
