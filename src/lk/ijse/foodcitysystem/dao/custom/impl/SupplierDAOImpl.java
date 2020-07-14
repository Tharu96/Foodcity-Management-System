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
import lk.ijse.foodcitysystem.core.dto.SupplierDTO;
import lk.ijse.foodcitysystem.dao.custom.SupplierDAO;
import lk.ijse.foodcitysystem.dao.db.DBConnection;


public class SupplierDAOImpl implements SupplierDAO {
    @Override
    public boolean add(SupplierDTO supplier) throws Exception {
        Connection connection=DBConnection.getInstance().getConnection();
        String SQL="insert into Supplier values(?,?,?,?,?)";
        PreparedStatement pstm=connection.prepareStatement(SQL);
        pstm.setObject(1, supplier.getSupId());
        pstm.setObject(2, supplier.getSupName());
        pstm.setObject(3, supplier.getCompany());
        pstm.setObject(4, supplier.getAddress());
        pstm.setObject(5, supplier.getContact());
        int affectedRows=pstm.executeUpdate();
        return (affectedRows>0);
    }
    @Override
    public boolean update(SupplierDTO supplier) throws Exception {
       Connection connection=DBConnection.getInstance().getConnection();
       String SQL="update Supplier set supName=?,company=?,address=?,contact=? where supId=?";
       PreparedStatement pstm=connection.prepareStatement(SQL);
       pstm.setObject(1,supplier.getSupName());
       pstm.setObject(2,supplier.getCompany());
       pstm.setObject(3,supplier.getAddress());
       pstm.setObject(4,supplier.getContact());
       pstm.setObject(5,supplier.getSupId());
       int affectedRows=pstm.executeUpdate();
       return (affectedRows>0);
    }
    @Override
    public boolean delete(SupplierDTO supplier) throws Exception {
        Connection connection=DBConnection.getInstance().getConnection();
        String SQL="delete from Supplier where supId=?";
        PreparedStatement pstm=connection.prepareStatement(SQL);
        pstm.setObject(1, supplier.getSupId());
        int affectedRows=pstm.executeUpdate();
        return (affectedRows>0);
    }
    @Override
    public SupplierDTO searchId(SupplierDTO supplier) throws Exception {
       Connection connection=DBConnection.getInstance().getConnection();
       String SqL="select *from Supplier where supId='"+supplier.getSupId()+"'";
       Statement stm=connection.createStatement();
       ResultSet rst= stm.executeQuery(SqL);
       if(rst.next()){
           return new SupplierDTO(
                   rst.getString(1),
                   rst.getString(2),
                   rst.getString(3),
                   rst.getString(4),
                   rst.getInt(5)
                   
           );
       }
       return null;
    }
    @Override
    public ArrayList<SupplierDTO> getAll() throws Exception {
        Connection connection=DBConnection.getInstance().getConnection();
        String SQL="select * from Supplier";
        Statement stm=connection.createStatement();
        ResultSet rst=stm.executeQuery(SQL);
        
        ArrayList<SupplierDTO> allSupplier=null;
        while(rst.next()){
            if(allSupplier==null){
                allSupplier=new ArrayList<>();
            }
            allSupplier.add(new SupplierDTO(
                    rst.getString(1),
                     rst.getString(2),
                     rst.getString(3),
                     rst.getString(4),
                     rst.getInt(5)
                    
                    
            ));
            
        }
        return allSupplier;
    }

    @Override
    public SupplierDTO search(SupplierDTO supplier) throws Exception {
        Connection connection=DBConnection.getInstance().getConnection();
       String SqL="select *from Supplier where supName='"+supplier.getSupName()+"'";
       Statement stm=connection.createStatement();
       ResultSet rst= stm.executeQuery(SqL);
       if(rst.next()){
           return new SupplierDTO(
                   rst.getString(1),
                   rst.getString(2),
                   rst.getString(3),
                   rst.getString(4),
                   rst.getInt(5)
                   
           );
       }
       return null;
    }
    
}
