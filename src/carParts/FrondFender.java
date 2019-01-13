package carParts;

import Datebase.CsvReader;

public class FrondFender extends Parts {

    public FrondFender() {
        super();
    }

    @Override
    public void doValuation(Car car) {
        painting= (float) (0.6*paintingBase+0.6*literOfPaint);
        if (isBroken) {
            partPrice= Float.parseFloat(new CsvReader().getFrontFenderPrice(car.getId()));
            workPrice= (float) (1.7*priceForOneManHour);
        } else if (isDented) {
            if (lessThaTwoHeands) {
                workPrice= (float) (2.5*priceForOneManHour);

            } else if (moreThanTwoHeands) {
                workPrice= (float) (1.7*priceForOneManHour);
                partPrice= Float.parseFloat(new CsvReader().getFrontFenderPrice(car.getId()));
            }
        } else if (isScratched) {
            workPrice = (float) (1.5 * priceForOneManHour);
        }
    }

}
