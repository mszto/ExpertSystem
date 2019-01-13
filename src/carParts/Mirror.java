package carParts;

import Datebase.CsvReader;

public class Mirror extends Parts {
    @Override
    public void doValuation(Car car) {
        painting= (float) ((0.3 * paintingBase) + (0.3 * literOfPaint));
        if (isScratched) {
            workPrice= (float) (0.5*priceForOneManHour);
        } else if (isBroken) {
            workPrice= (float) (1.3*priceForOneManHour);
            partPrice= Float.parseFloat(new CsvReader().getMirrosPrice(car.getId()));
        }
    }
}
