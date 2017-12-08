package com.example.joshi.todo;


import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;


import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import com.example.joshi.todo.Model.TodoItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ListActivity {
    private Button btnNeu;
    private List<TodoItem> todoList;
    private ArrayAdapter<TodoItem> adapter = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String title, description, priority;
        todoList = new ArrayList<>();

        btnNeu = findViewById(R.id.btnAddTodo);
        btnNeu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, AddTodoActivity.class);
                startActivity(intent);
            }
        });

        Intent intent = getIntent();
        title = intent.getStringExtra(AddTodoActivity.TITLEKEY);
        description = intent.getStringExtra(AddTodoActivity.DESCRKEY);
        priority = intent.getStringExtra(AddTodoActivity.PRIORKEY);

        TodoItem ti = new TodoItem(title,description,priority);
        todoList.add(ti);

        adapter = new ArrayAdapter<TodoItem>(this, android.R.layout.simple_list_item_1);
        if(title != null)
        for(int i = 0; i < todoList.size(); i++){
            Context context = getApplicationContext();
            Toast.makeText(context, title+" "+description+" "+
                    priority, Toast.LENGTH_LONG).show();
            adapter.add(todoList.get(i));
        }
        setListAdapter(adapter);
        setTitle(R.string.app_name);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.settings_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.settings){
            Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
    }
}
