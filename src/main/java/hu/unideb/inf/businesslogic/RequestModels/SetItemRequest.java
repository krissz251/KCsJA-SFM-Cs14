/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.businesslogic.RequestModels;

import hu.unideb.inf.businesslogic.Enums.ItemType;

/**
 *
 * @author Jelenszky Ádám
 */
public class SetItemRequest {
     public int Id;
   
    public int Amount;

    public SetItemRequest(int Id,  int Amount) {
        this.Id = Id;
      
      this.Amount = Amount;
 
    }
    
    
    
    
}
