package com.example.krestiknolik;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private boolean isXturn = true;
    private Button[] buttons = new Button[9];
    private int[] board = new int[9]; // 0 - пусто, 1 - X, 2 - O
    private TextView statusText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        statusText = findViewById(R.id.statusText);
        GridLayout gridLayout = findViewById(R.id.gridLayout);
        Button restartButton = findViewById(R.id.restartButton);

        for (int i = 0; i < 9; i++) {
            String buttonID = "button" + i;
            int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
            buttons[i] = findViewById(resID);
            buttons[i].setOnClickListener(new CellClickListener(i));
        }

        restartButton.setOnClickListener(v -> resetGame());
    }

    private class CellClickListener implements View.OnClickListener {
        private int index;

        public CellClickListener(int index) {
            this.index = index;
        }

        @Override
        public void onClick(View v) {
            if (board[index] != 0) return; // Ячейка уже занята

            board[index] = isXturn ? 1 : 2;
            buttons[index].setText(isXturn ? "X" : "O");
            buttons[index].setEnabled(false);

            if (checkWin()) {
                statusText.setText((isXturn ? "X" : "O") + " победил!");
                disableButtons();
            } else if (isBoardFull()) {
                statusText.setText("Ничья!");
            } else {
                isXturn = !isXturn;
                statusText.setText("Ход: " + (isXturn ? "X" : "O"));
            }
        }
    }

    private boolean checkWin() {
        int[][] winPatterns = {
                {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // горизонтали
                {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // вертикали
                {0, 4, 8}, {2, 4, 6} // диагонали
        };

        for (int[] pattern : winPatterns) {
            if (board[pattern[0]] != 0 &&
                    board[pattern[0]] == board[pattern[1]] &&
                    board[pattern[1]] == board[pattern[2]]) {
                return true;
            }
        }
        return false;
    }

    private boolean isBoardFull() {
        for (int cell : board) {
            if (cell == 0) return false;
        }
        return true;
    }

    private void disableButtons() {
        for (Button button : buttons) {
            button.setEnabled(false);
        }
    }

    private void resetGame() {
        isXturn = true;
        statusText.setText("Ход: X");
        for (int i = 0; i < 9; i++) {
            board[i] = 0;
            buttons[i].setText("");
            buttons[i].setEnabled(true);
        }
    }
}