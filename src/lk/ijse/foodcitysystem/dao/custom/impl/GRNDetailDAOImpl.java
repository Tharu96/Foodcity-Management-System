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
import lk.ijse.foodcitysystem.core.dto.GRNDetailDTO;
import lk.ijse.foodcitysystem.dao.custom.GRNDetailDAO;
import lk.ijse.foodcitysystem.dao.db.DBConnection;

/**
 *
 * @author Lenovo™
 */
public class GRNDetailDAOImpl implements GRNDetailDAO{

    @Override
    public boolean add(GRNDetailDTO grnDetail) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO GRNDetail VALUES (?,?,?,?,?,?)";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, grnDetail.getGrnId());
        pstm.setObject(2, grnDetail.getItemCode());
        pstm.setObject(3, grnDetail.getDescription());
        pstm.setObject(4, grnDetail.getOrderQty());
        pstm.setObject(5, grnDetail.getCostPrice());
        pstm.setObject(6, grnDetail.getSellingPrice());
        
        int affectedRows = pstm.executeUpdate();
        return (affectedRows > 0); 
    }

    @Override
    public boolean update(GRNDetailDTO grnDetail) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "UPDATE GRNDetail SET itemCode=?, description=?,orderQty=? ,costPrice=?,sellingPrice=? WHERE grnId=?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, grnDetail.getItemCode());
        pstm.setObject(2, grnDetail.getDescription());
        pstm.setObject(3, grnDetail.getOrderQty());
        pstm.setObject(4, grnDetail.getCostPrice());
        pstm.setObject(5, grnDetail.getSellingPrice());
        pstm.setObject(6, grnDetail.getGrnId());
        int affectedRows = pstm.executeUpdate();
        return (affectedRows > 0); 
    }
    @Override
    public boolean delete(GRNDetailDTO grnDetail) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "DELETE FROM GRNDetail WHERE grnId = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, grnDetail.getGrnId());
        int affectedRows = pstm.executeUpdate();
        return (affectedRows > 0);
    }

    @Override
    public GRNDetailDTO search(GRNDetailDTO grnDetail) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM GRNDetail WHERE GRNId='" + grnDetail.getGrnId()+ "'";
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);

        if (rst.next()) {
            return new GRNDetailDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getInt(4),
                    rst.getDouble(5),
                    rst.getDouble(6)
                    
            );
                   
                    
        }

        return null;
    }

    @Override
    public ArrayList<GRNDetailDTO> getAll() throws Exception {
         Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM GRNDetail";
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);

        ArrayList<GRNDetailDTO> allGRNDetails = null;

        while (rst.next()) {
            if (allGRNDetails == null) {
                allGRNDetails = new ArrayList<>();
            }

            allGRNDetails.add(new GRNDetailDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getInt(4),
                    rst.getDouble(5),
                    rst.getDouble(6)
                    
                    
            ));

        }
        return allGRNDetails;
    }
    
}
