package carParts;

public class TailGate extends Parts {
    @Override
    public void doValuation(Car car) {
        double workType=0;
        switch(car.getType()){
            case"hatchback":
                painting= (float) (0.5*paintingBase+0.5*literOfPaint);
                break;
            case"sedan":
                painting= (float) (0.65*paintingBase+0.65*literOfPaint);
                workType=1.4;
                break;
            case"kombi":
                painting= (float) (0.5*paintingBase+0.5*literOfPaint);
                workType=0;
                break;
            default:
                painting= (float) (0.5*paintingBase+0.5*literOfPaint);
                break;
        }

        if (isDented) {
            if (lessThaTwoHeands) {
                workPrice= (float) ((1.5+workType)*priceForOneManHour);

            } else if (moreThanTwoHeands) {
                workPrice= (float) ((2.5+workType)*priceForOneManHour);
            }
            else if(moreThanThreeHands){
                workPrice= (float) ((3.5+workType)*priceForOneManHour);
            }
        } else if (isScratched) {
            workPrice = (float) ((0.5+workType) * priceForOneManHour);
        }
    }
}
