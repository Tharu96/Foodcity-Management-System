/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.foodcitysystem.dao.custom;

import lk.ijse.foodcitysystem.core.dto.SupplierDTO;
import lk.ijse.foodcitysystem.dao.SuperDAO;

/**
 *
 * @author Lenovo™
 */
public interface SupplierDAO extends SuperDAO<SupplierDTO> {
  public SupplierDTO searchId(SupplierDTO supplier) throws Exception ;  
}
