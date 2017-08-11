package arnold.agura.com.swoosh_app;

import android.os.Parcel;
import android.os.Parcelable;

import static android.R.id.input;

/**
 * Created by Arnold on 11 Aug 2017.
 */

public class Player implements Parcelable {

    private String league;
    private String skill;


    public Player(Parcel in) {
        this.league = in.readString();
        this.skill=in.readString();
    }

    public Player() {

    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.league);
        dest.writeString(this.skill);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Player> CREATOR = new Creator<Player>() {
        @Override
        public Player createFromParcel(Parcel in) {
            return new Player(in);

        }

        @Override
        public Player[] newArray(int size) {

            return new Player[size];
        }
    };
    public void setLeague(String league)
    {
        this.league = league;
    }
    public String getLeague()
    {
        return league;
    }

    public void setSkill(String skill)
    {
        this.skill = skill;
    }

    public String getSkill()
    {
        return skill;
    }
}
