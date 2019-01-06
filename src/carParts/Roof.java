package carParts;

public class Roof extends Parts{
    @Override
    public void doValuation(Car car) {
        double workType=0;
        switch(car.getType()){
            case"hatchback":
                painting= (float) (0.7*paintingBase+0.7*literOfPaint);
                break;
            case"sedan":
                painting= (float) (0.75*paintingBase+0.75*literOfPaint);
                workType=0.1;
                break;
            case"kombi":
                painting= (float) (0.8*paintingBase+0.8*literOfPaint);
                workType=0.2;
                break;
        }

        if (isDented) {
            if (lessThaTwoHeands) {
                workPrice= (float) ((3.5+workType)*priceForOneManHour);

            } else if (moreThanTwoHeands) {
                workPrice= (float) ((4.5+workType)*priceForOneManHour);
            }
            else if(moreThanThreeHands){
                workPrice= (float) ((5.5+workType)*priceForOneManHour);
            }
        } else if (isScratched) {
            workPrice = (float) ((2.5+workType) * priceForOneManHour);
        }
    }
}
