package sg.edu.rp.c346.myprofile;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    EditText etName;
    EditText etGPA;
    RadioGroup rgGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName = findViewById(R.id.editName);
        etGPA= findViewById(R.id.editGPA);
        rgGender = findViewById(R.id.radioGroup);
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String name = prefs.getString("name", "");
        Float gpa = prefs.getFloat("gpa",0);
        int gender = prefs.getInt("gender", 0);
        etName.setText(name);
        etGPA.setText(String.valueOf(gpa));
        rgGender.check(gender);
    }

    @Override
    protected void onPause() {
        super.onPause();
        String strName = etName.getText().toString();
        Float floatGPA = Float.parseFloat(etGPA.getText().toString());
        int intId = rgGender.getCheckedRadioButtonId();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor prefEdit = prefs.edit();
        prefEdit.putString("name", strName);
        prefEdit.putFloat("gpa", floatGPA);
        prefEdit.putInt("gender", intId);
        prefEdit.commit();
    }
}
