package arnold.agura.com.swoosh_app;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

public class SkillScreen extends AppCompatActivity {
    private Button mFinishBtn;
    private Button mBeginnerBtn;
    private Button mBallerBtn;
    public static final String PASS_STRING = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skill_screen);
        findViews();
        mBeginnerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mBeginnerBtn.getAlpha()!=mFinishBtn.getAlpha()) {
                    mBeginnerBtn.setAlpha(1f);
                    mBallerBtn.setAlpha(0.5f);
                    mFinishBtn.setAlpha(1f);
                    mFinishBtn.setEnabled(true);
                    mFinishBtn.setText("Finish");
                }
                else{
                    mBeginnerBtn.setAlpha(1f);
                    mBallerBtn.setAlpha(1f);
                    mFinishBtn.setAlpha(0.5f);
                    mFinishBtn.setEnabled(false);
                    mFinishBtn.setText("");
                }
            }
        });
        mBallerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mBallerBtn.getAlpha()!=mFinishBtn.getAlpha()) {
                    mBeginnerBtn.setAlpha(0.5f);
                    mBallerBtn.setAlpha(1f);
                    mFinishBtn.setAlpha(1f);
                    mFinishBtn.setEnabled(true);
                    mFinishBtn.setText("Finish");
                }
                else{
                    mBeginnerBtn.setAlpha(1f);
                    mBallerBtn.setAlpha(1f);
                    mFinishBtn.setAlpha(0.5f);
                    mFinishBtn.setEnabled(false);
                    mFinishBtn.setText("");
                }
            }
        });

        mFinishBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String iAm = mBeginnerBtn.getText().toString();
                Intent data = new Intent();

                data.putExtra(PASS_STRING, iAm);
                setResult(Activity.RESULT_OK, data);

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
