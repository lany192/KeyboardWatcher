package com.github.lany92.keyboard.sample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.github.lany92.keyboard.KeyboardWatcher;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new KeyboardWatcher(this, new KeyboardWatcher.OnKeyboardListener() {
            @Override
            public void onChanged(boolean showKeyboard, int height) {
                Toast.makeText(MainActivity.this, "showKeyboard：" + showKeyboard + "，height:" + height, Toast.LENGTH_SHORT).show();
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
    }
}