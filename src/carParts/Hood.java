package carParts;

public class Hood extends Parts {


    @Override
    public void doValuation(Car car) {
        painting= (float) ((0.8 * paintingBase) + (0.8 * literOfPaint));

        if (isDented) {
            if (lessThaTwoHeands) {
                workPrice= (float) ((2.8)*priceForOneManHour);

            } else if (moreThanTwoHeands) {
                workPrice= (float) ((3.8)*priceForOneManHour);
            }
            else if(moreThanThreeHands){
                workPrice= (float) ((4.8)*priceForOneManHour);
            }
        } else if (isScratched) {
            workPrice = (float) (1.8 * priceForOneManHour);
        }
    }
}
