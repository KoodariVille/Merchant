package merchant2;

import java.util.ArrayList;
import java.util.List;

public class City {
    private int x, y;
    public String name;
    public double distance;
    public List<City> destinations;
    
    public City(int x, int y, int i){
        this.name = "City" + i;
        this.x = x;
        this.y = y;
        destinations = new ArrayList<>();
    }
    
    public City(){}
    
    public void SetName(String name){
        this.name = name;
    }
    
    public String GetName(){
        return name;
    }
    
    public void SetY(int y){
        this.y = y;
    }
    
    public int GetY(){
        return y;
    }
    
    public void SetX(int x){
        this.x = x;
    }
    
    public int GetX(){
        return x;
    }
    
    public void SetDistance(double distance){
        this.distance = distance;
    }
    
    public double GetDistance(){
        return Math.round(distance);
    }
    
    @Override
    public String toString(){
        return name;
    }
}
