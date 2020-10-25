package pt.ipbeja.pdm.lists;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ScrollViewListActivity extends AppCompatActivity {

    private EditText itemCountInput;
    private LinearLayout content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_view_list);
        this.itemCountInput = findViewById(R.id.item_count_input);
        this.content = findViewById(R.id.content_wrapper);


    }

    public void onRefresh(View view) {
        content.removeAllViews();

        String text = itemCountInput.getText().toString();
        if(!text.isEmpty()) {
            int count = Integer.parseInt(text);
            addViews(count);
        }
    }

    private void addViews(int count) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            TextView tv = new TextView(this);
            tv.setText("TextView #" + i);
            tv.setPadding(10, 10 ,10 ,10);
            content.addView(tv);
        }
        long elapsed = System.currentTimeMillis() - start;

        Toast.makeText(this, String.format("%dms to create %d TextViews", elapsed, count), Toast.LENGTH_SHORT).show();
    }
}