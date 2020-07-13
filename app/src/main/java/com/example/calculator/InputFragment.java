package com.example.calculator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class InputFragment extends Fragment implements View.OnClickListener {
    boolean activePlus = false, activeMinus = false, activeDivide = false, activeMultiply = false, counter = false;
    long a = 0, b = 0;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.calculate, container, false);
        return view;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        Button b0 = (Button) getView().findViewById(R.id.zero);
        b0.setOnClickListener(this);

        Button b1 = (Button) getView().findViewById(R.id.one);
        b1.setOnClickListener(this);

        Button b2 = (Button) getView().findViewById(R.id.two);
        b2.setOnClickListener(this);

        Button b3 = (Button) getView().findViewById(R.id.three);
        b3.setOnClickListener(this);

        Button b4 = (Button) getView().findViewById(R.id.four);
        b4.setOnClickListener(this);

        Button b5 = (Button) getView().findViewById(R.id.five);
        b5.setOnClickListener(this);

        Button b6 = (Button) getView().findViewById(R.id.six);
        b6.setOnClickListener(this);

        Button b7 = (Button) getView().findViewById(R.id.seven);
        b7.setOnClickListener(this);

        Button b8 = (Button) getView().findViewById(R.id.eight);
        b8.setOnClickListener(this);

        Button b9 = (Button) getView().findViewById(R.id.nine);
        b9.setOnClickListener(this);

        Button bEqual = (Button) getView().findViewById(R.id.equal);
        bEqual.setOnClickListener(this);

        Button bPlus = (Button) getView().findViewById(R.id.plus);
        bPlus.setOnClickListener(this);

        Button bMinus = (Button) getView().findViewById(R.id.minus);
        bMinus.setOnClickListener(this);

        Button bDivide = (Button) getView().findViewById(R.id.divide);
        bDivide.setOnClickListener(this);

        Button bMultiply = (Button) getView().findViewById(R.id.multiply);
        bMultiply.setOnClickListener(this);

        Button bRestart = (Button) getView().findViewById(R.id.restart);
        bRestart.setOnClickListener(this);
    }
    public void setResult(String item, String next){
        TextView result = (TextView) getView().findViewById(R.id.numbers);
        result.setText(item + next);
    }
    public void clearBooleans(){
        activePlus = false;
        activeMinus = false;
        activeDivide = false;
        activeMultiply = false;
    }
    public void onClick(View v){
        TextView prevView = (TextView) getView().findViewById(R.id.numbers);
        String prev = prevView.getText().toString();
        switch (v.getId()) {
            case R.id.zero:
                if (prev.equals("enter") || prev.equals("error")) prev = "";
                if (prev.equals("0")) setResult("", "0");
                else setResult(prev, "0");
                break;
            case R.id.one:
                if (prev.equals("enter") || prev.equals("error")) prev = "";
                if (prev.equals("0")) setResult("", "1");
                else setResult(prev, "1");
                break;
            case R.id.two:
                if (prev.equals("enter") || prev.equals("error")) prev = "";
                if (prev.equals("0")) setResult("", "2");
                else setResult(prev, "2");
                break;
            case R.id.three:
                if (prev.equals("enter") || prev.equals("error")) prev = "";
                if (prev.equals("0")) setResult("", "3");
                else  setResult(prev, "3");
                break;
            case R.id.four:
                if (prev.equals("enter") || prev.equals("error")) prev = "";
                if (prev.equals("0")) setResult("", "4");
                else setResult(prev, "4");
                break;
            case R.id.five:
                if (prev.equals("enter") || prev.equals("error")) prev = "";
                if (prev.equals("0")) setResult("", "5");
                else setResult(prev, "5");
                break;
            case R.id.six:
                if (prev.equals("enter") || prev.equals("error")) prev = "";
                if (prev.equals("0")) setResult("", "6");
                else setResult(prev, "6");
                break;
            case R.id.seven:
                if (prev.equals("enter") || prev.equals("error")) prev = "";
                if (prev.equals("0")) setResult("", "7");
                else setResult(prev, "7");
                break;
            case R.id.eight:
                if (prev.equals("enter") || prev.equals("error")) prev = "";
                if (prev.equals("0")) setResult("", "8");
                else setResult(prev, "8");
                break;
            case R.id.nine:
                if (prev.equals("enter") || prev.equals("error")) prev = "";
                if (prev.equals("0")) setResult("", "9");
                else setResult(prev, "9");
                break;
            case R.id.equal:
                if (!prev.equals("enter")) {
                    if (counter) b = Integer.parseInt(prev);
                    if (activePlus) prevView.setText(String.valueOf(a += b));
                    else if (activeMinus) prevView.setText(String.valueOf(a -= b));
                    else if (activeDivide) {
                        if(b == 0) prevView.setText("error");
                        else prevView.setText(String.valueOf(a /= b));;
                    }
                    else if (activeMultiply) prevView.setText(String.valueOf(a *= b));;
                    //prevView.setText(String.valueOf(a));
                    //clearBooleans();
                    counter = false;
                }
                break;
            case R.id.plus:
                if (!prev.equals("enter") && !prev.equals("error")) {
                    activePlus = true;
                    activeMinus = false;
                    activeDivide = false;
                    activeMultiply = false;
                    a = Integer.parseInt(prev);
                    counter = true;
                    prevView.setText("enter");
                }
                break;
            case R.id.minus:
                if (!prev.equals("enter") && !prev.equals("error")) {
                    activePlus = false;
                    activeMinus = true;
                    activeDivide = false;
                    activeMultiply = false;
                    a = Integer.parseInt(prev);
                    counter = true;
                    prevView.setText("enter");
                }
                break;
            case R.id.divide:
                if (!prev.equals("enter") && !prev.equals("error")) {
                    activePlus = false;
                    activeMinus = false;
                    activeDivide = true;
                    activeMultiply = false;
                    a = Integer.parseInt(prev);
                    counter = true;
                    prevView.setText("enter");
                }
                break;
            case R.id.multiply:
                if (!prev.equals("enter") && !prev.equals("error")) {
                    activePlus = false;
                    activeMinus = false;
                    activeDivide = false;
                    activeMultiply = true;
                    a = Integer.parseInt(prev);
                    counter = true;
                    prevView.setText("enter");
                }
                break;
            case R.id.restart:
                prevView.setText("enter");
                clearBooleans();
                break;
        }
    }
}
