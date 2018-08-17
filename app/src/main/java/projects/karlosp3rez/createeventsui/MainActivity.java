package projects.karlosp3rez.createeventsui;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import projects.karlosp3rez.createeventsui.Model.Categoria;
import projects.karlosp3rez.createeventsui.Model.Ticket;
import projects.karlosp3rez.createeventsui.adapter.CategoriaAdapter;
import projects.karlosp3rez.createeventsui.adapter.TicketAdapter;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recycler_categoria, recycler_tickets;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Ubuntu-C.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build());
        setContentView(R.layout.activity_main);

        recycler_categoria = findViewById(R.id.recycler_categoria);
        recycler_categoria.setHasFixedSize(true);
        recycler_categoria.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        buildCategoriaList();

        recycler_tickets = findViewById(R.id.recycler_tickets);
        recycler_tickets.setHasFixedSize(true);
        recycler_tickets.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        buildTicketList();
    }

    private void buildTicketList() {
        ArrayList<Ticket> listaTicket = new ArrayList<>();
        listaTicket.add(new Ticket("Premium Ticket", "50€", "100 Seats"));
        listaTicket.add(new Ticket("Vip Ticket", "100€", "50 Seats"));
        listaTicket.add(new Ticket("Platinum Ticket", "200€", "20 Seats"));
        TicketAdapter adapter = new TicketAdapter(this, listaTicket);
        recycler_tickets.setAdapter(adapter);
    }

    private void buildCategoriaList() {
        ArrayList<Categoria> listaCategoria = new ArrayList<>();
        listaCategoria.add(new Categoria("Hip-Hop"));
        listaCategoria.add(new Categoria("Battle"));
        listaCategoria.add(new Categoria("Music"));
        listaCategoria.add(new Categoria("Rap"));
        listaCategoria.add(new Categoria("Other"));
        CategoriaAdapter adapter = new CategoriaAdapter(this,listaCategoria);
        recycler_categoria.setAdapter(adapter);
    }
}
