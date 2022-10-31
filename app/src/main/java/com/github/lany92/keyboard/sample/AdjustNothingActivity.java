package com.github.lany92.keyboard.sample;

import android.graphics.Color;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.github.lany92.keyboard.KeyboardWatcher;
import com.gyf.immersionbar.ImmersionBar;
import com.gyf.immersionbar.OnKeyboardListener;

public class AdjustNothingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adjust_nothing);
        new KeyboardWatcher(this, new KeyboardWatcher.OnKeyboardListener() {
            @Override
            public void onChanged(boolean showKeyboard, int height) {
                ((TextView) findViewById(R.id.show1)).setText("KeyboardWatcher:showKeyboard：" + showKeyboard + "，height:" + height);
            }
        });
        ImmersionBar.with(this)
                .barColorInt(Color.BLUE)
                .supportActionBar(true)
                .keyboardEnable(true)
                .keyboardMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING)
                .setOnKeyboardListener(new OnKeyboardListener() {
                    @Override
                    public void onKeyboardChange(boolean isPopup, int keyboardHeight) {
                        ((TextView) findViewById(R.id.show2)).setText("ImmersionBar:isPopup：" + isPopup + "，keyboardHeight:" + keyboardHeight);
                    }
                })
                .init();
    }
}