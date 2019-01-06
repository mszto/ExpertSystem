package carParts;

public class FrontDoor extends Parts {

    @Override
    public void doValuation(Car car) {
        painting= (float) ((0.67 * paintingBase) + (0.67 * literOfPaint));
        if (isScratched) {
            workPrice= (float) (1.6*priceForOneManHour);
        } else if (isDented) {
            if (lessThaTwoHeands) {
                workPrice= (float) (2.6*priceForOneManHour);

            } else if (moreThanTwoHeands) {
                workPrice= (float) (3.6*priceForOneManHour);
            }
            else if(moreThanThreeHands){
                workPrice= (float) (4.6*priceForOneManHour);
            }
        }
    }


}
