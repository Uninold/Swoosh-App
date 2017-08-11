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
import static android.R.attr.elegantTextHeight;
import static android.R.attr.value;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

public class LeagueScreen extends AppCompatActivity {
    private Button mMensBtn;
    private Button mWomensBtn;
    private Button mCo_edBtn;
    private Button mNext;
    private TextView miAmtxt;
    private TextView miAm;
    private Player player;
    private String league="";
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
               if(league.isEmpty()||league!=mMensBtn.getText().toString()) {
                   mNext.setEnabled(true);
                   league = mMensBtn.getText().toString();
               }
               else{
                   league="";
                   mNext.setEnabled(false);
               }
            }
        });
        mWomensBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(league.isEmpty()||league!=mWomensBtn.getText().toString()) {
                    mNext.setEnabled(true);
                    league = mWomensBtn.getText().toString();
                }
                else{
                    league="";
                    mNext.setEnabled(false);
                }
            }
        });
        mCo_edBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(league.isEmpty()||league!=mCo_edBtn.getText().toString()) {
                    mNext.setEnabled(true);
                    league = mCo_edBtn.getText().toString();
                }
                else{
                    league="";
                    mNext.setEnabled(false);
                }
            }
        });

        mNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player  = new Player();
                player.setLeague(league);
                Intent skillIntent = new Intent(v.getContext(), SkillScreen.class);
                skillIntent.putExtra(PASS_STRING, player);
                startActivityForResult(skillIntent, REQ_CODE);
            }
        });
    }
    private void findViews(){
        mMensBtn = (Button) findViewById(R.id.mens);
        mWomensBtn = (Button) findViewById(R.id.womens);
        mCo_edBtn = (Button) findViewById(R.id.co_ed);
        mNext = (Button) findViewById(R.id.next);
        miAm = (TextView)findViewById(R.id.iamleague);
        miAmtxt = (TextView)findViewById(R.id.iamatxtleague);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (requestCode == REQ_CODE) {
                Player playerProf = data.getParcelableExtra(SkillScreen.PASS_STRING);
                miAmtxt.setVisibility(View.VISIBLE);
                miAm.setVisibility(View.VISIBLE);
                miAm.setText(playerProf.getSkill().toString());
                mNext.setVisibility(View.GONE);
                if (!mMensBtn.getText().toString().equals( playerProf.getLeague())) {
                    mMensBtn.setEnabled(false);
                }
                if (!mWomensBtn.getText().toString().equals( playerProf.getLeague())){
                    mWomensBtn.setEnabled(false);
                 }
                if(!mCo_edBtn.getText().toString().equals( playerProf.getLeague())) {
                    mCo_edBtn.setEnabled(false);
                }

            }
        }
    }



}
