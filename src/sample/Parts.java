package sample;

abstract public class Parts {
    final protected float priceForOneManHour = 73;
    final protected float literOfPaint = 160;
    final protected float paintingBase = 150;
    protected float painting, workPrice, partPrice;

    private boolean isScratch=false;

    public boolean isScratch() {
        return isScratch;
    }

    public void setScratch(boolean scratch) {
        isScratch = scratch;
    }

    abstract void doValuation(Car car);

    public Parts(){
        painting=0;
        workPrice=0;
        partPrice=0;
    }

}
