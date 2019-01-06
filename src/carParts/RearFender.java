package carParts;

public class RearFender extends Parts {


    public RearFender (){
    super();
    }
    @Override
    public void doValuation(Car car) {
        double workType=0;
        switch(car.getType()){
            case"hatchback":
                painting= (float) (0.6*paintingBase+0.6*literOfPaint);
                break;
            case"sedan":
                painting= (float) (0.65*paintingBase+0.65*literOfPaint);
                workType=0.1;
                break;
            case"kombi":
                painting= (float) (0.7*paintingBase+0.7*literOfPaint);
                workType=0.2;
                break;
                default:
                    painting= (float) (0.6*paintingBase+0.6*literOfPaint);
                    break;
        }

        if (isBroken) {
            workPrice= (float) ((4.6+workType)*priceForOneManHour);
        } else if (isDented) {
            if (lessThaTwoHeands) {
                workPrice= (float) ((2.5+workType)*priceForOneManHour);

            } else if (moreThanTwoHeands) {
                workPrice= (float) ((3.6+workType)*priceForOneManHour);
            }
            else if(moreThanThreeHands){
                workPrice= (float) ((4.6+workType)*priceForOneManHour);
            }
        } else if (isScratched) {
            workPrice = (float) ((1.6+workType) * priceForOneManHour);
        }
    }

}
