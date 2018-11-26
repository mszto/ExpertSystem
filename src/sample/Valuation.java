package sample;

public class Valuation {
    final private int priceForOneManHour = 60;
    final private int literOfPaint = 160;
    final private int paintingBase = 150;
    private float painting, workPrice, partPrice;


    public void doValuation(Bumper bumper) {
        if (bumper.isBroken()) {
            workPrice = (float) (1.5 * priceForOneManHour);
            painting = painting = (float) (0.2 * paintingBase + 0.3 * literOfPaint);
        } else if (bumper.isScratched() || bumper.isDented()) {
            if (bumper.isDented()) {
                workPrice = 2 * priceForOneManHour;
            } else {
                workPrice = (float) (1.5 * priceForOneManHour);
            }
            painting = (float) (0.2 * paintingBase + 0.3 * literOfPaint);
        }
    }

}
