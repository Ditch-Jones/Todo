package com.example.joshi.todo;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class AddTodoActivity extends Activity {
    public final static String TITLEKEY = "TITLE";
    public final static String DESCRKEY = "DESCRIPTION";
    public final static String PRIORKEY = "PRIORITY";

    private ArrayAdapter<CharSequence> adapter = null;
    private EditText title, description;
    private Spinner priority;
    private Button btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_todo);

        btnOk = findViewById(R.id.btnOk);
        title = findViewById(R.id.title);
        priority = findViewById(R.id.spinPriori);
        description = findViewById(R.id.description);
        adapter = ArrayAdapter.createFromResource(this,R.array.priorities,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        priority.setAdapter(adapter);



        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!title.getText().toString().isEmpty() && !description.getText().toString().isEmpty()){
                    Intent intent = new Intent(AddTodoActivity.this,MainActivity.class);
                    intent.putExtra(TITLEKEY,title.getText().toString());
                    intent.putExtra(DESCRKEY,description.getText().toString());
                    intent.putExtra(PRIORKEY,priority.getSelectedItem().toString());
                    startActivity(intent);
                }
            }
        });

    }
}
