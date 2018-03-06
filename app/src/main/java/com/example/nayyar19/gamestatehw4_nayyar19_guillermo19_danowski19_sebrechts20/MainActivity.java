package com.example.nayyar19.gamestatehw4_nayyar19_guillermo19_danowski19_sebrechts20;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText editTextbox;
    Button runTestButton;
    String outputString1;
    String outputString2;
    String outputString4;

    //Next three strings there to deliniate between different
    //object values
    String fstInstance = "\t First Instance Values \n\n";
    String sndInstance = "\t Second Instance Values \n\n";
    String fthInstance = "\t Fourth Instance Values \n\n";
    String output1, output2;
    LudoState firstInstance;
    LudoState secondInstance;
    LudoState thirdInstance;
    LudoState fourthInstance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("oncreate","\n \n ASSERTION ASSERTION ASSERTION ASSWERTION 0 \n \n");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       editTextbox = (EditText)findViewById(R.id.EditTextBox);

       runTestButton = (Button)findViewById(R.id.RunTestButton);
       runTestButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        firstInstance = new LudoState();
        secondInstance = new LudoState(firstInstance);

        //First Instance values to call methods
        firstInstance.setPlayerToMove(4);
        firstInstance.setDiceVal(6);
        firstInstance.getDiceVal();
        //checkAvailableMoves calls every single method that is in our
        //ludo state class. We have used the firstinstnace in two diferent
        //locations below to show the full functionality
        firstInstance.checkAvailableMoves(4);
        output1 = firstInstance.toString();

        //First instance values to call remianing methods that could not be called
        //with the given values
        firstInstance.setPlayerToMove(4);
        firstInstance.setDiceVal(3);
        firstInstance.checkAvailableMoves(4);
        output2 = firstInstance.toString();

        //ThirdInstance and Fourth Instance creation
        thirdInstance = new LudoState();
        fourthInstance = new LudoState(thirdInstance);

        //Oututting all values to the editText
        //outputString1 = firstInstance.toString();
        outputString2 = secondInstance.toString();
        outputString4 = fourthInstance.toString();

        editTextbox.setText(fstInstance+output1+"\n"+output2+"\n\n"+sndInstance+outputString2+"\n\n"+fthInstance+outputString4);
    }
}
