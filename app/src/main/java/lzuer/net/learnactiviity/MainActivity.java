package lzuer.net.learnactiviity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final int FETCH_NAME = 1;

    private Button button;
    private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //The activity been created.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);

                startActivity(intent);
            }
        });

        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
                startActivityForResult(intent, FETCH_NAME);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        //The activity is about to become visible
    }

    @Override
    protected void onResume() {
        super.onResume();
        //The activity has become visible
    }

    @Override
    protected void onPause() {
        super.onPause();
        //Another activity is taking focus
    }

    @Override
    protected void onStop() {
        super.onStop();
        //The activity is no longer visible
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //The activity is about to be destroyed.
    }

    private void sendEmail() {
        String[] recipients = {"872583117@qq.com"};
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, recipients);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.e("MainActivity", requestCode + "-" + resultCode);
        if (requestCode == FETCH_NAME && resultCode == RESULT_OK) {
            String name = data.getExtras().getString("username");
            Toast.makeText(MainActivity.this, name, Toast.LENGTH_SHORT).show();
        }
        if (resultCode == RESULT_CANCELED) {
            Toast.makeText(MainActivity.this, "No result returned", Toast.LENGTH_SHORT).show();
        }
    }
}
