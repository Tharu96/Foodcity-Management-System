/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.foodcitysystem.dao;

import static lk.ijse.foodcitysystem.dao.DAOFactory.DAOTypes.CUSTOMER;
import lk.ijse.foodcitysystem.dao.custom.ItemCategoryDAO;
import lk.ijse.foodcitysystem.dao.custom.ItemDAO;
import lk.ijse.foodcitysystem.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.foodcitysystem.dao.custom.impl.GRNDAOImpl;
import lk.ijse.foodcitysystem.dao.custom.impl.GRNDetailDAOImpl;
import lk.ijse.foodcitysystem.dao.custom.impl.ItemCategoryDAOImpl;
import lk.ijse.foodcitysystem.dao.custom.impl.ItemDAOImpl;
import lk.ijse.foodcitysystem.dao.custom.impl.OrderDetailDAOImpl;
import lk.ijse.foodcitysystem.dao.custom.impl.OrdersDAOImpl;
import lk.ijse.foodcitysystem.dao.custom.impl.StockDAOImpl;
import lk.ijse.foodcitysystem.dao.custom.impl.SupplierDAOImpl;

/**
 *
 * @author Lenovo™
 */
public class DAOFactory {

   

    public enum DAOTypes{
        CUSTOMER,SUPPLIER,ITEMCATEGORY,ITEM,GRN,GRNDETAIL,STOCK,ORDERS,ORDERDETAIL
    }
    
    private static DAOFactory daoFactory;
    
    private DAOFactory(){
        
    }
    public  SuperDAO getDAO(DAOTypes daoTypes){
        switch(daoTypes){
            case CUSTOMER:
                return new CustomerDAOImpl();
            case SUPPLIER:
                return new SupplierDAOImpl();
            case ITEMCATEGORY:
                return new ItemCategoryDAOImpl();
            case ITEM:
                return new ItemDAOImpl();
            case GRN:
                return new GRNDAOImpl();
            case GRNDETAIL:
                return new GRNDetailDAOImpl();
            case STOCK:
                return new StockDAOImpl();
            case ORDERS:
                return new OrdersDAOImpl();
            case ORDERDETAIL:
                return new OrderDetailDAOImpl();
                   
            default:
                return null;

        }
    }
    public static DAOFactory getInstance(){
        if(daoFactory==null){
            daoFactory=new DAOFactory();
        }
        return daoFactory;
    }
    
    
}
