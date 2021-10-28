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
            xTurn = false;
            PlayerTxt.setText(R.string.player_o);
        }
        else if(clicked.getText() == ("") && !xTurn){
            clicked.setText("O");
            xTurn = true;
            PlayerTxt.setText(R.string.player_x);
        }
    }
}