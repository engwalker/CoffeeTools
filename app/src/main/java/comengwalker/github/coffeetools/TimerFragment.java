package comengwalker.github.coffeetools;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;

/**
 * Created by jeremy on 4/11/16.
 * TODO: add option to reverse the countdown/timer
 * TODO: add checkpoint and finished messages/alerts
 */
public class TimerFragment extends Fragment implements OnClickListener, View.OnClickListener {

    public View myView;
    private Chronometer chronometer;
    private Button startButton;
    private Button resetButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.timer_layout, container, false);
        chronometer = (Chronometer) myView.findViewById(R.id.chronometer);
        startButton = (Button) myView.findViewById(R.id.timerStartButton);
        resetButton = (Button) myView.findViewById(R.id.timerResetButton);

        //((Button) myView.findViewById(R.id.timerStartButton)).setOnClickListener(this);
        startButton.setOnClickListener(this);
        resetButton.setOnClickListener(this);
        return myView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.timerStartButton:


                if (startButton.getText().toString() == getText(R.string.timer_start))
                {
                    startButton.setText(getText(R.string.timer_stop));
                    chronometer.start();
                }
                else if (startButton.getText().toString() == getText(R.string.timer_stop))
                {
                    startButton.setText(getText(R.string.timer_start));
                    chronometer.stop();
                }
                break;
            case R.id.timerResetButton:

                chronometer.setBase(SystemClock.elapsedRealtime());
                break;
        }
    }
}
