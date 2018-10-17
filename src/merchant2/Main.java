/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package merchant2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        List<City> cities = new ArrayList<>();
        Calculate c = new Calculate();
        int min = 1;
        int max = 50;
               
        for(int i = 0; i <= 10; i++){
            cities.add(new City(randomNum(min,max), randomNum(min,max), i));
        }
        
        c.Compute(cities);
        System.out.println("Total distance is: " + c.totalDistance);
    }
    
    static int randomNum(int min, int max){
        int range = (max - min) + 1;     
        return (int)(Math.random() * range) + min;
    }
    
}
