package net.ddns.sabr.courtcounter;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    static int score1 = 0;
    static int score2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState != null){
            score1 = savedInstanceState.getInt("1");
            score2 = savedInstanceState.getInt("2");
        }

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        final CounterFragment fragment = new CounterFragment();
        Bundle b1 = new Bundle();
        b1.putInt("n",1);
        fragment.setArguments(b1);
        fragmentTransaction.replace(R.id.frame1, fragment);
        fragmentTransaction.commit();

        FragmentTransaction fragmentTransaction2 = fragmentManager.beginTransaction();

        final CounterFragment fragment2 = new CounterFragment();
        Bundle b2 = new Bundle();
        b2.putInt("n",2);
        fragment.setArguments(b2);
        fragmentTransaction2.replace(R.id.frame2, fragment2);
        fragmentTransaction2.commit();

        Button resetButton = (Button) findViewById(R.id.resetButton);
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score1 = 0;
                fragment.reset();
                score2 = 0;
                fragment2.reset();
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("1",score1);
        outState.putInt("2",score2);
        super.onSaveInstanceState(outState);
    }
}
