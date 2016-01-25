package eawww.umpire_buddy;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Umpirebuddy extends AppCompatActivity {

    private Button mBallButton;     //button to increment ball count
    private Button mStrikeButton;   //button to increment strike count
    private TextView mNumBalls;     //displays and keeps track of ball count
    private TextView mNumStrikes;   //displays and keeps track of strike count


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_umpirebuddy);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //create references to textviews
        mNumBalls = (TextView)findViewById(R.id.ball_number);
        mNumStrikes = (TextView)findViewById(R.id.strike_number);

        //create reference to ball_button
        mBallButton = (Button)findViewById(R.id.ball_button);
        mBallButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //logic for ball button
                if(Integer.parseInt((String)mNumBalls.getText()) < 3)
                    mNumBalls.setText(Integer.toString(Integer.parseInt((String)mNumBalls
                            .getText()) + 1));
                else {
                    Toast.makeText(Umpirebuddy.this,
                            R.string.walk_toast,
                            Toast.LENGTH_SHORT).show();
                    mNumBalls.setText("0");
                    mNumStrikes.setText("0");
                }
            }
        });
        //create reference to strike_button
        mStrikeButton = (Button)findViewById(R.id.strike_button);
        mStrikeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //logic for strike button
                if(Integer.parseInt((String)mNumStrikes.getText()) < 2)
                    mNumStrikes.setText(Integer.toString(Integer.parseInt((String)mNumStrikes.
                            getText()) + 1));
                else {
                    Toast.makeText(Umpirebuddy.this,
                            R.string.out_toast,
                            Toast.LENGTH_SHORT).show();
                    mNumStrikes.setText("0");
                    mNumBalls.setText("0");
                }
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_umpirebuddy, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
