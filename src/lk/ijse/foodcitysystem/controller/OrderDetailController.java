/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.foodcitysystem.controller;

import java.util.ArrayList;
import lk.ijse.foodcitysystem.core.dto.OrderDetailDTO;
import lk.ijse.foodcitysystem.dao.DAOFactory;
import lk.ijse.foodcitysystem.dao.custom.OrderDetailDAO;

/**
 *
 * @author Lenovo™
 */
public class OrderDetailController {
    public static OrderDetailDAO orderDetailDAO = (OrderDetailDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ORDERDETAIL);
    
    public static boolean addOrderDetail(OrderDetailDTO orderDetail) throws  Exception  {
        boolean result = orderDetailDAO.add(orderDetail);
        return result;
    }
    
    public static boolean deleteOrderDetail(OrderDetailDTO orderDetail)throws Exception{
        boolean result = orderDetailDAO.delete(orderDetail);
        return result;
    }
    
    public static boolean updateOrderDetail(OrderDetailDTO orderDetail)throws Exception{
        boolean result = orderDetailDAO.update(orderDetail);
        return result;
    }
    
    public static OrderDetailDTO searchOrderDetail(OrderDetailDTO orderDetail) throws Exception{
       OrderDetailDTO searchedOrderDetail = orderDetailDAO.search(orderDetail);
        return searchedOrderDetail;
    }
    
    public static ArrayList<OrderDetailDTO> getAllOrderDetails()throws Exception{
        return orderDetailDAO.getAll();
    }
    
}
