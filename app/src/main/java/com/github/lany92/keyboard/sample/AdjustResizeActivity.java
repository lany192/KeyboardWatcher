package com.github.lany92.keyboard.sample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.github.lany92.keyboard.KeyboardWatcher;

public class AdjustResizeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adjust_resize);
        new KeyboardWatcher(this, new KeyboardWatcher.OnKeyboardListener() {
            @Override
            public void onChanged(boolean showKeyboard, int height) {
                ((TextView)findViewById(R.id.show)).setText("showKeyboard：" + showKeyboard + "，height:" + height);
            }
        });
    }
}