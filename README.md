[![](https://jitpack.io/v/lany192/KeyboardWatcher.svg)](https://jitpack.io/#lany192/KeyboardWatcher)

现有很多方法是通过监听布局的变化来计算输入法键盘高度，这个的前提是在Activity的配置中配置为"android:windowSoftInputMode="adjustResize""

如果Activity配置为"android:windowSoftInputMode="adjustNothing""或者其他属性时，这种方式会失效或者算不准。

经过摸索，发现用不可见的PopupWindow可以正确计算高度放方法。

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
