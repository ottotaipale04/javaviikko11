package com.example.viikko11;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private Button addContactActivity, sortAlpabetically, sortByGroup;
    private RecyclerView recyclerView;
    private ContactListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.GroupText), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        addContactActivity = findViewById(R.id.AddContactActivityButton);
        recyclerView = findViewById(R.id.ListContactsRV);
        sortAlpabetically = findViewById(R.id.SortAlphabeticallyButton);
        sortByGroup = findViewById(R.id.SortByGroupButton);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new ContactListAdapter(getApplicationContext(), ContactStorage.getInstance().getContacts());
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    public void switchToAddContactActivity(View view) {
        Intent intent = new Intent(this, AddContactActivity.class);
        startActivity(intent);
    }

    public void sortByGroupButton(View view) {
        ContactStorage.getInstance().sortByGroup();

        adapter.notifyDataSetChanged();
        recyclerView.scrollToPosition(0);
    }

    public void sortAlphabeticallyButton(View view) {
        ContactStorage.getInstance().sortAlphabetically();

        adapter.notifyDataSetChanged();
        recyclerView.scrollToPosition(0);
    }
}