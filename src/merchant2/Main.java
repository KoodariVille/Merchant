package merchant2;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Ville Niemi
 */
public class Main {

    public static void main(String[] args) {
        
        List<City> cities = new ArrayList<>();
        Calculate c = new Calculate();
        int min = 1;
        int max = 50;
         
        //Generoidaan for silmukan mukainen määrä kaupunkeja
        for(int i = 0; i <= 20; i++){
            //tehdään kaupungit
            cities.add(new City(randomNum(min,max), randomNum(min,max), i));
        }
        //Lasketaan reitti
        c.Compute(cities);
        System.out.println("Total distance is: " + c.totalDistance);
    }
    
    static int randomNum(int min, int max){
        int range = (max - min) + 1;     
        return (int)(Math.random() * range) + min;
    }
    
}
