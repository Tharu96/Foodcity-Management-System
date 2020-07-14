/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.foodcitysystem.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import lk.ijse.foodcitysystem.core.dto.GRNDTO;
import lk.ijse.foodcitysystem.core.dto.GRNDetailDTO;
import lk.ijse.foodcitysystem.dao.DAOFactory;
import lk.ijse.foodcitysystem.dao.custom.GRNDAO;
import lk.ijse.foodcitysystem.dao.custom.GRNDetailDAO;
import lk.ijse.foodcitysystem.dao.db.DBConnection;

/**
 *
 * @author Lenovo™
 */
public class GRNController {
    public static GRNDAO grnDAO = (GRNDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.GRN);
    public static GRNDetailDAO gRNDetailDAO = (GRNDetailDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.GRNDETAIL);
    
    public static boolean addGRN(GRNDTO grn) throws  Exception  {
        boolean result = grnDAO.add(grn);
        return result;
    }
    
    public static boolean deleteGRN(GRNDTO grn)throws Exception{
        boolean result = grnDAO.delete(grn);
        return result;
    }
    
    public static boolean updateGRN(GRNDTO grn)throws Exception{
        boolean result = grnDAO.update(grn);
        return result;
    }
    
    public static GRNDTO searchGRN(GRNDTO grn) throws Exception{
        GRNDTO searchedGRN = grnDAO.search(grn);
        return searchedGRN;
    }
    
    public static ArrayList<GRNDTO> getAllGRNs()throws Exception{
        return grnDAO.getAll();
    }
    

    
}
