/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.foodcitysystem.controller;

import java.util.ArrayList;
import lk.ijse.foodcitysystem.core.dto.ItemCategoryDTO;
import lk.ijse.foodcitysystem.dao.DAOFactory;
import lk.ijse.foodcitysystem.dao.custom.ItemCategoryDAO;

/**
 *
 * @author Lenovo™
 */
public class ItemCategoryController {
    public static ItemCategoryDAO itemCategoryDAO=(ItemCategoryDAO)DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ITEMCATEGORY);
    
    public static boolean addCategory(ItemCategoryDTO itemCategory) throws Exception{
        boolean result=itemCategoryDAO.add(itemCategory);
        return result;
    }
    public static boolean updateCategory(ItemCategoryDTO itemCategory) throws Exception{
        boolean result=itemCategoryDAO.update(itemCategory);
        return result;
    }
     public static boolean deleteCategory(ItemCategoryDTO itemCategory)throws Exception{
        boolean result = itemCategoryDAO.delete(itemCategory);
        return result;
    }
    
   
    
    public static ItemCategoryDTO searchCategory(ItemCategoryDTO itemCategory) throws Exception{
        ItemCategoryDTO searchedCategory = itemCategoryDAO.search(itemCategory);
        return searchedCategory;
    }
    
    public static ArrayList<ItemCategoryDTO> getAllCategories()throws Exception{
        return itemCategoryDAO.getAll();
    }
    
}
