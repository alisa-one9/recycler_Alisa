package com.example.recycler_alisa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<Rec> list = new ArrayList<>();
    private MainAdapter adapter;
    private EditText editText;
    private Button button;
    private String KEY = "key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        recyclerView = findViewById(R.id.recyclerView);
        editText = findViewById(R.id.etText);
        button = findViewById(R.id.btn);
        button.setOnClickListener(v -> {
            list.add(new Rec(editText.getText().toString()));
            adapter.notifyDataSetChanged();
            editText.setText("");
        });
        adapter = new MainAdapter(list, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        new ItemTouchHelper(simpleCallback).attachToRecyclerView(recyclerView);
    }

    ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(
            ItemTouchHelper.UP | ItemTouchHelper.DOWN,

            ItemTouchHelper.RIGHT | ItemTouchHelper.LEFT

    ) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView,
                              @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {

            int positionDrag = viewHolder.getAdapterPosition();
            int positionTarget = target.getAdapterPosition();

            Collections.swap(adapter.list, positionDrag, positionTarget);
            adapter.notifyItemMoved(positionDrag, positionTarget);

            return true;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            adapter.list.remove(viewHolder.getAdapterPosition());
            adapter.notifyItemRemoved(viewHolder.getAdapterPosition());
        }
    };

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList(KEY,list);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        list.addAll(savedInstanceState.getParcelableArrayList(KEY));
    }
}