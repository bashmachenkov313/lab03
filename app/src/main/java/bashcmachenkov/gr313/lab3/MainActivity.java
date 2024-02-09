package bashcmachenkov.gr313.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner list1;
    Spinner list2;
    EditText EntryText;
    TextView OutText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list1 = findViewById(R.id.list1);
        list2 = findViewById(R.id.list2);
        EntryText = findViewById(R.id.EntryText);
        OutText = findViewById(R.id.OutText);

        ArrayAdapter <String> adp = new <String> ArrayAdapter(this, android.R.layout.simple_list_item_1);
        adp.add("mm");
        adp.add("cm");
        adp.add("m");
        adp.add("km");
        list1.setAdapter(adp);
        list2.setAdapter(adp);
    }

    public void on_click_convert(View v){
        try {
            double from = Double.parseDouble(EntryText.getText().toString());
            String typeFrom = (String) list1.getSelectedItem();
            String typeTo = (String) list2.getSelectedItem();

            double output = 0.0f;

            if (typeFrom.equals("mm")) {
                if (typeTo.equals("mm")) output = from;
                if (typeTo.equals("cm")) output = from * 0.1f;
                if (typeTo.equals("m")) output = from * 0.001f;
                if (typeTo.equals("km")) output = from * 0.000001f;
            }
            if (typeFrom.equals("cm")) {
                if (typeTo.equals("mm")) output = from * 10f;
                if (typeTo.equals("cm")) output = from;
                if (typeTo.equals("m")) output = from * 0.01f;
                if (typeTo.equals("km")) output = from * 0.00001f;
            }
            if (typeFrom.equals("m")) {
                if (typeTo.equals("mm")) output = from * 1000f;
                if (typeTo.equals("cm")) output = from * 100f;
                if (typeTo.equals("m")) output = from;
                if (typeTo.equals("km")) output = from * 0.001f;
            }
            if (typeFrom.equals("km")) {
                if (typeTo.equals("mm")) output = from * 1000000f;
                if (typeTo.equals("cm")) output = from * 100000f;
                if (typeTo.equals("m")) output = from * 1000f;
                if (typeTo.equals("km")) output = from;
            }

            OutText.setText(String.format("%.10f",output));
        }
        catch (Exception ignored) {
            Toast.makeText(this, "Error!!!", Toast.LENGTH_SHORT).show();
        }
    }

}