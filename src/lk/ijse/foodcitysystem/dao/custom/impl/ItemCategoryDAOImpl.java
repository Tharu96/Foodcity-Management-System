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
import lk.ijse.foodcitysystem.core.dto.ItemCategoryDTO;
import lk.ijse.foodcitysystem.dao.custom.ItemCategoryDAO;
import lk.ijse.foodcitysystem.dao.db.DBConnection;

/**
 *
 * @author Lenovo™
 */
public class ItemCategoryDAOImpl implements ItemCategoryDAO{

    @Override
    public boolean add(ItemCategoryDTO itemCategory) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO ItemCategory VALUES (?,?)";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, itemCategory.getCategoryCode());
        pstm.setObject(2, itemCategory.getCategoryName());
        
        int affectedRows = pstm.executeUpdate();
        return (affectedRows > 0);
        
    }

    @Override
    public boolean update(ItemCategoryDTO itemCategory) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "UPDATE ItemCategory SET categoryName=? WHERE categoryId=?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, itemCategory.getCategoryName());
        pstm.setObject(2, itemCategory.getCategoryCode());
       
        int affectedRows = pstm.executeUpdate();
        return (affectedRows > 0);
    }

    @Override
    public boolean delete(ItemCategoryDTO itemCategory) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "DELETE FROM ItemCategory WHERE categoryCode = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, itemCategory.getCategoryCode());
        int affectedRows = pstm.executeUpdate();
        return (affectedRows > 0);
    }

    @Override
    public ItemCategoryDTO search(ItemCategoryDTO itemCategory) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM ItemCategory WHERE categoryName='" + itemCategory.getCategoryName()+ "'";
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);

        if (rst.next()) {
            return new ItemCategoryDTO(
                    rst.getString(1),
                    rst.getString(2));
                   
                    
        }

        return null;
    }

    @Override
    public ArrayList<ItemCategoryDTO> getAll() throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM ItemCategory";
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);

        ArrayList<ItemCategoryDTO> allCategories = null;

        while (rst.next()) {
            if (allCategories == null) {
                allCategories = new ArrayList<>();
            }

            allCategories.add(new ItemCategoryDTO(
                    rst.getString(1),
                    rst.getString(2)
                    
            ));

        }
        

        return allCategories;
    }
    
}
