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
public class CustomerDTO extends SuperDTO{
    private String custId;
    private String custName;
    private String address;
    private int contact;
    private double creditLimit;
    private int creditDays;

    public CustomerDTO() {
    }

    public CustomerDTO(String custId, String custName, String address, int contact, double creditLimit, int creditDays) {
        this.custId = custId;
        this.custName = custName;
        this.address = address;
        this.contact = contact;
        this.creditLimit = creditLimit;
        this.creditDays = creditDays;
    }
    public CustomerDTO( String custName, String address, int contact, double creditLimit, int creditDays) {
        
        this.custName = custName;
        this.address = address;
        this.contact = contact;
        this.creditLimit = creditLimit;
        this.creditDays = creditDays;
    }
     public CustomerDTO(String custId) {
         this.custId = custId;
    }

    /**
     * @return the custId
     */
    public String getCustId() {
        return custId;
    }

    /**
     * @param custId the custId to set
     */
    public void setCustId(String custId) {
        this.custId = custId;
    }

    /**
     * @return the custName
     */
    public String getCustName() {
        return custName;
    }

    /**
     * @param custName the custName to set
     */
    public void setCustName(String custName) {
        this.custName = custName;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the contact
     */
    public int getContact() {
        return contact;
    }

    /**
     * @param contact the contact to set
     */
    public void setContact(int contact) {
        this.contact = contact;
    }

    /**
     * @return the creditLimit
     */
    public double getCreditLimit() {
        return creditLimit;
    }

    /**
     * @param creditLimit the creditLimit to set
     */
    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    /**
     * @return the creditDays
     */
    public int getCreditDays() {
        return creditDays;
    }

    /**
     * @param creditDays the creditDays to set
     */
    public void setCreditDays(int creditDays) {
        this.creditDays = creditDays;
    }

}