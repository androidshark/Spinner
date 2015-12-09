package armonysoft.com.spinner;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity {

    private Spinner spinner1;
    private EditText et1,et2;
    private TextView tv3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText)findViewById(R.id.et1);
        et2 = (EditText)findViewById(R.id.et2);
        tv3 = (TextView)findViewById(R.id.tv3);
        spinner1 = (Spinner)findViewById(R.id.spinner);

        //se crea un vector con la lista de spinner
        String []opciones = {"sumar","restar","multiplicar","dividir"};
        //definimos un objeto de tipo array
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,opciones);
        spinner1.setAdapter(adapter);
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

    public void operar(View view) {
        String valor1 = et1.getText().toString();
        String valor2 = et2.getText().toString();
        float nro1 = Integer.parseInt(valor1);
        float nro2 = Integer.parseInt(valor2);
        String selec=spinner1.getSelectedItem().toString();

        if(selec.equals("sumar")){
            float suma=nro1 + nro2;
            String resu = String.valueOf(suma);
            tv3.setText(resu);
        }else
        if(selec.equals("restar")){
            float resta=nro1 - nro2;
            String resu = String.valueOf(resta);
            tv3.setText(resu);
        }else
        if(selec.equals("multiplicar")){
            float multi=nro1 * nro2;
            String resu = String.valueOf(multi);
            tv3.setText(resu);
        }else
        if(selec.equals("dividir")){
            float divi=nro1 / nro2;
            String resu = String.valueOf(divi);
            tv3.setText(resu);
        }
    }
}
