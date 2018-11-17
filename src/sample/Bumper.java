package sample;

public class Bumper extends Parts {

    private boolean isFront;
    private boolean isBack;
    private boolean isDented;
    private boolean isBroken;
    private boolean isScrachet;

    @Override
    void doValuation(Car car) {
        if (isBroken) {
            workPrice = (float) (1.5 * priceForOneManHour);
            painting = (float) (0.2 * paintingBase + 0.3 * literOfPaint);
        } else if (isScrachet() || isDented()) {
            if (isDented()) {
                workPrice = 2 * priceForOneManHour;
            } else {
                workPrice = (float) (1.5 * priceForOneManHour);
            }
            painting = (float) (0.67 * paintingBase + 0.67 * literOfPaint);
        }
    }

    public Bumper() {
        super();
        this.isBack = false;
        this.isBroken = false;
        this.isFront = false;
        this.isScrachet = false;
        this.isDented = false;
    }

    public boolean isFront() {
        return isFront;
    }

    public void setFront(boolean front) {
        isFront = front;
    }

    public boolean isBack() {
        return isBack;
    }

    public void setBack(boolean back) {
        isBack = back;
    }

    public boolean isDented() {
        return isDented;
    }

    public void setDented(boolean dented) {
        isDented = dented;
    }

    public boolean isBroken() {
        return isBroken;
    }

    public void setBroken(boolean broken) {
        isBroken = broken;
    }

    public boolean isScrachet() {
        return isScrachet;
    }

    public void setScrachet(boolean scrachet) {
        isScrachet = scrachet;
    }


}
