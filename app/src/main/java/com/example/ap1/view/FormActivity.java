package com.example.ap1.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import com.example.ap1.R;
import com.example.ap1.constant.FimDeAnoConstants;
import com.example.ap1.data.SecurityPreferences;

public class FormActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mVidewHolder = new ViewHolder();
    private SecurityPreferences mSecurityPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        this.mSecurityPreferences = new SecurityPreferences(this);
        this.mVidewHolder.checkParticipate = findViewById(R.id.check_participate);
        this.mVidewHolder.checkParticipate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.check_participate)
        {
            if(this.mVidewHolder.checkParticipate.isChecked())
            {
                //salvar a presença
                this.mSecurityPreferences.storeString(FimDeAnoConstants.Presence_Key,FimDeAnoConstants.CONFIRMATION_YES);
            }else
            {
                //salvar a ausencia
                this.mSecurityPreferences.storeString(FimDeAnoConstants.Presence_Key,FimDeAnoConstants.CONFIRMATION_NO);
            }
        }
    }

    private  static class ViewHolder
    {
        CheckBox checkParticipate;
    }
}