package sample;

abstract public class Parts {
    final protected float priceForOneManHour = 73;
    final protected float literOfPaint = 160;
    final protected float paintingBase = 150;
    protected float painting, workPrice, partPrice;
    protected boolean isFront, isBack, isDented, isBroken, isScratched, isLeft, isRight, lessThaTwoHeands, moreThanTwoHeands, moreThanThreeHands;

    public boolean isScratched(boolean isScratech) {
        return isScratched;
    }

    public void setScratch(boolean scratch) {
        isScratched = scratch;
    }

    abstract void doValuation(Car car);

    public Parts() {
        isScratched = false;
        isBack=false;
        isFront=false;
        isDented=false;
        isBroken=false;
        isLeft=false;
        isRight=false;
        painting = 0;
        workPrice = 0;
        partPrice = 0;
    }

    public float getPriceForOneManHour() {
        return priceForOneManHour;
    }

    public float getLiterOfPaint() {
        return literOfPaint;
    }

    public float getPaintingBase() {
        return paintingBase;
    }

    public float getPainting() {
        return painting;
    }

    public void setPainting(float painting) {
        this.painting = painting;
    }

    public float getWorkPrice() {
        return workPrice;
    }

    public void setWorkPrice(float workPrice) {
        this.workPrice = workPrice;
    }

    public float getPartPrice() {
        return partPrice;
    }

    public void setPartPrice(float partPrice) {
        this.partPrice = partPrice;
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

    public boolean isScratched() {
        return isScratched;
    }

    public void setScratched(boolean scratched) {
        isScratched = scratched;
    }

    public boolean isLeft() {
        return isLeft;
    }

    public void setLeft(boolean left) {
        isLeft = left;
    }

    public boolean isIsRight() {
        return isRight;
    }

    public void setIsRight(boolean istRight) {
        this.isRight = istRight;
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

    public boolean isRight() {
        return isRight;
    }

    public void setRight(boolean right) {
        isRight = right;
    }

    public boolean isMoreThanThreeHands() {
        return moreThanThreeHands;
    }

    public void setMoreThanThreeHands(boolean moreThanThreeHands) {
        this.moreThanThreeHands = moreThanThreeHands;
    }
}
