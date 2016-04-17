package comengwalker.github.coffeetools;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;

import java.util.ArrayList;

/**
 * Created by jeremy on 4/11/16.
 * TODO: add option to reverse the countdown/timer
 * TODO: add checkpoint and finished messages/alerts
 */
public class TimerFragment extends Fragment implements OnClickListener, View.OnClickListener {

    //declare variables
    public View myView;
    private Chronometer chronometer;
    private Button startButton;
    private long timeAtStop = 0;
    private ArrayList<Checkpoint> brewSteps;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //inflate view and define UI
        myView = inflater.inflate(R.layout.timer_layout, container, false);
        chronometer = (Chronometer) myView.findViewById(R.id.chronometer);
        startButton = (Button) myView.findViewById(R.id.timerStartButton);
        Button resetButton = (Button) myView.findViewById(R.id.timerResetButton);
        FloatingActionButton fab = (FloatingActionButton) myView.findViewById(R.id.fab);
        //hide fab for now until I get brewing steps implemented
        fab.hide();
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
                    //sets the button's label, sets the base time using the real time and the variable that stores the elapsed time which is zero if timer hasn't been stopped
                    startButton.setText(getText(R.string.timer_stop));
                    chronometer.setBase(SystemClock.elapsedRealtime() + timeAtStop);
                    chronometer.start();
                }
                else if (startButton.getText().toString() == getText(R.string.timer_stop))
                {
                    //changes the button's label to start, keeps track of elapsed time with timeAtStop so the timer doesn't silently run without displaying
                    startButton.setText(getText(R.string.timer_start));
                    timeAtStop = chronometer.getBase() - SystemClock.elapsedRealtime();
                    chronometer.stop();
                }
                break;
            case R.id.timerResetButton:
                //stops timer, resets the base time, resets the variable storing the elapsed time, and resets the start/stop button
                chronometer.stop();
                chronometer.setBase(SystemClock.elapsedRealtime());
                timeAtStop=0;
                startButton.setText(getText(R.string.timer_start));
                break;
        }
    }


}
