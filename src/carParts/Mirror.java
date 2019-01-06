package carParts;

public class Mirror extends Parts {
    @Override
    public void doValuation(Car car) {
        painting= (float) ((0.67 * paintingBase) + (0.67 * literOfPaint));
        if (isScratched) {
            workPrice= (float) (0.5*priceForOneManHour);
        } else if (isBroken) {
            workPrice= (float) (1.3*priceForOneManHour);
        }
    }
}
