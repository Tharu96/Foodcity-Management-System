/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.foodcitysystem.controller;

import java.util.ArrayList;
import lk.ijse.foodcitysystem.core.dto.StockDTO;
import lk.ijse.foodcitysystem.dao.DAOFactory;
import lk.ijse.foodcitysystem.dao.custom.StockDAO;

/**
 *
 * @author Lenovo™
 */
public class StockController {
    public static StockDAO stockDAO = (StockDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.STOCK);
    
    public static boolean addCustomer(StockDTO stock) throws  Exception  {
        boolean result = stockDAO.add(stock);
        return result;
    }
    
    public static boolean deleteCustomer(StockDTO stock)throws Exception{
        boolean result = stockDAO.delete(stock);
        return result;
    }
    
    public static boolean updateCustomer(StockDTO stock)throws Exception{
        boolean result = stockDAO.update(stock);
        return result;
    }
    
    public static StockDTO searchCustomer(StockDTO stock) throws Exception{
        StockDTO searchedItem = stockDAO.search(stock);
        return searchedItem;
    }
    
    public static ArrayList<StockDTO> getAllCustomers()throws Exception{
        return stockDAO.getAll();
    }
    
    
}
