package Datebase;

import carParts.Car;

import java.util.*;

public class CarsBase extends ArrayList<Car> {

    public List<Car> getCars(String year){

        Set<Car> cars=new HashSet<>();
        forEach(car -> {if(car.getCarModelYear().equals(year)) {
            cars.add(car);
        }
        });

        List<Car> carsb=new ArrayList<>();
        carsb.addAll(cars);

        return carsb;
    }

    public List<Car> getCars(String year,String make){

        List<Car> cars=new ArrayList<>();
        forEach(car -> {if(car.getCarModelYear().equals(year) && car.getCarMake().equals(make)) {
            cars.add(car);
        }
        });

        return cars;
    }
}
