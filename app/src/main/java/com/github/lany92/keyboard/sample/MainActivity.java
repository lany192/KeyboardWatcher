package com.github.lany92.keyboard.sample;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.github.lany92.keyboard.KeyboardWatcher;
import com.gyf.immersionbar.ImmersionBar;
import com.gyf.immersionbar.OnKeyboardListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new KeyboardWatcher(this, new KeyboardWatcher.OnKeyboardListener() {
            @Override
            public void onChanged(boolean showKeyboard, int height) {
                ((TextView) findViewById(R.id.show1)).setText("KeyboardWatcher:showKeyboard：" + showKeyboard + "，height:" + height);
            }
        });
        findViewById(R.id.adjustNothing).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AdjustNothingActivity.class));
            }
        });
        findViewById(R.id.adjustResize).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AdjustResizeActivity.class));
            }
        });
        findViewById(R.id.adjustPan).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AdjustPanActivity.class));
            }
        });
        ImmersionBar.with(this)
                .supportActionBar(true)
                .barColorInt(Color.BLUE)
                .keyboardEnable(true)
                .keyboardMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_UNSPECIFIED)
                .setOnKeyboardListener(new OnKeyboardListener() {
                    @Override
                    public void onKeyboardChange(boolean isPopup, int keyboardHeight) {
                        ((TextView) findViewById(R.id.show2)).setText("ImmersionBar:isPopup：" + isPopup + "，keyboardHeight:" + keyboardHeight);
                    }
                })
                .init();
    }
}