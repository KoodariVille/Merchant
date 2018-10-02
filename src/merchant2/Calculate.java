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
public class Calculate {
    public int totalDistance = 0;
    
    double CalcDistance(City c1, City c2){
        return Math.sqrt(Math.pow(c2.GetX()-c1.GetX(), 2)+
                Math.pow(c2.GetY() - c1.GetY(), 2) * 1.0);
    }
    
    public void Compute(List<City> list){
        List<City> path = new ArrayList<>();
        String pathS = "Path is: ";
        City v = new City();
        pathS += (list.get(0)) + "-> ";
        path.add(list.get(0));
        list.remove(0);
        
        for(City x: list){
            x.SetDistance(CalcDistance(path.get(0),x));
            path.get(0).destinations.add(x);                                  
        }
        v = Greedy(path.get(0).destinations);
        list.remove(v);
        //path.add(v);
        pathS += v + "-> ";
        totalDistance += v.distance;
        
        while(!list.isEmpty()){
            for(City x: list){
                x.SetDistance(CalcDistance(v,x));
                v.destinations.add(x);
            }
            v = Greedy(v.destinations);
            list.remove(v);
            //path.add(v);
            pathS += v + "-> ";
            totalDistance += v.distance;
        }       
        //System.out.println(v.toString());
        //return pathS;
        System.out.println(pathS);
        //return path;
    }
    
    public City Greedy(List<City> list){
        City min = null;                   
        for(City x: list){   
            min=(min==null||x.distance<min.distance)?x:min;           
        }      
        return min;
    }
}
