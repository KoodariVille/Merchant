package merchant2;

import java.util.ArrayList;
import java.util.List;

public class Calculate {
    public int totalDistance = 0;
    
    //palautetaan kahden kaupungin välinen etäisyys
    //pythagoran lauseella
    double CalcDistance(City c1, City c2){
        return Math.sqrt(Math.pow(c2.GetX()-c1.GetX(), 2)+
                Math.pow(c2.GetY() - c1.GetY(), 2) * 1.0);
    }
    
    public void Compute(List<City> list){
        List<City> path = new ArrayList<>();
        String pathS = "Path is: ";
        City v;
        //otetaan lähtökaupunki tulostettavaan pathS
        pathS += (list.get(0)) + "-> ";
        path.add(list.get(0));
        //poistetaan annetusta listasta lähtökaupunki
        list.remove(0);
        
        for(City x: list){
            //lasketaan etäisyydet lähtökaupungille kaupunkeihin
            x.SetDistance(CalcDistance(path.get(0),x));
            path.get(0).destinations.add(x);                                  
        }
        //haetaan lyhin matka
        v = Greedy(path.get(0).destinations);
        //poistetaan saatu kaupunki listasta
        list.remove(v);
        //lisätään se tulostukseen
        pathS += v + "-> ";
        totalDistance += v.distance;
        
        //käydään listaa läpi kunnes se on tyhjä
        while(!list.isEmpty()){
            for(City x: list){
                x.SetDistance(CalcDistance(v,x));
                v.destinations.add(x);
            }
            //v:hen tulee aina seuraava kaupunki
            //ja se poistetaan listalta
            v = Greedy(v.destinations);
            list.remove(v);
            pathS += v + "-> ";
            totalDistance += v.distance;
        }       

        System.out.println(pathS);
    }
    
    //palauttaa pienimmän arvon annetusta kaupunkeja sisältävästä listasta
    public City Greedy(List<City> list){
        City min = null;                   
        for(City x: list){
            min=(min==null||x.distance<min.distance)?x:min;           
        }      
        return min;
    }
}
