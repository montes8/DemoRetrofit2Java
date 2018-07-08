package com.example.montes8.demoretrofit2java.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.util.*;


import com.example.montes8.demoretrofit2java.R;
import com.example.montes8.demoretrofit2java.api.ProductoService;
import com.example.montes8.demoretrofit2java.api.RetrofitCreator;
import com.example.montes8.demoretrofit2java.model.Producto;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class FormularioProductoActivity extends AppCompatActivity {

    private EditText nombre,precio,lote,stock,descripcion;
    private Button guargarProducto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_producto);

        nombre = findViewById(R.id.edit_text_nombre);
        precio = findViewById(R.id.edit_text_precio);
        lote = findViewById(R.id.edit_lote);
        stock = findViewById(R.id.edit_stock);
        descripcion = findViewById(R.id.edit_text_descripcion);
        guargarProducto = findViewById(R.id.button_guardar_producto);


        ajustarToolbarHome();
        guardarProducto();









    }

    public void ajustarToolbarHome(){


        Toolbar toolbars = (Toolbar) findViewById(R.id.formularioToolbar);
        setSupportActionBar(toolbars);
        getSupportActionBar().setTitle("Guardar de Productos");
        toolbars.setNavigationIcon(R.drawable.ic_atras);
        toolbars.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    public void guardarProducto(){
        Bundle extras = getIntent().getExtras();
        final Producto actualizaProducto = extras.getParcelable("actualizaProducto");
        Retrofit retrofit = RetrofitCreator.getInstance();
        final ProductoService service = retrofit.create(ProductoService.class);


        if (actualizaProducto == null) {

            guargarProducto.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    try {
                        String nombrep = nombre.getText().toString();
                        double preciop = Double.parseDouble(precio.getText().toString());
                        int lotep = Integer.parseInt(lote.getText().toString());
                        int stockp = Integer.parseInt(stock.getText().toString());
                        String desccripcionp = descripcion.getText().toString();

                        Producto producto = new Producto(0, nombrep, preciop, lotep, stockp, desccripcionp);

                        Call<Void> guardarProductoCallback = service.registrar(producto);

                        guardarProductoCallback.enqueue(new Callback<Void>() {
                            @Override
                            public void onResponse(Call<Void> call, Response<Void> response) {
                                Toast.makeText(FormularioProductoActivity.this, "Producto Guardado", Toast.LENGTH_SHORT).show();
                                nombre.setText("");
                                precio.setText("");
                                lote.setText("");
                                stock.setText("");
                                descripcion.setText("");
                            }

                            @Override
                            public void onFailure(Call<Void> call, Throwable t) {
                                Toast.makeText(FormularioProductoActivity.this, "error al guardar", Toast.LENGTH_SHORT).show();
                            }
                        });

                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
            });


        }else{
            nombre.setText(actualizaProducto.getNombre());
            precio.setText(String.valueOf(actualizaProducto.getPrecio()));
            stock.setText(String.valueOf(actualizaProducto.getStock()));
            lote.setText(String.valueOf(actualizaProducto.getLote()));
            descripcion.setText(actualizaProducto.getDescripcion());

            guargarProducto.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    try {

                        String nombrea = nombre.getText().toString();
                        double precioa = Double.parseDouble(precio.getText().toString());
                        int lotea = Integer.parseInt(lote.getText().toString());
                        int stocka = Integer.parseInt(stock.getText().toString());
                        String desccripciona = descripcion.getText().toString();

                        int idProducto = actualizaProducto.getId();
                        Producto productoActulizar = new Producto(0, nombrea, precioa, lotea, stocka, desccripciona);
                        Call<Void> actualizar = service.actulizar(idProducto,productoActulizar);

                        actualizar.enqueue(new Callback<Void>() {
                            @Override
                            public void onResponse(Call<Void> call, Response<Void> response) {

                                Toast.makeText(FormularioProductoActivity.this, "Producto Actulizado", Toast.LENGTH_SHORT).show();

                            }

                            @Override
                            public void onFailure(Call<Void> call, Throwable t) {

                                Toast.makeText(FormularioProductoActivity.this, "Ocurrio un error", Toast.LENGTH_SHORT).show();
                            }
                        });




                }catch (NumberFormatException e){
                    e.printStackTrace();
                    }
                }
            });

        }


    }
}
