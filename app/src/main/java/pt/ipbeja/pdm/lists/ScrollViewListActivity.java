package pt.ipbeja.pdm.lists;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;


/**
 * Apenas para demonstrar a razão porque NÃO se utiliza ScrollView para listas.
 */
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
        // Apenas para demonstrar que a instanciação imediata de muitas Views pode ser bastante
        // prejudicial à experiência do utilizador.
        // Experimente colocar 50000 na EditText e pressionar Refresh.
        // A instanciação de 50000 TextViews pode demorar alguns segundos e a UI está bloqueada
        // O próprio scroll pode perder a fluídez, porque embora nem todas as TextViews estejam
        // visíveis, todas estão desenhadas e presentes no layout!

        // A ScrollView deve ser utilizada apenas para layouts que podem não caber no ecrã do device

        // Para criar listas deve ser utilizada a RecyclerView (ver RecyclerViewListActivity)

        long start = System.currentTimeMillis();

        for (int i = 0; i < count; i++) {
            TextView tv = new TextView(this);
            tv.setText("TextView #" + i);
            tv.setPadding(16, 16 ,16 ,16);
            content.addView(tv);
        }
        long elapsed = System.currentTimeMillis() - start;

        Toast.makeText(this, String.format(Locale.getDefault(), "%dms to create %d TextViews", elapsed, count), Toast.LENGTH_SHORT).show();
    }
}