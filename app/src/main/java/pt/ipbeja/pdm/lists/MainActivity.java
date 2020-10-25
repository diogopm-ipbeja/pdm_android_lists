package pt.ipbeja.pdm.lists;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button scrollViewBtn = findViewById(R.id.scrollview_btn);
        Button recyclerViewBtn = findViewById(R.id.recyclerview_btn);

        scrollViewBtn.setOnClickListener(v -> startActivity(new Intent(this, ScrollViewListActivity.class)));

        recyclerViewBtn.setOnClickListener(v -> startActivity(new Intent(this, RecyclerViewListActivity.class)));

        scrollViewBtn.setScaleX(0);
        scrollViewBtn.setScaleY(0);
        recyclerViewBtn.setScaleX(0);
        recyclerViewBtn.setScaleY(0);
        scrollViewBtn.animate().scaleX(1).scaleY(1).setDuration(500).setStartDelay(100).setInterpolator(new OvershootInterpolator()).start();
        recyclerViewBtn.animate().scaleX(1).scaleY(1).setDuration(450).setStartDelay(200).setInterpolator(new OvershootInterpolator()).start();

    }
}