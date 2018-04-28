package container.moviles.com.contenedores;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TabHost;
import android.widget.Toast;

public class Contenedores extends AppCompatActivity {

    RadioButton r1,r2,r3,r4,r5,r6;
    RadioGroup radiogroup ;
    Button btn;
    TabHost th;
    void initCosas(){
        r1 = (RadioButton) findViewById(R.id.Radio1);
        r2 = (RadioButton) findViewById(R.id.Radio2);
        r3 = (RadioButton) findViewById(R.id.Radio3);
        r4 = (RadioButton) findViewById(R.id.radio4);
        r5 = (RadioButton) findViewById(R.id.radio5);
        r6 = (RadioButton) findViewById(R.id.radio6);
        radiogroup = (RadioGroup) findViewById(R.id.rg);
        btn = (Button) findViewById(R.id.btn);
    }

    String[] horarios_yoga = {
            "Lunes 10:00a.m.", "Lunes 6:00p.m.", "Martes 8:00a.m.",
            "Miércoles 5:00p.m.", "Jueves 9:00a.m.", "Domingo 9:00a.m."
    };
    String[] horarios_pilates = {
            "Lunes 11:00a.m.", "Lunes 5:00p.m.", "Martes 9:00a.m.",
            "Miércoles 4:00p.m.", "Jueves 10:00a.m.", "Domingo 8:00a.m."
    };
    String[] horarios_funcional = {
            "Lunes 7:00a.m.", "Lunes 4:00p.m.", "Martes 10:00a.m.",
            "Miércoles 6:00p.m.", "Jueves 7:00a.m.", "Domingo 7:00a.m."
    };
    String[] horarios_crossfit = {
            "Lunes 9:00a.m.", "Lunes 3:00p.m.", "Martes 11:00a.m.",
            "Miércoles 3:00p.m.", "Jueves 8:00a.m.", "Domingo 6:00a.m."
    };
    String[] horarios_danza = {
            "Lunes 10:00a.m.", "Lunes 2:00p.m.", "Martes 9:00a.m.",
            "Miércoles 2:00p.m.", "Jueves 8:00a.m.", "Domingo 7:00a.m."
    };
    String[] horarios_zumba = {
            "Lunes 8:00a.m.", "Lunes 6:00p.m.", "Martes 8:00a.m.",
            "Miércoles 6:00p.m.", "Jueves 9:00a.m.", "Domingo 8:00a.m."
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contenedore);
        initCosas();
        init();
    }

    void init() {
        th =  (TabHost)super.findViewById(R.id.host);
        th.setup();
        TabHost.TabSpec ts1 = th.newTabSpec("t1");
        ts1.setIndicator("CLASES");
        ts1.setContent(R.id.Radio_Group);
        th.addTab(ts1);
        BotonClases();

        TabHost.TabSpec ts2 = th.newTabSpec("t2");
        ts2.setIndicator("HORARIOS");
        ts2.setContent(R.id.ListView);
        th.addTab(ts2);

        TabHost.TabSpec ts3 = th.newTabSpec("t3");
        ts3.setIndicator("GALERIA");
        ts3.setContent(R.id.Grid);
        th.addTab(ts3);
        GridView gridview = (GridView) findViewById(R.id.gridview1);
        gridview.setAdapter(new ImageAdapter(this));
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

            }
        });

        TabHost.TabSpec ts4 = th.newTabSpec("t4");
        ts4.setIndicator("RUTINAS");
        ts4.setContent(R.id.WebV);
        th.addTab(ts4);
        WebView myWebView = (WebView) findViewById(R.id.wb);

        //myWebView.loadUrl("https://www.youtube.com/user/gymvirtual/playlists");
        //myWebView.loadUrl("https://www.google.com");
        th.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                if( tabId.equals("t4")){
                    WebView myWebView = (WebView) findViewById(R.id.wb);

                    myWebView.loadUrl("https://www.youtube.com/user/gymvirtual/playlists");

                }
            }
        });
    }

public void BotonClases(){
    btn.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick (View view){
            int selectedId = radiogroup.getCheckedRadioButtonId();// get selected radio button from radioGroup
            RadioButton radioButton = (RadioButton) findViewById(selectedId);// find the radio button by returned id
            switch (radioButton.getId()) {
                case (R.id.Radio1):
                    listaHorarios(horarios_yoga);
                    break;
                case R.id.Radio2:
                    listaHorarios(horarios_pilates);
                    break;
                case R.id.Radio3:
                    listaHorarios(horarios_funcional);
                    break;
                case R.id.radio4:
                    listaHorarios(horarios_crossfit);
                    break;
                case R.id.radio5:
                    listaHorarios(horarios_danza);
                    break;
                case R.id.radio6:
                   listaHorarios(horarios_zumba);
                    break;
            }
            Contenedores.this.th.setCurrentTab(1);
            Toast.makeText(Contenedores.this,
                    radioButton.getText(), Toast.LENGTH_SHORT).show();
        }
    });
 }
    void listaHorarios(String[] list) {
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(
                        this,
                        android.R.layout.simple_list_item_checked,
                        list
                );
        ListView lista = (ListView)super.findViewById(R.id.Lista);
        lista.setAdapter(adapter);
    }
}
