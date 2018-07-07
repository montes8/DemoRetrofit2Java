package com.example.montes8.demoretrofit2java.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.montes8.demoretrofit2java.R;
import com.example.montes8.demoretrofit2java.model.Producto;

public class DetalleProductoActivity extends AppCompatActivity {

    TextView nombredetalle,preciodetalle,lotedetalle,stockdetalle,descripciondetalle;
    Button   actulizar,eliminar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_producto);
        ajustandoToolbarDetalle();

        nombredetalle = findViewById(R.id.nombre_producto_detalle);
        preciodetalle = findViewById(R.id.precio_producto_detalle);
        lotedetalle = findViewById(R.id.lote_producto_detalle);
        stockdetalle = findViewById(R.id.stock_detalle_producto);
        descripciondetalle = findViewById(R.id.detalle_producto_detalle);

        Bundle extras = getIntent().getExtras();
        Producto datosProducto = extras.getParcelable("detalleproducto");

        nombredetalle.setText(datosProducto.getNombre());
        preciodetalle.setText(String.valueOf(datosProducto.getPrecio()));
        lotedetalle.setText(String.valueOf(datosProducto.getLote()));
        stockdetalle.setText(String.valueOf(datosProducto.getStock()));
        descripciondetalle.setText(datosProducto.getDescripcion());




    }

    public void ajustandoToolbarDetalle(){
        Toolbar toolbardetalle = (Toolbar) findViewById(R.id.detalleToolbar);
        setSupportActionBar(toolbardetalle);
        getSupportActionBar().setTitle("Detalle de Producto");
        toolbardetalle.setNavigationIcon(R.drawable.ic_atras);
        toolbardetalle.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }
}
