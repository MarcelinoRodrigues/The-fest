package com.example.ap1.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ap1.R;
import com.example.ap1.constant.FimDeAnoConstants;
import com.example.ap1.data.SecurityPreferences;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();
    private SecurityPreferences mSecurityPreferences;
    private static SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mSecurityPreferences = new SecurityPreferences(this);

        this.mViewHolder.textToday = findViewById(R.id.text_today);
        this.mViewHolder.textDaysLeft = findViewById(R.id.text_days_left);
        this.mViewHolder.buttonConfirm = findViewById(R.id.button_confirm);

        this.mViewHolder.buttonConfirm.setOnClickListener(this);

        //Today date
        this.mViewHolder.textToday.setText(SIMPLE_DATE_FORMAT.format(Calendar.getInstance().getTime()));
        String daysLeft = String.format("%s %s", String.valueOf(this.getDaysLeft()),getString(R.string.dias));
        this.mViewHolder.textDaysLeft.setText(daysLeft);


    }

    @Override
    protected void onStart()
    {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.verifyPresence();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop(){
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void verifyPresence()
    {
        String presence = this.mSecurityPreferences.getStroredString(FimDeAnoConstants.Presence_Key);
        if(presence.equals(""))
        {
            this.mViewHolder.buttonConfirm.setText(getString(R.string.nao_confirmado));
        }else if (presence.equals(FimDeAnoConstants.CONFIRMATION_YES))
        {
            this.mViewHolder.buttonConfirm.setText(getString(R.string.sim));
        }else
        {
            this.mViewHolder.buttonConfirm.setText(getString(R.string.nao));
        }
    }

    @Override
    public void onClick(View view)
    {
        if (view.getId() == R.id.button_confirm)
        {
            Intent intent = new Intent(this,FormActivity.class);
            startActivity(intent);
        }
    }

    private int getDaysLeft()
    {
        Calendar calendarToday = Calendar.getInstance();
        int today = calendarToday.get(Calendar.DAY_OF_YEAR);
        Calendar calendarLastDay = Calendar.getInstance();
        int dayMax = calendarLastDay.getActualMaximum(Calendar.DAY_OF_YEAR);

        return dayMax - today;
    }

    private static class ViewHolder
    {
        TextView textToday;
        TextView textDaysLeft;
        Button buttonConfirm;
    }
}