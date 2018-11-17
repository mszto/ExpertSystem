package sample;

public class FrondFender extends Parts {
    private boolean isLeft;
    private boolean isRight;
    private boolean isBroken;
    private boolean isScratch;
    private boolean isDent;
    private boolean lessThaTwoHeands;
    private boolean moreThanTwoHeands;

    public FrondFender() {
        isLeft=false;
        isRight=false;
        isBroken=false;
        isScratch=false;
        isDent=false;
        lessThaTwoHeands=false;
        moreThanTwoHeands=false;
    }

    @Override
    void doValuation(Car car) {
        if (isBroken) {
            painting= (float) (0.6*paintingBase+0.6*literOfPaint);
            workPrice= (float) (2.5*priceForOneManHour);
        } else if (isDent) {
            if (lessThaTwoHeands) {
                workPrice= (float) (2.5*priceForOneManHour);
                painting= (float) (0.6*paintingBase+0.6*literOfPaint);

            } else if (moreThanTwoHeands) {
                workPrice= (float) (2.5*priceForOneManHour);
                painting= (float) (0.6*paintingBase+0.6*literOfPaint);
            }
        } else if (isScratch) {
            workPrice = (float) (1.5 * priceForOneManHour);
            painting = (float) (0.3 * paintingBase + 0.3 * literOfPaint);
        }
    }

    public boolean isLeft() {
        return isLeft;
    }

    public void setLeft(boolean left) {
        isLeft = left;
    }

    public boolean isRight() {
        return isRight;
    }

    public void setRight(boolean right) {
        isRight = right;
    }

    public boolean isBroken() {
        return isBroken;
    }

    public void setBroken(boolean broken) {
        isBroken = broken;
    }

    @Override
    public boolean isScratch() {
        return isScratch;
    }

    @Override
    public void setScratch(boolean scratch) {
        isScratch = scratch;
    }

    public boolean isDent() {
        return isDent;
    }

    public void setDent(boolean dent) {
        isDent = dent;
    }

    public boolean isLessThaTwoHeands() {
        return lessThaTwoHeands;
    }

    public void setLessThaTwoHeands(boolean lessThaTwoHeands) {
        this.lessThaTwoHeands = lessThaTwoHeands;
    }

    public boolean isMoreThanTwoHeands() {
        return moreThanTwoHeands;
    }

    public void setMoreThanTwoHeands(boolean moreThanTwoHeands) {
        this.moreThanTwoHeands = moreThanTwoHeands;
    }
}
