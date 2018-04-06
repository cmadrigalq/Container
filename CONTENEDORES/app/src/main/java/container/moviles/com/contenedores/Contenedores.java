package container.moviles.com.contenedores;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
public class Contenedores extends AppCompatActivity {
    String [] provincias = {
            "San Carlos", "Talamanca", "Pococí",
            "Sarapiquí", "Puntarenas","Limón",
            "Golfito","León Cortés","Santo Domingo"
    };
    static final String[] numbers = new String[] {
            "Item 1 Arroz.",
            "Item 2 Frijoles.",
            "Item 3 Tomate.",
            "Item 4 Lechuga.",
            "Item 5 Pepino.",
            "Item 6 Almendras.",
            "Item 7 Cas.",
            "Item 8 Limón.",
            "Item 9 Papaya.",
            "Item 10 Camote.",
            "Item 11 Berenjena",
            "Item 12 Zuccini",
            "Item 13 Yuca",
            "Item 14 Carne",
            "Item 15 Chayote"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contenedore);
        init();
    }
    void init(){
        TabHost th = (TabHost)super.findViewById(R.id.host);
        th.setup();
        TabSpec ts1 = th.newTabSpec("t1");
        ts1.setIndicator("Radio Group");
        ts1.setContent(R.id.Radio_Group);
        th.addTab(ts1);

        TabSpec ts2 = th.newTabSpec("t2");
        ts2.setIndicator("List View");
        ts2.setContent(R.id.ListView);
        th.addTab(ts2);

        TabSpec ts3 = th.newTabSpec("t3");
        ts3.setIndicator("Grid View");
        ts3.setContent(R.id.Grid);
        th.addTab(ts3);

        TabSpec ts4 = th.newTabSpec("t4");
        ts4.setIndicator("Web View");
        ts4.setContent(R.id.WebV);
        th.addTab(ts4);

        TabSpec ts5 = th.newTabSpec("t5");
        ts5.setIndicator("Search View");
        ts5.setContent(R.id.SV);
        th.addTab(ts5);

        WebView myWebView = (WebView) findViewById(R.id.wb);
        myWebView.loadUrl("https://www.google.com");

        ArrayAdapter<String> adapterG = new ArrayAdapter<String>(this,
                                                                android.R.layout.simple_list_item_1,
                                                                 numbers);

        ((GridView)findViewById(R.id.gridview1)).setAdapter(adapterG);

        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(
                        this,
                        android.R.layout.simple_list_item_1,
                        provincias
                );
        ListView lista = (ListView)super.findViewById(R.id.Lista);
        lista.setAdapter(adapter);


    }
}
