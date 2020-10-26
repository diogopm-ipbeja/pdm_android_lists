package pt.ipbeja.pdm.lists;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Apenas para demonstração da ListView. Não deve usar este tipo de lista mas sim a RecyclerView
 */

public class ListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);


        List<String> dummyData = new ArrayList<>();
        for (int i = 0; i < 1_000_000; i++) {
            dummyData.add("Value #"+i);
        }

        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(new MyAdapter(dummyData));


    }

    private class MyAdapter extends BaseAdapter {

        private final List<String> data;

        public MyAdapter(List<String> data) {
            this.data = data;
        }

        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public Object getItem(int position) {
            return data.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position; // Normalmente utilizar-se-ia um ID mas aqui vou só usar a própria posição
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(parent.getContext()).
                        inflate(R.layout.list_view_item, parent, false);
            }

            // Obter o item para dada posição (sabemos ser uma String)
            String currentItem = (String) getItem(position);

            // Vamos procurar a TextView dentro do layout
            TextView tv = convertView.findViewById(R.id.value);
            // E colocar a String
            tv.setText(currentItem);

            // Finalmente, devolvemos a View preenchida com a informação
            return convertView;
        }
    }
}