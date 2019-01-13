package Datebase;


import carParts.Car;

import java.io.BufferedReader;
import java.io.FileReader;


public class CsvReader {
    String csvFile = "cars.csv";
    String line = "";
    String cvsSplitBy = ",";
    CarsBase cars;

    public CsvReader(){
        this.cars=new CarsBase();
    }
    public CarsBase getCars() {
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] country = line.split(cvsSplitBy);
                cars.add(new Car(country[0],country[1],country[2],country[3]));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return cars;
    }

    public String getBumperPrice(String id){
        try (BufferedReader br = new BufferedReader(new FileReader("zderzak.csv"))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] country = line.split(cvsSplitBy);
                if(id.equals(country[0])){
                    return country[1];
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "0";
    }
    public String getHeadLight(String id){
        try (BufferedReader br = new BufferedReader(new FileReader("lampy przednie.csv"))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] country = line.split(cvsSplitBy);
                if(id.equals(country[1])){
                    return country[0];
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "0";
    }

    public String getBackLight(String id){
        try (BufferedReader br = new BufferedReader(new FileReader("lampy tylne.csv"))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] country = line.split(cvsSplitBy);
                if(id.equals(country[1])){
                    return country[0];
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "0";
    }
    public String getMirrosPrice(String id){
        try (BufferedReader br = new BufferedReader(new FileReader("lusterka.csv"))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] country = line.split(cvsSplitBy);
                if(id.equals(country[1])){
                    return country[0];
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "0";
    }

    public String getFrontFenderPrice(String id){
        try (BufferedReader br = new BufferedReader(new FileReader("blotniki.csv"))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] country = line.split(cvsSplitBy);
                if(id.equals(country[1])){
                    return country[0];
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "0";
    }

}

