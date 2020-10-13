package com.example.ap1.data;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.jar.Attributes;

import javax.xml.namespace.QName;

public class SecurityPreferences {
    private SharedPreferences mSharedPreferences;
    //construtor

    public SecurityPreferences(Context mContext)
    {
        this.mSharedPreferences = mContext.getSharedPreferences("the fest",Context.MODE_PRIVATE);

    }
    public void storeString(String key,String value)
    {
        this.mSharedPreferences.edit().putString(key,value).apply();
    }
    public String getStroredString(String key)
    {
        return this.mSharedPreferences.getString(key,"");
    }
}
