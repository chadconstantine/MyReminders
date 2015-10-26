package chaddosapps.myreminders;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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
public void buttonOnClick(View v) {
    Button button=(Button) v;
    TextView textView = (TextView)findViewById(R.id.textView2);
    EditText editText= (EditText)findViewById(R.id.editText);
    SharedPreferences mSettings = getSharedPreferences("Settings", 0);
    SharedPreferences.Editor editor = mSettings.edit();
    editor.putString("reminder", textView.getText().toString());
    editor.commit();
    String minders = mSettings.getString("reminder", "missing");
    textView.setText(minders);
}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
