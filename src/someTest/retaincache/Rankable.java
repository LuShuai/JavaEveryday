package someTest.retaincache;

/**
 * Created by shuailu on 5/27/16.
 */
/*
 * For reference, here are the Rankable and DataSource interfaces.
 * You do not need to implement them, and should not make assumptions
 * about their implementations.
 */

public interface Rankable {

    /**
     * Returns the Rank of this object, using some algorithm and potentially the internal state of the Rankable.
     */
    long getRank();
}
