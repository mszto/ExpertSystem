package carParts;

public class Bumper extends Parts {


    @Override
    public void doValuation(Car car) {
        painting= (float) ((0.67 * paintingBase) + (0.67 * literOfPaint));
        if (isBroken) {
            workPrice = (float) (1.5 * priceForOneManHour);
        } else if (isScratched || isDented) {
            if (isDented) {
                workPrice = 2 * priceForOneManHour;
            } else {
                workPrice = (float) (1.5 * priceForOneManHour);
            }
        }
    }

    public Bumper() {
        super();
    }



}
