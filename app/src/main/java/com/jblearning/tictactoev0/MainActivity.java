package com.jblearning.tictactoev0;

import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.util.Log;

/*
    https://developer.android.com/reference/android/widget/GridLayout.html
    https://blog.stylingandroid.com/gridlayout-part-1/
 */
public class MainActivity extends AppCompatActivity {
    private Button [][] buttons;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        // setContentView( R.layout.activity_main );
        buildGuiByCode( ); //
    }

    public void buildGuiByCode( ) {
        // Get width of the screen
        Point size = new Point( );
        getWindowManager( ).getDefaultDisplay( ).getSize( size );
        int w = size.x / TicTacToe.SIDE;

        // Create the layout manager as a GridLayout
        GridLayout gridLayout = new GridLayout( this );
        gridLayout.setColumnCount( TicTacToe.SIDE );
        gridLayout.setRowCount( TicTacToe.SIDE );

        // Create the buttons and add them to gridLayout
        buttons = new Button[TicTacToe.SIDE][TicTacToe.SIDE];
        ButtonHandler bh = new ButtonHandler();
        for( int row = 0; row < TicTacToe.SIDE; row++ ) {
            for( int col = 0; col < TicTacToe.SIDE; col++ ) {
                buttons[row][col] = new Button( this );
                gridLayout.addView( buttons[row][col], w, w );
            }
        }

        // Set gridLayout as the View of this Activity
        setContentView( gridLayout );
    } // end buildGuiByCode

    public void update(int row, int col) {
        Log.w( "MainActivity", "Inside update: " + row + ", " + col );
        buttons[row][col].setText( "X" );
    }

    private class ButtonHandler implements View.OnClickListener {
        public void onClick( View v ) {
            Log.w( "MainActivity", "Inside onClick, v = " + v );
            for( int row = 0; row < TicTacToe.SIDE; row++ )
                for( int column = 0; column < TicTacToe.SIDE; column++ )
                    if ( v == buttons[row][column] )
                        update(row, column);
        }
    } // end ButtonHandler
} // end main class
