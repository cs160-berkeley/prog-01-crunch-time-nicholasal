package cs160.calorieconverter;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
//    TextView final_result;
    TextView numCalories;
    EditText no_reps_mins;
    Spinner exercise_spinner;
    Spinner exercises;
    TextView comparison;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        exercise_spinner = (Spinner) findViewById(R.id.exercise_spinner);
        exercises = (Spinner) findViewById(R.id.exercises);
        no_reps_mins = (EditText) findViewById(R.id.no_reps_mins);
        numCalories = (TextView) findViewById(R.id.numCalories);
        comparison = (TextView) findViewById(R.id.comparison);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.reps_mins_Exercise, android.R.layout.simple_spinner_item);
        exercise_spinner.setAdapter(adapter);
        exercise_spinner.setOnItemSelectedListener(this);
        Button calcBtn = (Button) findViewById(R.id.calcBtn);
        calcBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Double reps_mins = Double.parseDouble(no_reps_mins.getText().toString());
                String ex = exercise_spinner.getSelectedItem().toString();
                Double total = calorieCalc(ex, reps_mins);
                numCalories.setText(rounding(total));
            }
        });

        exercises.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String ex = exercises.getSelectedItem().toString();
                Double calorie = Double.parseDouble(numCalories.getText().toString());
                Double number = calorieConv(ex, calorie);
                int a = (int)(number + 0.5);
                comparison.setText(Integer.toString(a));
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        TextView myText= (TextView) view;
        Toast.makeText(this,"You Selected "+myText.getText(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public double calorieCalc(String ex, double num){
        double test = 0;
        double temp = 0;

        switch(ex){
            case "Reps Of Pushup":
                temp = num/350;
                test = temp*100;
                break;
            case "Reps Of Situp":
                temp = num/200;
                test = temp*100;
                break;
            case "Reps Of Squats":
                temp = num/225;
                test = temp*100;
                break;
            case "Mins Of Leg-lift":
                temp = num/25;
                test = temp*100;
                break;
            case "Mins Of Plank":
                temp = num/25;
                test = temp*100;
                break;
            case "Mins Of Jumping Jacks":
                temp = num/10;
                test = temp*100;
                break;
            case "Reps Of Pullup":
                temp = num/100;
                test = temp*100;
                break;
            case "Mins Of Cycling":
                temp = num/12;
                test = temp*100;
                break;
            case "Mins Of Jogging":
                temp = num/12;
                test = temp*100;
                break;
            case "Mins Of Walking":
                temp = num/20;
                test = temp*100;
                break;
            case "Mins Of Swimming":
                temp = num/13;
                test = temp*100;
                break;
            case "Mins Of Stair-Climbing":
                temp = num/15;
                test = temp*100;
                break;
        }
        return test;
    }

    public double calorieConv(String ex, double calorie){
        double test = 0;
        double temp = 0;

        switch(ex){
            case "Reps Of Pushup":
                temp = calorie/100;
                test = temp*350;
                break;
            case "Reps Of Situp":
                temp = calorie/100;
                test = temp*200;
                break;
            case "Reps Of Squats":
                temp = calorie/100;
                test = temp*225;
                break;
            case "Mins Of Leg-lift":
                temp = calorie/100;
                test = temp*25;
                break;
            case "Mins Of Plank":
                temp = calorie/100;
                test = temp*25;
                break;
            case "Mins Of Jumping Jacks":
                temp = calorie/100;
                test = temp*10;
                break;
            case "Reps Of Pullup":
                temp = calorie/100;
                test = temp*100;
                break;
            case "Mins Of Cycling":
                temp = calorie/100;
                test = temp*12;
                break;
            case "Mins Of Jogging":
                temp = calorie/100;
                test = temp*12;
                break;
            case "Mins Of Walking":
                temp = calorie/100;
                test = temp*20;
                break;
            case "Mins Of Swimming":
                temp = calorie/100;
                test = temp*13;
                break;
            case "Mins Of Stair-Climbing":
                temp = calorie/100;
                test = temp*15;
                break;
        }
        return test;
    }

    private String rounding(double num){
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.CEILING);
        return df.format(num).toString();
    }


}
