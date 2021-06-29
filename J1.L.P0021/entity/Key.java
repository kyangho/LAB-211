/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Map;

/**
 *
 * @author Duc Ky
 */
public class Key {
   public String key1;
   public String key2, key3;

   public Key(String key1, String key2, String key3) {
      this.key1 = key1;
      this.key2 = key2;
      this.key3 = key3;
   }

    @Override   
    public boolean equals(Object obj) {
       if (!(obj instanceof Key))
         return false;
       Key ref = (Key) obj;
       return this.key1.compareTo(ref.key1) == 0 && this.key2.compareTo(ref.key2) == 0 && 
           this.key2.compareTo(ref.key2) == 0;
    }
    
    @Override
    public int hashCode() {
        return  key1.hashCode() ^ key2.hashCode() ^ key3.hashCode();
    }
    


}