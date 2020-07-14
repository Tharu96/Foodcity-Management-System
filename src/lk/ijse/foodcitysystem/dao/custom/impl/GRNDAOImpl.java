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
import lk.ijse.foodcitysystem.core.dto.GRNDTO;
import lk.ijse.foodcitysystem.dao.custom.GRNDAO;
import lk.ijse.foodcitysystem.dao.db.DBConnection;

/**
 *
 * @author Lenovo™
 */
public class GRNDAOImpl implements GRNDAO{

    @Override
    public boolean add(GRNDTO grn) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO GRN VALUES (?,?,?,?)";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, grn.getGrnId());
        pstm.setObject(2, grn.getGrnDate());
        pstm.setObject(3, grn.getSupId());
        pstm.setObject(4, grn.getSup_Payment());
        
        int affectedRows = pstm.executeUpdate();
        return (affectedRows > 0); 
    }

    @Override
    public boolean update(GRNDTO grn) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "UPDATE GRN SET grnDate=?, supId=?,supPayment=? WHERE grnId=?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, grn.getGrnDate());
        pstm.setObject(2, grn.getSupId());
        pstm.setObject(3, grn.getSup_Payment());
        pstm.setObject(4, grn.getGrnId());
        int affectedRows = pstm.executeUpdate();
        return (affectedRows > 0); 
    }

    @Override
    public boolean delete(GRNDTO grn) throws Exception {
         Connection connection = DBConnection.getInstance().getConnection();
        String sql = "DELETE FROM GRN WHERE grnId = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, grn.getGrnId());
        int affectedRows = pstm.executeUpdate();
        return (affectedRows > 0);
    }

    @Override
    public GRNDTO search(GRNDTO grn) throws Exception {
         Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM GRN WHERE GRNId='" + grn.getGrnId()+ "'";
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);

        if (rst.next()) {
            return new GRNDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getDouble(4))
            ;
                   
                    
        }

        return null;
    }

    @Override
    public ArrayList<GRNDTO> getAll() throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM GRN";
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);

        ArrayList<GRNDTO> allGRNs = null;

        while (rst.next()) {
            if (allGRNs == null) {
                allGRNs = new ArrayList<>();
            }

            allGRNs.add(new GRNDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getDouble(4)
                    
            ));

        }
        return allGRNs;
   
    }
    
}
