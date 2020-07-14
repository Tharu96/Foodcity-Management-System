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
public class GRNDTO extends SuperDTO{
    private String grnId;
    private String grnDate;
    private String supId;
    private double sup_Payment;

    public GRNDTO() {
    }

    public GRNDTO(String grnId, String grnDate, String supId, double sup_Payment) {
        this.grnId = grnId;
        this.grnDate = grnDate;
        this.supId = supId;
        this.sup_Payment = sup_Payment;
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
     * @return the grnDate
     */
    public String getGrnDate() {
        return grnDate;
    }

    /**
     * @param grnDate the grnDate to set
     */
    public void setGrnDate(String grnDate) {
        this.grnDate = grnDate;
    }

    /**
     * @return the supId
     */
    public String getSupId() {
        return supId;
    }

    /**
     * @param supId the supId to set
     */
    public void setSupId(String supId) {
        this.supId = supId;
    }

    /**
     * @return the sup_Payment
     */
    public double getSup_Payment() {
        return sup_Payment;
    }

    /**
     * @param sup_Payment the sup_Payment to set
     */
    public void setSup_Payment(double sup_Payment) {
        this.sup_Payment = sup_Payment;
    }
    
    
}
