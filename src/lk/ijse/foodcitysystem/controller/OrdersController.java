/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.foodcitysystem.controller;

import java.util.ArrayList;
import lk.ijse.foodcitysystem.core.dto.OrdersDTO;
import lk.ijse.foodcitysystem.dao.DAOFactory;
import lk.ijse.foodcitysystem.dao.custom.OrdersDAO;

/**
 *
 * @author Lenovo™
 */
public class OrdersController {
     public static OrdersDAO ordersDAO = (OrdersDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ORDERS);
    
    public static boolean addOrder(OrdersDTO orders) throws  Exception  {
        boolean result = ordersDAO.add(orders);
        return result;
    }
    
    public static boolean deleteOrder(OrdersDTO orders)throws Exception{
        boolean result = ordersDAO.delete(orders);
        return result;
    }
    
    public static boolean updateOrder(OrdersDTO orders)throws Exception{
        boolean result = ordersDAO.update(orders);
        return result;
    }
    
    public static OrdersDTO searchOrder(OrdersDTO orders) throws Exception{
        OrdersDTO searchedOrders = ordersDAO.search(orders);
        return searchedOrders;
    }
    
    public static ArrayList<OrdersDTO> getAllOrders()throws Exception{
        return ordersDAO.getAll();
    }
    
}
