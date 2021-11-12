package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private boolean xTurn = true;
    private TextView PlayerTxt;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    Button newGame;

    String[] buttons = {"", "", "", "", "", "", "", "", ""};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);

        newGame = findViewById(R.id.newGameBtn);

        PlayerTxt = findViewById(R.id.PlayerTxt);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);

        newGame.setOnClickListener(this::newGameOnClick);
    }

    public void newGame(){
        button1.setText("");
        button2.setText("");
        button3.setText("");
        button4.setText("");
        button5.setText("");
        button6.setText("");
        button7.setText("");
        button8.setText("");
        button9.setText("");

        enableButtons();

        PlayerTxt.setText(R.string.player_x);
        xTurn = true;
    }

    public void newGameOnClick(View v){
        newGame();
    }

    @Override
    public void onClick(View v) {
        Button clicked = findViewById(v.getId());

        if(clicked.getText() == ("") && xTurn){
            clicked.setText("X");
            if(checkForWin()){
                disableButtons();
                PlayerTxt.setText(R.string.player_x_win);
            }
            else if(checkForTies()){
                disableButtons();
                PlayerTxt.setText(R.string.tie);
            }
            else{
                xTurn = false;
                PlayerTxt.setText(R.string.player_o);
            }

        }
        else if(clicked.getText() == ("") && !xTurn){
            clicked.setText("O");
            if(checkForWin()){
                disableButtons();
                PlayerTxt.setText(R.string.player_o_win);
            }
            else if(checkForTies()){
                disableButtons();
                PlayerTxt.setText(R.string.tie);
            }
            else{
                xTurn = true;
                PlayerTxt.setText(R.string.player_x);
            }

        }
    }

    public void makeArray(){
        buttons[0] = button1.getText().toString();
        buttons[1] = button2.getText().toString();
        buttons[2] = button3.getText().toString();
        buttons[3] = button4.getText().toString();
        buttons[4] = button5.getText().toString();
        buttons[5] = button6.getText().toString();
        buttons[6] = button7.getText().toString();
        buttons[7] = button8.getText().toString();
        buttons[8] = button9.getText().toString();
    }

    public boolean checkForWin(){
        makeArray();
        //check horizontal
        for(int i = 0; i < 7; i = i + 3){
            if(buttons[i].equals(buttons[i + 1]) && buttons[i].equals(buttons[i + 2]) && !buttons[i].equals("")){
                return true;
            }
        }
        //check vertical
        for(int i = 0; i < 3; i++){
            if(buttons[i].equals(buttons[i + 3]) && buttons[i].equals(buttons[i + 6]) && !buttons[i].equals("")){
                return true;
            }
        }
        //check diagonals
        if(buttons[0].equals(buttons[4]) && buttons[0].equals(buttons[8]) && !buttons[0].equals("")){
            return true;
        }
        if(buttons[2].equals(buttons[4]) && buttons[2].equals(buttons[6]) && !buttons[2].equals("")){
            return true;
        }
            return false;
    }

    public boolean checkForTies(){
        for(int i = 0; i < 9; i++){
            if(buttons[i].equals("")){
                return false;
            }
        }
        return true;
    }

    public void enableButtons(){
        button1.setEnabled(true);
        button2.setEnabled(true);
        button3.setEnabled(true);
        button4.setEnabled(true);
        button5.setEnabled(true);
        button6.setEnabled(true);
        button7.setEnabled(true);
        button8.setEnabled(true);
        button9.setEnabled(true);
    }

    public void disableButtons(){
        button1.setEnabled(false);
        button2.setEnabled(false);
        button3.setEnabled(false);
        button4.setEnabled(false);
        button5.setEnabled(false);
        button6.setEnabled(false);
        button7.setEnabled(false);
        button8.setEnabled(false);
        button9.setEnabled(false);
    }
}