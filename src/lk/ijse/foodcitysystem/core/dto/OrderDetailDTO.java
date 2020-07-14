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
public class OrderDetailDTO extends SuperDTO{
    private String placeOrderNo ;
    private String placeOrderdate;  
    private String ItemCode ;
    private String  Description ;
    private int  OrderQty ;
    private int  QtyOnHand; 
    private double unitPrice;  
    private double totalAmount ;

    public OrderDetailDTO() {
    }

    public OrderDetailDTO(String placeOrderNo, String placeOrderdate, String ItemCode, String Description, int OrderQty, int QtyOnHand, double unitPrice, double totalAmount) {
        this.placeOrderNo = placeOrderNo;
        this.placeOrderdate = placeOrderdate;
        this.ItemCode = ItemCode;
        this.Description = Description;
        this.OrderQty = OrderQty;
        this.QtyOnHand = QtyOnHand;
        this.unitPrice = unitPrice;
        this.totalAmount = totalAmount;
    }

    /**
     * @return the placeOrderNo
     */
    public String getPlaceOrderNo() {
        return placeOrderNo;
    }

    /**
     * @param placeOrderNo the placeOrderNo to set
     */
    public void setPlaceOrderNo(String placeOrderNo) {
        this.placeOrderNo = placeOrderNo;
    }

    /**
     * @return the placeOrderdate
     */
    public String getPlaceOrderdate() {
        return placeOrderdate;
    }

    /**
     * @param placeOrderdate the placeOrderdate to set
     */
    public void setPlaceOrderdate(String placeOrderdate) {
        this.placeOrderdate = placeOrderdate;
    }

    /**
     * @return the ItemCode
     */
    public String getItemCode() {
        return ItemCode;
    }

    /**
     * @param ItemCode the ItemCode to set
     */
    public void setItemCode(String ItemCode) {
        this.ItemCode = ItemCode;
    }

    /**
     * @return the Description
     */
    public String getDescription() {
        return Description;
    }

    /**
     * @param Description the Description to set
     */
    public void setDescription(String Description) {
        this.Description = Description;
    }

    /**
     * @return the OrderQty
     */
    public int getOrderQty() {
        return OrderQty;
    }

    /**
     * @param OrderQty the OrderQty to set
     */
    public void setOrderQty(int OrderQty) {
        this.OrderQty = OrderQty;
    }

    /**
     * @return the QtyOnHand
     */
    public int getQtyOnHand() {
        return QtyOnHand;
    }

    /**
     * @param QtyOnHand the QtyOnHand to set
     */
    public void setQtyOnHand(int QtyOnHand) {
        this.QtyOnHand = QtyOnHand;
    }

    /**
     * @return the unitPrice
     */
    public double getUnitPrice() {
        return unitPrice;
    }

    /**
     * @param unitPrice the unitPrice to set
     */
    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * @return the totalAmount
     */
    public double getTotalAmount() {
        return totalAmount;
    }

    /**
     * @param totalAmount the totalAmount to set
     */
    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
    
    
}
