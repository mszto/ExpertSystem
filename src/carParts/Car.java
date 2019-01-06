package carParts;

public class Car {

    private String carMake;
    private String carModel;
    private String carModelYear;
    private String Type;

    public Car(){

    }

    public Car(String carMake, String carModel, String carYear){
        this.carMake=carMake;
        this.carModel=carModel;
        this.carModelYear=carYear;
    }
    public String getCarMake() {
        return carMake;
    }

    public void setCarMake(String carMake) {
        this.carMake = carMake;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarModelYear() {
        return carModelYear;
    }

    public void setCarModelYear(String carModelYear) {
        this.carModelYear = carModelYear;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        if(type =="sedan" || type=="kombi" || type== "hatchback") {
            Type = type;
        }else{
            type="sedan";
        }
    }



}
