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
public class GRNDetailDTO extends SuperDTO{
    private String grnId;
    private String itemCode;
    private String description;
    private int orderQty;
    private double costPrice;
    private double sellingPrice;

    public GRNDetailDTO() {
    }

    public GRNDetailDTO(String grnId, String itemCode, String description, int orderQty, double costPrice, double sellingPrice) {
        this.grnId = grnId;
        this.itemCode = itemCode;
        this.description = description;
        this.orderQty = orderQty;
        this.costPrice = costPrice;
        this.sellingPrice = sellingPrice;
    }
    public GRNDetailDTO( String itemCode, String description, int orderQty, double costPrice, double sellingPrice) {
        
        this.itemCode = itemCode;
        this.description = description;
        this.orderQty = orderQty;
        this.costPrice = costPrice;
        this.sellingPrice = sellingPrice;
    }
    /**
     * @return the grnId
     */
    public String getGrnId() {
        return grnId;
    }

    /**
     * @param grnId the grnId to set
     */
    public void setGrnId(String grnId) {
        this.grnId = grnId;
    }

    /**
     * @return the itemCode
     */
    public String getItemCode() {
        return itemCode;
    }

    /**
     * @param itemCode the itemCode to set
     */
    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the orderQty
     */
    public int getOrderQty() {
        return orderQty;
    }

    /**
     * @param orderQty the orderQty to set
     */
    public void setOrderQty(int orderQty) {
        this.orderQty = orderQty;
    }

    /**
     * @return the costPrice
     */
    public double getCostPrice() {
        return costPrice;
    }

    /**
     * @param costPrice the costPrice to set
     */
    public void setCostPrice(double costPrice) {
        this.costPrice = costPrice;
    }

    /**
     * @return the sellingPrice
     */
    public double getSellingPrice() {
        return sellingPrice;
    }

    /**
     * @param sellingPrice the sellingPrice to set
     */
    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }
     
    
    
}
