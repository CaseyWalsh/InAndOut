package cs134.miracosta.edu.inandout.model;
/**
 * The Order class represents the numbers of items in an order, and calculates costs.
 *
 * @author Casey Walsh
 * @version 1.0
 */
public class Order {
    // Instance variable declaration.
    private int mDoubleDoubles;
    private int mCheeseburgers;
    private int mFrenchFries;
    private int mShakes;
    private int mSmallDrinks;
    private int mMediumDrinks;
    private int mLargeDrinks;

    // Local constants.
    private static double PRICE_DOUBLE_DOUBLE = 3.60;
    private static double PRICE_CHEESEBURGER = 2.15;
    private static double PRICE_FRENCH_FRIES = 1.65;
    private static double PRICE_SHAKE = 2.20;
    private static double PRICE_SMALL_DRINK = 1.45;
    private static double PRICE_MEDIUM_DRINK = 1.55;
    private static double PRICE_LARGE_DRINK = 1.75;
    private static double TAX_RATE = 0.08;

    public Order() {
        mDoubleDoubles = 0;
        mCheeseburgers = 0;
        mFrenchFries = 0;
        mShakes = 0;
        mSmallDrinks = 0;
        mMediumDrinks = 0;
        mLargeDrinks = 0;
    }

    /**
     *
     * @return Number of Double Doubles ordered.
     */
    public int getDoubleDoubles() { return mDoubleDoubles; }
    /**
     *
     * @return Number of Cheeseburgers ordered.
     */
    public int getCheeseburgers() { return mCheeseburgers; }
    /**
     *
     * @return Number of French Fries ordered.
     */
    public int getFrenchFries()   { return mFrenchFries;   }
    /**
     *
     * @return Number of Shakes ordered.
     */
    public int getShakes()        { return mShakes;        }
    /**
     *
     * @return Number of Small Drinks  ordered.
     */
    public int getSmallDrinks()   { return mSmallDrinks;   }
    /**
     *
     * @return Number of Medium Drinks ordered.
     */
    public int getMediumDrinks()  { return mMediumDrinks;  }
    /**
     *
     * @return Number of Large Drinks ordered.
     */
    public int getLargeDrinks()   { return mLargeDrinks;   }
    public void setDoubleDoubles(int doubleDoubles) { mDoubleDoubles = doubleDoubles; }
    public void setCheeseburgers(int cheeseburgers) { mCheeseburgers = cheeseburgers; }
    public void setFrenchFries(int frenchFries)     { mFrenchFries = frenchFries;     }
    public void setShakes(int shakes)               { mShakes = shakes;               }
    public void setSmallDrinks(int smallDrinks)     { mSmallDrinks = smallDrinks;     }
    public void setMediumDrinks(int mediumDrinks)   { mMediumDrinks = mediumDrinks;   }
    public void setLargeDrinks(int largeDrinks)     { mLargeDrinks = largeDrinks;     }

    public int getNumberItemsOrdered() {
        return mDoubleDoubles + mCheeseburgers + mFrenchFries + mShakes
                + mSmallDrinks + mMediumDrinks + mLargeDrinks;
    }

    public double calculateSubtotal() {
        return mDoubleDoubles * PRICE_DOUBLE_DOUBLE
                + mCheeseburgers * PRICE_CHEESEBURGER
                + mFrenchFries * PRICE_FRENCH_FRIES
                + mShakes * PRICE_SHAKE
                + mSmallDrinks * PRICE_SMALL_DRINK
                + mMediumDrinks * PRICE_MEDIUM_DRINK
                + mLargeDrinks * PRICE_LARGE_DRINK;
    }

    public double calculateTax() {
        return calculateSubtotal() * TAX_RATE;
    }

    public double calculateTotal() {
        return calculateSubtotal() * (1.0 + TAX_RATE);
    }
}
