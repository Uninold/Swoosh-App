package arnold.agura.com.swoosh_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WelcomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        Button mStart = (Button) findViewById(R.id.startBtn);

        mStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent leagueIntent = new Intent(v.getContext(), LeagueScreen.class);
                startActivity(leagueIntent);
            }
        });
    }

}
