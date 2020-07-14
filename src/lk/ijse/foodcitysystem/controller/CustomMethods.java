/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.foodcitysystem.controller;

import lk.ijse.foodcitysystem.core.dto.GRNDetailDTO;

/**
 *
 * @author Lenovo™
 */
public class CustomMethods {
    private static GRNDetailDTO gRNDetailDTO;
    
   public static void setGRNDetailDTO(GRNDetailDTO grndetail){
       CustomMethods.gRNDetailDTO=grndetail;
   }
   
   public static GRNDetailDTO getGRNDetailDTO(){
   return CustomMethods.gRNDetailDTO;
   }
}
