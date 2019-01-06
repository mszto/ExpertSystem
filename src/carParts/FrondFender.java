package carParts;

public class FrondFender extends Parts {

    public FrondFender() {
        super();
    }

    @Override
    public void doValuation(Car car) {
        painting= (float) (0.6*paintingBase+0.6*literOfPaint);
        if (isBroken) {

            workPrice= (float) (1.7*priceForOneManHour);
        } else if (isDented) {
            if (lessThaTwoHeands) {
                workPrice= (float) (2.5*priceForOneManHour);

            } else if (moreThanTwoHeands) {
                workPrice= (float) (1.7*priceForOneManHour);
            }
        } else if (isScratched) {
            workPrice = (float) (1.5 * priceForOneManHour);
        }
    }

}
