package pt.ipbeja.pdm.lists;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_list);

        // A nossa fonte de dados, para exemplo, será apenas uma lista de String
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < 1_000_000; i++) {
            strings.add("Value " + i);
        }

        recyclerView = findViewById(R.id.recycler_view);

        // Temos de instanciar o Adapter e decidi criar um construtor que recebe logo a fonte de dados
        TextAdapter adapter = new TextAdapter(strings);

        // A RecyclerView precisa de um LayoutManager para saber como dispôr os itens
        // Neste caso usei um LayoutManager linear e vertical (por omissão)
        LinearLayoutManager llm = new LinearLayoutManager(this);

        // Só falta colocar os componentes na RecyclerView
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(llm);



    }


    class TextViewHolder extends RecyclerView.ViewHolder {

        private TextView value;

        public TextViewHolder(@NonNull View itemView) {
            // No construtor do ViewHolder apenas fazemos os findViewById. Não colocamos dados.
            super(itemView);
            this.value = itemView.findViewById(R.id.value);
        }
    }

    // TODO Definir o Adapter (extends RecyclerView.Adapter<VH>)

    class TextAdapter extends RecyclerView.Adapter<TextViewHolder> {

        private List<String> data;

        public TextAdapter(List<String> data) {
            this.data = data;
        }

        @NonNull
        @Override
        public TextViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            Log.i("ViewHolder", "New ViewHolder created");
            // Para instanciar uma View a partir do XML, utilizamos o código abaixo. A única coisa que muda é o layout alvo.
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.text_item, parent, false);
            return new TextViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull TextViewHolder holder, int position) {
            // É neste método que colocamos os dados nas Views do ViewHolder.
            String s = data.get(position);
            holder.value.setText(s);
        }

        @Override
        public int getItemCount() {
            return data.size(); // Normalmente apenas temos de devolver o tamanho da lista de dados
        }
    }


}