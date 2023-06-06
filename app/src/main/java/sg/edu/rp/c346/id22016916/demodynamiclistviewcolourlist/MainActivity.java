package sg.edu.rp.c346.id22016916.demodynamiclistviewcolourlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.sql.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etElement, etIndexElement;
    Button btnAdd, btnRmv, btnUpd;
    ListView lvColour;

    ArrayList<String> alColour;
    ArrayAdapter<String> aaColour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etElement = findViewById(R.id.editTextColour);
        etIndexElement = findViewById(R.id.editTextIndex);
        btnAdd = findViewById(R.id.buttonAddItem);
        btnRmv = findViewById(R.id.buttonRemoveItem);
        btnUpd = findViewById(R.id.buttonUpdateItem);

        lvColour = findViewById(R.id.listViewColour);

        alColour = new ArrayList<>();
        alColour.add("Red");
        alColour.add("Orange");

        aaColour = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alColour);

        lvColour.setAdapter(aaColour);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String colour = etElement.getText().toString();
                int pos = Integer.parseInt(etIndexElement.getText().toString());
                alColour.add(pos - 1, colour);
                aaColour.notifyDataSetChanged();
            }
        });

        lvColour.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String colourClicked = alColour.get(position);
                Toast.makeText(MainActivity.this, colourClicked, Toast.LENGTH_SHORT).show();;
            }
        });

        btnRmv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = Integer.parseInt(etIndexElement.getText().toString());
                alColour.remove(pos - 1);
                aaColour.notifyDataSetChanged();
            }
        });

        btnUpd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String colour = etElement.getText().toString();
                int pos = Integer.parseInt(etIndexElement.getText().toString());
                alColour.set(pos - 1, colour);
                aaColour.notifyDataSetChanged();
            }
        });
    }
}