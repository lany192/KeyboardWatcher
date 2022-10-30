[![](https://jitpack.io/v/lany192/KeyboardWatcher.svg)](https://jitpack.io/#lany192/KeyboardWatcher)

# 使用方法

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
        }
    }

## 引入代码仓库

	allprojects {
		repositories {
		    ...
		    maven { url 'https://jitpack.io' }
		}
	}

	dependencies {
        	implementation 'com.github.lany192:KeyboardWatcher:1.0.0'
	}
