package entity;

public enum ProductPeriod {
    ONE_WEEK(1),
    ONE_MONTH(2),
    THREE_MONTHS(3);

    private final int lvl;

    ProductPeriod(int lvl) {
        this.lvl = lvl;
    }

    public int getLvl() {
        return lvl;
    }
}
