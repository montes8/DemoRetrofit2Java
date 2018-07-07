package com.example.montes8.demoretrofit2java.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.montes8.demoretrofit2java.R;
import com.example.montes8.demoretrofit2java.model.Producto;
import com.example.montes8.demoretrofit2java.view.DetalleProductoActivity;

import java.util.ArrayList;

public class ListaproductosAdapter extends RecyclerView.Adapter<ListaproductosAdapter.ProductoViewholder>{


    private ArrayList<Producto> listaProductos;

    public void addList(ArrayList<Producto> listaProductos){
       this.listaProductos = listaProductos;
       notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ProductoViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.molde_llista_producto, parent, false);
        return new ProductoViewholder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductoViewholder holder, int position) {
        Producto producto = listaProductos.get(position);
        holder.nombre.setText(producto.getNombre());
        holder.precio.setText(String.valueOf(producto.getPrecio()));

        holder.setOnClickListener();


    }

    @Override
    public int getItemCount() {
        return listaProductos.size();
    }

    public static class ProductoViewholder extends RecyclerView.ViewHolder{

        Context context;
        public TextView nombre, precio;

        public ProductoViewholder(View itemView) {
            super(itemView);

            context = itemView.getContext();

            nombre = itemView.findViewById(R.id.nomdre_producto);
            precio = itemView.findViewById(R.id.precio_producto);
            }

        public void setOnClickListener(){

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context,DetalleProductoActivity.class);
                    context.startActivity(intent);
                }
            });
        }
    }
}
