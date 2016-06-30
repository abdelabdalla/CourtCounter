package net.ddns.sabr.courtcounter;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class CounterFragment extends Fragment implements View.OnClickListener {


    public CounterFragment() {
    }

    TextView scoreText;

    Button button1;
    Button button2;
    Button button3;

    int containerID = 1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_counter, container, false);

        containerID = container.getId();

        scoreText = (TextView) root.findViewById(R.id.scoreTextView);

        if (containerID == R.id.frame1)
            scoreText.setText(String.valueOf(MainActivity.score1));
        else
            scoreText.setText(String.valueOf(MainActivity.score2));

        button1 = (Button) root.findViewById(R.id.oneButton);
        button2 = (Button) root.findViewById(R.id.twoButton);
        button3 = (Button) root.findViewById(R.id.threeButton);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);

        return root;
    }

    void reset(){
        scoreText.setText(String.valueOf(0));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.oneButton:
                if (containerID == R.id.frame1){
                    MainActivity.score1++;
                    scoreText.setText(Integer.toString(MainActivity.score1));
                }
                else {
                    MainActivity.score2++;
                    scoreText.setText(Integer.toString(MainActivity.score2));
                }
                break;
            case R.id.twoButton:
                if (containerID == R.id.frame1){
                    MainActivity.score1+=2;
                    scoreText.setText(Integer.toString(MainActivity.score1));
                }
                else {
                    MainActivity.score2+=2;
                    scoreText.setText(Integer.toString(MainActivity.score2));
                }
                break;
            case R.id.threeButton:
                if (containerID == R.id.frame1){
                    MainActivity.score1+=3;
                    scoreText.setText(Integer.toString(MainActivity.score1));
                }
                else {
                    MainActivity.score2+=3;
                    scoreText.setText(Integer.toString(MainActivity.score2));
                }
                break;
            default:
                break;
        }
    }
}
