package Datebase;


import carParts.Car;

import java.io.BufferedReader;
import java.io.FileReader;


public class CsvReader {
    String csvFile = "C:/Users/dkoby/Desktop/dupachuj/cars.csv";
    String line = "";
    String cvsSplitBy = ",";
    CarsBase cars;

    public CsvReader(){
        this.cars=new CarsBase();
    }
    public CarsBase czytaj() {
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] country = line.split(cvsSplitBy);
                cars.add(new Car(country[1],country[2],country[3]));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return cars;
    }

}

