/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.foodcitysystem.core.dto;

/**
 *
 * @author Lenovo™
 */
public class OrdersDTO extends SuperDTO{
    private String placeOrderNO;
    private String placeOrderDate;

    public OrdersDTO() {
    }

    public OrdersDTO(String placeOrderNO, String placeOrderDate) {
        this.placeOrderNO = placeOrderNO;
        this.placeOrderDate = placeOrderDate;
    }

    /**
     * @return the placeOrderNO
     */
    public String getPlaceOrderNO() {
        return placeOrderNO;
    }

    /**
     * @param placeOrderNO the placeOrderNO to set
     */
    public void setPlaceOrderNO(String placeOrderNO) {
        this.placeOrderNO = placeOrderNO;
    }

    /**
     * @return the placeOrderDate
     */
    public String getPlaceOrderDate() {
        return placeOrderDate;
    }

    /**
     * @param placeOrderDate the placeOrderDate to set
     */
    public void setPlaceOrderDate(String placeOrderDate) {
        this.placeOrderDate = placeOrderDate;
    }
    
    
}
