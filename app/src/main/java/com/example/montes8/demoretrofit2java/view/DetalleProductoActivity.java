package com.example.montes8.demoretrofit2java.view;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.montes8.demoretrofit2java.R;
import com.example.montes8.demoretrofit2java.api.ProductoService;
import com.example.montes8.demoretrofit2java.api.RetrofitCreator;
import com.example.montes8.demoretrofit2java.model.Producto;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

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
        eliminar = findViewById(R.id.button_eliminar);
        actulizar = findViewById(R.id.button_actualizar);

        funcionesProducto();





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

    public void funcionesProducto(){

        Bundle extras = getIntent().getExtras();
        final Producto datosProducto = extras.getParcelable("detalleproducto");
        Retrofit retrofit = RetrofitCreator.getInstance();
        final ProductoService service=retrofit.create(ProductoService.class);

        nombredetalle.setText(datosProducto.getNombre());
        preciodetalle.setText(String.valueOf(datosProducto.getPrecio()));
        lotedetalle.setText(String.valueOf(datosProducto.getLote()));
        stockdetalle.setText(String.valueOf(datosProducto.getStock()));
        descripciondetalle.setText(datosProducto.getDescripcion());



        eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder dialodBuilder = new AlertDialog.Builder(DetalleProductoActivity.this);
                dialodBuilder.setTitle("Eliminar");
                dialodBuilder.setPositiveButton("SI", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(DetalleProductoActivity.this,"daste clik aqui en si",Toast.LENGTH_SHORT).show();

                        Call<Void> eliminarproductoCallback = service.eliminar(datosProducto.getId());
                        eliminarproductoCallback.enqueue(new Callback<Void>() {
                            @Override
                            public void onResponse(Call<Void> call, Response<Void> response) {

                                Log.d("repsonseborrado","eliminar"+response.code());

                                if(response.code()==200) {
                                    Toast.makeText(DetalleProductoActivity.this, "Prodcuto Eliminado", Toast.LENGTH_SHORT).show();
                                }else{
                                    Toast.makeText(DetalleProductoActivity.this, "Ocurrio un Error al Eliminar", Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void onFailure(Call<Void> call, Throwable t) {

                                Toast.makeText(DetalleProductoActivity.this, "Ocurrio un Error", Toast.LENGTH_SHORT).show();

                            }
                        });
                    }
                });
                dialodBuilder.setNegativeButton("NO",null);

                dialodBuilder.show();

            }
        });

        actulizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentdetalle = new Intent(DetalleProductoActivity.this,FormularioProductoActivity.class);
                intentdetalle.putExtra("actualizaProducto",datosProducto);
                startActivity(intentdetalle);
            }
        });
    }

}
