/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.foodcitysystem.controller;

import java.util.ArrayList;
import lk.ijse.foodcitysystem.core.dto.GRNDetailDTO;
import lk.ijse.foodcitysystem.dao.DAOFactory;
import lk.ijse.foodcitysystem.dao.custom.GRNDetailDAO;

/**
 *
 * @author Lenovo™
 */
public class GRNDetailController {
    public static GRNDetailDAO grnDetailDAO = (GRNDetailDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.GRNDETAIL);
    
    public static boolean addGRNDetail(GRNDetailDTO grnDetail) throws  Exception  {
        boolean result = grnDetailDAO.add(grnDetail);
        return result;
    }
    
    public static boolean deleteGRNDetail(GRNDetailDTO grnDetail)throws Exception{
        boolean result = grnDetailDAO.delete(grnDetail);
        return result;
    }
    
    public static boolean updateGRNDetail(GRNDetailDTO grnDetail)throws Exception{
        boolean result = grnDetailDAO.update(grnDetail);
        return result;
    }
    
    public static GRNDetailDTO searchGRNDetail(GRNDetailDTO grnDetail) throws Exception{
        GRNDetailDTO searchedGRNDetail = grnDetailDAO.search(grnDetail);
        return searchedGRNDetail;
    }
    
    public static ArrayList<GRNDetailDTO> getAllGRNDetails()throws Exception{
        return grnDetailDAO.getAll();
    }
    
    
}
