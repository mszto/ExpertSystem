package sample;

public class Bumper extends Parts {


    @Override
    void doValuation(Car car) {
        if (isBroken) {
            workPrice = (float) (1.5 * priceForOneManHour);
            painting = (float) (0.2 * paintingBase + 0.3 * literOfPaint);
        } else if (isScratched || isDented) {
            if (isDented) {
                workPrice = 2 * priceForOneManHour;
            } else {
                workPrice = (float) (1.5 * priceForOneManHour);
            }
            painting = (float) (0.67 * paintingBase + 0.67 * literOfPaint);
        }
    }

    public Bumper() {
        super();
    }



}
