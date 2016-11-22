package mw.linearlayoutexample;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void send(View view){
        EditText messageEditText = (EditText)findViewById(R.id.messageTextView);
        EditText toEditText = (EditText)findViewById(R.id.toTextView);
        EditText subjectEditText = (EditText)findViewById(R.id.subjectTextView);
        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle(R.string.alertDialogTitle);
        alertDialogBuilder.setMessage(String.format(getResources().getString(R.string.alertDialogMessage), messageEditText.getText(), subjectEditText.getText(), toEditText.getText()));
        alertDialogBuilder.setNeutralButton(android.R.string.ok,null);
        alertDialogBuilder.show();
    }

}
