package cs134.miracosta.edu.inandout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.NumberFormat;
import java.util.Locale;

import cs134.miracosta.edu.inandout.model.Order;

public class OrderActivity extends Activity {

    // Declare reference variables to action widgets.
    private EditText doubleDoubleEditText;
    private EditText cheesesburgerEditText;
    private EditText frenchFriesEditText;
    private EditText shakesEditText;
    private EditText smallEditText;
    private EditText mediumEditText;
    private EditText largeEditText;
    private Button placeOrderButton;

    // Declare reference variable to the model;
    private Order order; // Reference to the model CarLoan.

    // Make number formatter for currency.
    NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.getDefault());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        // Connect reference variables to action widgets.
        doubleDoubleEditText = findViewById(R.id.doubleDoubleEditText);
        cheesesburgerEditText = findViewById(R.id.cheesesburgerEditText);
        frenchFriesEditText = findViewById(R.id.frenchFriesEditText);
        shakesEditText = findViewById(R.id.shakesEditText);
        smallEditText = findViewById(R.id.smallEditText);
        mediumEditText = findViewById(R.id.mediumEditText);
        largeEditText = findViewById(R.id.largeEditText);
    }

    public void onClickPlaceOrder(View v) {
        // Extract the data from the EditTexts.
        int doubleDoubles = Integer.parseInt(doubleDoubleEditText.getText().toString());
        int cheeseburgers = Integer.parseInt(cheesesburgerEditText.getText().toString());
        int fries = Integer.parseInt(frenchFriesEditText.getText().toString());
        int shakes = Integer.parseInt(shakesEditText.getText().toString());
        int smallDrinks = Integer.parseInt(smallEditText.getText().toString());
        int mediumDrinks = Integer.parseInt(mediumEditText.getText().toString());
        int largeDrinks = Integer.parseInt(largeEditText.getText().toString());

        // Update the model CarLoan.
        order.setDoubleDoubles(doubleDoubles);
        order.setCheeseburgers(cheeseburgers);
        order.setFrenchFries(fries);
        order.setShakes(shakes);
        order.setSmallDrinks(smallDrinks);
        order.setMediumDrinks(mediumDrinks);
        order.setLargeDrinks(largeDrinks);

        // Create a new Intent to share the data with LoadSummaryActivity.
        Intent loanSummaryIntent = new Intent(this, SummaryActivity.class);

        // Share the data.
        loanSummaryIntent.putExtra(SummaryActivity.INTENT_TOTAL, currency.format(order.calculateTotal()));
        loanSummaryIntent.putExtra(SummaryActivity.INTENT_ITEMS, order.getNumberItemsOrdered());
        loanSummaryIntent.putExtra(SummaryActivity.INTENT_SUBTOTAL, currency.format(order.calculateSubtotal()));
        loanSummaryIntent.putExtra(SummaryActivity.INTENT_TAX, currency.format(order.calculateTax()));

        // Start the LoadSummaryActivity.
        startActivity(loanSummaryIntent);

    }
}
