package arnold.agura.com.swoosh_app;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import static android.R.attr.colorPrimary;
import static android.R.attr.value;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

public class LeagueScreen extends AppCompatActivity {
    private Button mMensBtn;
    private Button mWomensBtn;
    private Button mCo_edBtn;
    private Button mNext;
    private Button mNextbg;
    private TextView miAmtxt;
    private TextView miAm;
    public static final String PASS_STRING = "";
    public static final int REQ_CODE = 1111;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_league_screen);

        findViews();

        mMensBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(mMensBtn.getAlpha() != mNext.getAlpha()) {
                   mMensBtn.setAlpha(1f);
                   mWomensBtn.setAlpha(0.5f);
                   mCo_edBtn.setAlpha(0.5f);
                   mNext.setAlpha(1f);
                   mNext.setEnabled(true);
               }
               else if(miAm.getText().toString().isEmpty()){
                   mMensBtn.setAlpha(1f);
                   mWomensBtn.setAlpha(1f);
                   mCo_edBtn.setAlpha(1f);
                   mNext.setAlpha(0.5f);
                   mNext.setEnabled(false);
               }
            }
        });
        mWomensBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mWomensBtn.getAlpha() != mNext.getAlpha()) {
                    mMensBtn.setAlpha(0.5f);
                    mWomensBtn.setAlpha(1f);
                    mCo_edBtn.setAlpha(0.5f);
                    mNext.setAlpha(1f);
                    mNext.setEnabled(true);
                }
                else if(miAm.getText().toString().isEmpty()){
                    mMensBtn.setAlpha(1f);
                    mWomensBtn.setAlpha(1f);
                    mCo_edBtn.setAlpha(1f);
                    mNext.setAlpha(0.5f);
                    mNext.setEnabled(false);
                }
            }
        });
        mCo_edBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mCo_edBtn.getAlpha() != mNext.getAlpha()) {
                    mMensBtn.setAlpha(0.5f);
                    mWomensBtn.setAlpha(0.5f);
                    mCo_edBtn.setAlpha(1f);
                    mNext.setAlpha(1f);
                    mNext.setEnabled(true);

                }
                else if(miAm.getText().toString().isEmpty()){
                    mMensBtn.setAlpha(1f);
                    mWomensBtn.setAlpha(1f);
                    mCo_edBtn.setAlpha(1f);
                    mNext.setAlpha(0.5f);
                    mNext.setEnabled(false);

                }
            }
        });

        mNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent skillIntent = new Intent(v.getContext(), SkillScreen.class);
                startActivityForResult(skillIntent, REQ_CODE);
            }
        });
    }
    private void findViews(){
        mMensBtn = (Button) findViewById(R.id.mens);
        mWomensBtn = (Button) findViewById(R.id.womens);
        mCo_edBtn = (Button) findViewById(R.id.co_ed);
        mNextbg = (Button) findViewById(R.id.nextbg);
        mNext = (Button) findViewById(R.id.next);
        miAm = (TextView)findViewById(R.id.iamleague);
        miAmtxt = (TextView)findViewById(R.id.iamatxtleague);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (requestCode == REQ_CODE) {
                String replyMsg = data.getStringExtra(SkillScreen.PASS_STRING);
                miAmtxt.setVisibility(View.VISIBLE);
                miAm.setVisibility(View.VISIBLE);
                miAm.setText(replyMsg);
                mNextbg.setVisibility(View.GONE);
                mNext.setVisibility(View.GONE);
                if(mMensBtn.getAlpha()!=1f)
                mMensBtn.setEnabled(false);
                if(mWomensBtn.getAlpha()!=1f)
                mWomensBtn.setEnabled(false);
                if(mCo_edBtn.getAlpha()!=1f)
                mCo_edBtn.setEnabled(false);
            }
        }
    }
}
