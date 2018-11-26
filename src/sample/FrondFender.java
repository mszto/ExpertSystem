package sample;

public class FrondFender extends Parts {

    public FrondFender() {
        super();
    }

    @Override
    void doValuation(Car car) {
        if (isBroken) {
            painting= (float) (0.6*paintingBase+0.6*literOfPaint);
            workPrice= (float) (2.5*priceForOneManHour);
        } else if (isDented) {
            if (lessThaTwoHeands) {
                workPrice= (float) (2.5*priceForOneManHour);
                painting= (float) (0.6*paintingBase+0.6*literOfPaint);

            } else if (moreThanTwoHeands) {
                workPrice= (float) (2.5*priceForOneManHour);
                painting= (float) (0.6*paintingBase+0.6*literOfPaint);
            }
        } else if (isScratched) {
            workPrice = (float) (1.5 * priceForOneManHour);
            painting = (float) (0.3 * paintingBase + 0.3 * literOfPaint);
        }
    }

}
