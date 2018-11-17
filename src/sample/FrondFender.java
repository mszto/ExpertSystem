package sample;

public class FrondFender extends Parts {
    private boolean isLeft;
    private boolean isRight;
    private boolean isBroken;
    private boolean isScratch;
    private boolean isDent;
    private boolean oneHeand;
    private boolean oneToTwoHeands;
    private boolean moreThanThreeHeands;

    @Override
    void doValuation() {
        if (isBroken) {

        } else if (isDent) {
            if (oneHeand) {

            } else if (oneToTwoHeands) {

            } else {

            }
        } else if (isScratch) {
            workPrice = (float) (1.5 * priceForOneManHour);
            painting = (float) (0.3 * paintingBase + 0.3 * literOfPaint);
        }
    }
}
