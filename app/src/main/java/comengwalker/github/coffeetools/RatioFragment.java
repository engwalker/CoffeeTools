package comengwalker.github.coffeetools;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Created by jeremy on 4/11/16.
 * TODO: add ounces and cups to unit spinner, might need second string array for water
 * TODO: add option to change ratio, but give default and explanation
 */
public class RatioFragment extends Fragment implements OnClickListener, View.OnClickListener{

    View myView;
    private EditText coffeeEditText;
    private EditText waterEditText;
    private Spinner coffeeUnitSpinner;
    private Spinner waterUnitSpinner;
    private Button calcButton;
    double ratio = 17.42;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //inflate view and define UI
        myView = inflater.inflate(R.layout.ratio_layout, container, false);
        coffeeEditText = (EditText) myView.findViewById(R.id.coffeeEditText);
        waterEditText = (EditText) myView.findViewById(R.id.waterEditText);
        coffeeUnitSpinner = (Spinner) myView.findViewById(R.id.coffeeUnitSpinner);
        waterUnitSpinner = (Spinner) myView.findViewById(R.id.waterUnitSpinner);

        //create an ArrayAdapter for unit spinners, set layout for spinner and dropdown, then apply adapter to both spinners
        ArrayAdapter<CharSequence> unitAdapter = ArrayAdapter.createFromResource(getContext(), R.array.unitSpinnerChoices, android.R.layout.simple_spinner_item);
        unitAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        coffeeUnitSpinner.setAdapter(unitAdapter);
        waterUnitSpinner.setAdapter(unitAdapter);

        //attach button to UI and set up click listener
        calcButton = (Button) myView.findViewById(R.id.ratioCalcButton);
        calcButton.setOnClickListener(this);

        return myView;
    }

    @Override
    public void onClick(View v) {
        //pull info from edittext, calculate based on constant and output to other edittext
        //TODO: add option to change ratio and assign to recipes
        int groundsWeight = Integer.parseInt(coffeeEditText.getText().toString());
        double waterWeight = groundsWeight * ratio;
        NumberFormat resultFormat = new DecimalFormat("#0");

        waterEditText.setText(resultFormat.format(waterWeight));
    }
}
