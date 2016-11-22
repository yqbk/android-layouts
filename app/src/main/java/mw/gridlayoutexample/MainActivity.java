package mw.gridlayoutexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click(View view){
        TextView editText = (TextView)findViewById(R.id.editText);
        Button button = (Button)view;
        String text = editText.getText().toString() + button.getText() ;
        editText.setText(text);
    }

    public void equals(View view){
        TextView editText = (TextView)findViewById(R.id.editText);
        editText.setText("");
    }

}
