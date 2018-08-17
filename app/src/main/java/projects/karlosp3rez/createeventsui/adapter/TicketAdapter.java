package projects.karlosp3rez.createeventsui.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import projects.karlosp3rez.createeventsui.Interface.IItemClickListener;
import projects.karlosp3rez.createeventsui.Model.Ticket;
import projects.karlosp3rez.createeventsui.R;

public class TicketAdapter extends RecyclerView.Adapter<TicketAdapter.TicketViewHolder> {

    Context context;
    ArrayList<Ticket> listaTicket;

    public TicketAdapter(Context context, ArrayList<Ticket> listaTicket) {
        this.context = context;
        this.listaTicket = listaTicket;
    }

    @Override
    public TicketViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_ticket_layout,parent,false);
        return new TicketViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final TicketViewHolder holder, int position) {
        Ticket ticket = listaTicket.get(position);
        holder.txt_categoria_ticket.setText(ticket.getCategoriaTicket());
        holder.txt_precio.setText(ticket.getPrecioTicket());
        holder.txt_cantidad_asientos.setText(ticket.getCantidadAsientos());
        holder.setiItemClickListener(new IItemClickListener() {
            @Override
            public void onClick(View v) {
                holder.linear_ticket.setBackgroundResource(R.drawable.ticket_button_checked);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaTicket.size();
    }

    public class TicketViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView txt_categoria_ticket, txt_precio, txt_cantidad_asientos;
        private LinearLayout linear_ticket;
        IItemClickListener iItemClickListener;

        public void setiItemClickListener(IItemClickListener iItemClickListener) {
            this.iItemClickListener = iItemClickListener;
        }

        public TicketViewHolder(View itemView) {
            super(itemView);

            txt_categoria_ticket = (TextView) itemView.findViewById(R.id.ticket_name);
            txt_precio = (TextView) itemView.findViewById(R.id.ticket_price);
            txt_cantidad_asientos = (TextView) itemView.findViewById(R.id.ticket_seats);
            linear_ticket = (LinearLayout) itemView.findViewById(R.id.linear_ticket);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            iItemClickListener.onClick(view);
        }
    }
}
