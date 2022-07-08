package sg.edu.rp.c346.id20026389.demomyprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText etName,etGPA;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName=findViewById(R.id.editTextName);
        etGPA=findViewById(R.id.editTextGPA);
    }

    @Override
    protected void onPause() {
        super.onPause();
        String strName=etName.getText().toString();
        SharedPreferences prefs=getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor prefedit=prefs.edit();
        prefedit.putString("name",strName);
        prefedit.commit();
        String gpa=etGPA.getText().toString();
        Float floatgpa= Float.parseFloat(gpa);
        SharedPreferences prefsgpa=getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor prefeditgpa=prefsgpa.edit();
        prefeditgpa.putFloat("gpa",floatgpa);
        prefeditgpa.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences prefs=getPreferences(MODE_PRIVATE);
        String strName=prefs.getString("name","No name");
        etName.setText(strName);
        SharedPreferences prefsgpa=getPreferences(MODE_PRIVATE);
        Float gpa=prefsgpa.getFloat("gpa",0);
        etGPA.setText(gpa.toString());

    }
}