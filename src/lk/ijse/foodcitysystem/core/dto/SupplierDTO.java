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
public class SupplierDTO extends SuperDTO {
    private String supId;
    private String supName;
    private String company;
    private String address;
    private int contact;

    public SupplierDTO() {
    }

    public SupplierDTO(String supId, String supName, String company, String address, int contact) {
        this.supId = supId;
        this.supName = supName;
        this.company = company;
        this.address = address;
        this.contact = contact;
    }
     public SupplierDTO(String supName) {
         this.supName = supName;
     }
    /* public SupplierDTO(String supId) {
         this.supId = supId;
     }*/

   

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
     * @return the supName
     */
    public String getSupName() {
        return supName;
    }

    /**
     * @param supName the supName to set
     */
    public void setSupName(String supName) {
        this.supName = supName;
    }

    /**
     * @return the company
     */
    public String getCompany() {
        return company;
    }

    /**
     * @param company the company to set
     */
    public void setCompany(String company) {
        this.company = company;
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
    
    
    
    
    
}
