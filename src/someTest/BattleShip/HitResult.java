package someTest.BattleShip;

/**
 * Created by shuailu on 5/5/16.
 */
public enum HitResult {
    HIT ("H"),
    MISS("M"),
    SUNK("S");

    String text;
    HitResult(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
