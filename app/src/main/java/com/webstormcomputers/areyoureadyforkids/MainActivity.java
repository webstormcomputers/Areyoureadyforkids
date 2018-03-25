package com.webstormcomputers.areyoureadyforkids;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class MainActivity extends AppCompatActivity {
int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * calc_score receives the input and does an errorcheck first.
     * Then calc_score tallies the score, when the score is tallied the user is toasted with a custom message depending on how many points they got.
     * @param view
     */


public void calc_score(View view) {

    EditText user = (EditText) findViewById(R.id.userName);
    RadioButton otherKidsAns1 = (RadioButton) findViewById(R.id.othersKidsAns1);
    final CheckBox diapers1 = (CheckBox) findViewById(R.id.diapers1);
    final CheckBox diapers2 = (CheckBox) findViewById(R.id.diapers2);
    final CheckBox diapers3 = (CheckBox) findViewById(R.id.diapers3);
    final CheckBox diapers4 = (CheckBox) findViewById(R.id.diapers4);
    EditText numOfKids = (EditText) findViewById(R.id.numOfKids);
    RadioButton clutter1 = (RadioButton) findViewById(R.id.clutter1);
    String name = user.getText().toString();
    if (errorCheck()) {

        if (otherKidsAns1.isChecked()) {
            score = score + 1;
        }

        if (diapers1.isChecked()) {
            score = score + 1;
        }
        if (diapers2.isChecked()) {
            score = score + 1;
        }
        if (diapers3.isChecked()) {
            score = score + 1;
        }
        if (numOfKids.getText().toString().equals("4")) {

            score = score + 1;
        }
        if (clutter1.isChecked()) {
            score = score + 1;
        }

        if (score > 4) {

            Toast.makeText(getApplicationContext(), "Congrats " + name + " you scored " + score + " you're ready to have kids.",
                    Toast.LENGTH_LONG).show();

        } else if (score > 3) {
            Toast.makeText(getApplicationContext(), name + " you know a little about kids but you need to mature a bit, you scored " + score +".",
                    Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(), "Dear " + name + " you might want to wait a bit before having kids. You're score was " + score +".",
                    Toast.LENGTH_LONG).show();
        }
        Button Submit = (Button) findViewById(R.id.submit);
        Submit.setVisibility(View.GONE);
        Button reset = (Button) findViewById(R.id.reset);
        reset.setVisibility(View.VISIBLE);
    }
}

    /**
     * reset_score restores the submit button after clearing the score. It also toasts the user prompting them
     * to retry their entries.
     * @param view
     */

    public void reset_score(View view){
        Button Submit = (Button) findViewById(R.id.submit);
        Submit.setVisibility(View.VISIBLE);

        score = 0;
        Toast.makeText(getApplicationContext(), "Please go back and change some values and try again.",
                Toast.LENGTH_LONG).show();
        Button reset = (Button) findViewById(R.id.reset);
        reset.setVisibility(View.GONE);
    }
    /**
     * errorCheck() checks to see if a user has entered input into the questions. If they have not
     * errorCheck() returns false and toasts the user with the required input
     *
     * @return result
     */

public boolean errorCheck() {
    boolean result;
    EditText user = (EditText) findViewById(R.id.userName);
    RadioGroup otherKids = (RadioGroup) findViewById(R.id.othersKids);
    final CheckBox diapers1 = (CheckBox) findViewById(R.id.diapers1);
    final CheckBox diapers2 = (CheckBox) findViewById(R.id.diapers2);
    final CheckBox diapers3 = (CheckBox) findViewById(R.id.diapers3);
    final CheckBox diapers4 = (CheckBox) findViewById(R.id.diapers4);
    EditText numOfKids = (EditText) findViewById(R.id.numOfKids);
    RadioGroup radClutter = (RadioGroup) findViewById(R.id.radClutterGrp);

    if (user.getText().toString().trim().length() == 0) {
        Toast.makeText(getApplicationContext(), "Please Enter your name.",
                Toast.LENGTH_SHORT).show();
        result = FALSE;
    }
    else if(otherKids.getCheckedRadioButtonId() == -1)
    {
        Toast.makeText(getApplicationContext(), "Please Choose how you feel about other kids.",
                Toast.LENGTH_SHORT).show();
        result = FALSE;
    }
    else if (diapers1.isChecked() || diapers2.isChecked() || diapers3.isChecked() || diapers4.isChecked()) {
        result = TRUE;
    } else {
        Toast.makeText(getApplicationContext(), "Please Check a diaper option.",
                Toast.LENGTH_SHORT).show();
        result = FALSE;
    }
    if (numOfKids.getText().toString().trim().length() == 0)
    {
        Toast.makeText(getApplicationContext(), "Please Enter how many kids you think you see.",
                Toast.LENGTH_SHORT).show();
        result = FALSE;
    }
    else if (radClutter.getCheckedRadioButtonId() == -1)
    {
        Toast.makeText(getApplicationContext(), "Please Choose how you feel about clutter.",
                Toast.LENGTH_SHORT).show();
        result = FALSE;
    }
    return result;
}
}