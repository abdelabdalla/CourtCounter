package net.ddns.sabr.courtcounter;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class CounterFragment extends Fragment implements View.OnClickListener {


    public CounterFragment() {}

    TextView scoreText;

    int score = 0;

    Button button1;
    Button button2;
    Button button3;
    Button resetButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_counter, container, false);

        scoreText = (TextView) root.findViewById(R.id.scoreTextView);

        button1 = (Button) root.findViewById(R.id.oneButton);
        button2 = (Button) root.findViewById(R.id.twoButton);
        button3 = (Button) root.findViewById(R.id.threeButton);
        resetButton = (Button) root.findViewById(R.id.resetButton);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        resetButton.setOnClickListener(this);

        return root;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.oneButton :
                score++;
                scoreText.setText(Integer.toString(score));
                break;
            case R.id.twoButton :
                score += 2;
                scoreText.setText(Integer.toString(score));
                break;
            case R.id.threeButton :
                score += 3;
                scoreText.setText(Integer.toString(score));
                break;
            case R.id.resetButton :
                scoreText.setText(Integer.toString(0));
                break;
            default:
                break;
        }
    }
}
