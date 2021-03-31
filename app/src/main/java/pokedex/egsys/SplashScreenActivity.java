package pokedex.egsys;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

public class SplashScreenActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Handler handle = new Handler();
        handle.postDelayed(new Runnable() {
            @Override
            public void run() {
                showMainScreen();
            }
        }, 2000);
    }

    private void showMainScreen() {
        Intent intent = new Intent(
                this,
                HomeActivity.class);
        startActivity(intent);
        finish();
    }
}
