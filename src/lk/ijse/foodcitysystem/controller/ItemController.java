/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.foodcitysystem.controller;

import java.util.ArrayList;
import lk.ijse.foodcitysystem.core.dto.ItemDTO;
import lk.ijse.foodcitysystem.dao.DAOFactory;
import lk.ijse.foodcitysystem.dao.custom.ItemDAO;

/**
 *
 * @author Lenovo™
 */
public class ItemController {
     public static ItemDAO itemDAO=(ItemDAO)DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ITEM);
    
    public static boolean addItem(ItemDTO item) throws Exception{
        boolean result=itemDAO.add(item);
        return result;
    }
    public static boolean updateItem(ItemDTO item) throws Exception{
        boolean result=itemDAO.update(item);
        return result;
    }
     public static boolean deleteItem(ItemDTO item)throws Exception{
        boolean result = itemDAO.delete(item);
        return result;
    }
    
   
    
    public static ItemDTO searchItem(ItemDTO item) throws Exception{
        ItemDTO searchedItem = itemDAO.search(item);
        return searchedItem;
    }
    
    public static ArrayList<ItemDTO> getAllItems()throws Exception{
        return itemDAO.getAll();
    }
    
}
