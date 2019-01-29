package com.example.myapplication;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    RadioButton radioButton,radioButton2,radioButton3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioButton = findViewById(R.id.radioButton);
        radioButton2 = findViewById(R.id.radioButton2);
        radioButton3 = findViewById(R.id.radioButton3);
        radioButton.setButtonDrawable(makeSelector(shapeView("#e91e63"),layerView("#e91e63")));
        radioButton2.setButtonDrawable(makeSelector(shapeView("#0F0F0F"),layerView("#0F0F0F")));
        radioButton3.setButtonDrawable(makeSelector(shapeView("#2C1EE9"),layerView("#2C1EE9")));
    }

    public static GradientDrawable shapeView(String backgroundColor) {
        //This is the shape item
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(GradientDrawable.OVAL);
        gradientDrawable.setColor(Color.parseColor(backgroundColor));
        gradientDrawable.setSize(40,40);
        return gradientDrawable;
    }

    public static LayerDrawable layerView(String backgroundColor) {
        // This is the first item in layer XML file
        GradientDrawable layer1 = new GradientDrawable();
        layer1.setShape(GradientDrawable.OVAL);
        layer1.setStroke(2,Color.parseColor(backgroundColor));
        layer1.setSize(40,40);

        // This is your second item in layer XML file
        GradientDrawable layer2 = new GradientDrawable();
        layer2.setShape(GradientDrawable.OVAL);
        layer2.setStroke(20, Color.TRANSPARENT);
        layer2.setColor(Color.parseColor(backgroundColor));
        layer2.setSize(30,30);

        // This will give the bottom space
        InsetDrawable insetLayer2 = new InsetDrawable(layer2, -3, -3, -3, -3);

        // This is the final drawable which is to be used
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{layer1,insetLayer2});
        return  layerDrawable;
    }

    public static StateListDrawable makeSelector(GradientDrawable drawable, LayerDrawable layerDrawable) {
        //This will create the selector
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_checked}, layerDrawable);
        stateListDrawable.addState(new int[]{}, drawable);
        return stateListDrawable;
    }
}
