package cs134.miracosta.edu.inandout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SummaryActivity extends Activity {

    // Declare reference variables to action widgets.
    private TextView orderTotalTextView;
    private TextView itemsOrderedTextView;
    private TextView subtotalTextView;
    private TextView taxTextView;

    // Declare Intent value name constants.
    public static final String INTENT_TOTAL = "total";
    public static final String INTENT_ITEMS = "items";
    public static final String INTENT_SUBTOTAL = "subtotal";
    public static final String INTENT_TAX = "tax";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        // Connect reference variables to action widgets.
        orderTotalTextView = findViewById(R.id.orderTotalTextView);
        itemsOrderedTextView = findViewById(R.id.itemsOrderedTextView);
        subtotalTextView = findViewById(R.id.subtotalTextView);
        taxTextView = findViewById(R.id.taxTextView);

        // Receive the Intent from OrderActivity.
        Intent intent = getIntent();

        // Populate all the TextViews.
        orderTotalTextView.setText(R.string.items_ordered);
        orderTotalTextView.append(" ");
        orderTotalTextView.append(intent.getStringExtra(INTENT_TOTAL));
//        orderTotalTextView.setText(intent.getStringExtra(INTENT_TOTAL));
        itemsOrderedTextView.setText(intent.getStringExtra(INTENT_ITEMS));
        subtotalTextView.setText(intent.getStringExtra(INTENT_SUBTOTAL));
        taxTextView.setText(intent.getStringExtra(INTENT_TAX));
    }

    public void closeActivity(View v) {
        finish();
    }
}
