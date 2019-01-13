package carParts;

import Datebase.CsvReader;

public class HeadLight extends Parts {
    @Override
    public void doValuation(Car car) {
            workPrice = (float) (0.3 * priceForOneManHour);
            if(isBack){
                partPrice= Float.parseFloat(new CsvReader().getBackLight(car.getId()));
            }else{
                partPrice= Float.parseFloat(new CsvReader().getHeadLight(car.getId()));
            }

    }
}
