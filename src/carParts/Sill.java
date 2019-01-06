package carParts;

public class Sill extends Parts {
    @Override
    public void doValuation(Car car) {
        double workType=0;
        switch(car.getType()){
            case"hatchback":
                painting= (float) (0.4*paintingBase+0.4*literOfPaint);
                break;
            case"sedan":
                painting= (float) (0.45*paintingBase+0.45*literOfPaint);
                workType=0.1;
                break;
            case"kombi":
                painting= (float) (0.5*paintingBase+0.5*literOfPaint);
                workType=0.2;
                break;
        }

        if (isScratched) {
            workPrice= (float) ((1.5+workType)*priceForOneManHour);
        } else if (isDented) {
            if (lessThaTwoHeands) {
                workPrice= (float) ((2.5+workType)*priceForOneManHour);

            } else if (moreThanTwoHeands) {
                workPrice= (float) ((3.5+workType)*priceForOneManHour);
            }
            else if(moreThanThreeHands){
                workPrice= (float) ((4.5+workType)*priceForOneManHour);
            }
        }else if(isBroken){
            workPrice= (float) ((4.5+workType)*priceForOneManHour);
        }
    }
}
