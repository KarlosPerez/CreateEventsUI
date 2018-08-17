package projects.karlosp3rez.createeventsui.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import projects.karlosp3rez.createeventsui.Interface.IItemClickListener;
import projects.karlosp3rez.createeventsui.Model.Categoria;
import projects.karlosp3rez.createeventsui.R;

public class CategoriaAdapter extends RecyclerView.Adapter<CategoriaAdapter.CategoriaViewHolder> {

    Context context;
    ArrayList<Categoria> listaCategoria;
    

    public CategoriaAdapter(Context context, ArrayList<Categoria> listaCategoria) {
        this.context = context;
        this.listaCategoria = listaCategoria;
    }

    @Override
    public CategoriaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_category_layout,parent,false);
        return new CategoriaViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final CategoriaViewHolder holder, int position) {
        Categoria categoria = listaCategoria.get(position);
        holder.txt_categoria.setText(categoria.getNombreCategoria());
        holder.setiItemClickListener(new IItemClickListener() {
            @Override
            public void onClick(View v) {
                holder.txt_categoria.setTextColor(ContextCompat.getColor(context, R.color.textColor));
                holder.txt_categoria.setBackgroundResource(R.drawable.category_button_checked);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaCategoria.size();
    }

    public class CategoriaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        
        private TextView txt_categoria;
        IItemClickListener iItemClickListener;

        public void setiItemClickListener(IItemClickListener iItemClickListener) {
            this.iItemClickListener = iItemClickListener;
        }

        public CategoriaViewHolder(View itemView) {
            super(itemView);

            txt_categoria = (TextView) itemView.findViewById(R.id.item_categoria);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            iItemClickListener.onClick(view);
        }
    }
}
