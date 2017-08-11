package arnold.agura.com.swoosh_app;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static android.R.attr.data;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;
import static android.support.v7.widget.AppCompatDrawableManager.get;

public class SkillScreen extends AppCompatActivity {
    private Button mFinishBtn;
    private Button mBeginnerBtn;
    private Button mBallerBtn;
    private String skill;
    public static final String PASS_STRING = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skill_screen);
        findViews();
        final Player player = getIntent().getExtras().getParcelable(PASS_STRING);

        mBeginnerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!mFinishBtn.isEnabled()) {
                    mFinishBtn.setEnabled(true);
                    mFinishBtn.setText("Finish");
                    skill = mBeginnerBtn.getText().toString();
                }
                else{
                    skill="";
                    mFinishBtn.setEnabled(false);
                    mFinishBtn.setText("");
                }
            }
        });
        mBallerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!mFinishBtn.isEnabled()) {
                    mFinishBtn.setEnabled(true);
                    mFinishBtn.setText("Finish");
                    skill = mBallerBtn.getText().toString();
                }
                else{
                    skill="";
                    mFinishBtn.setEnabled(false);
                    mFinishBtn.setText("");
                }
            }
        });

        mFinishBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.setSkill(skill);
                Intent leagueIntent = getIntent();
                leagueIntent.putExtra(PASS_STRING, player);
                setResult(Activity.RESULT_OK, leagueIntent);
                finish();


            }
        });
    }

    private void findViews()
    {
        mFinishBtn = (Button) findViewById(R.id.finish);
        mBeginnerBtn = (Button) findViewById(R.id.beginner);
        mBallerBtn = (Button) findViewById(R.id.baller);
    }

}
