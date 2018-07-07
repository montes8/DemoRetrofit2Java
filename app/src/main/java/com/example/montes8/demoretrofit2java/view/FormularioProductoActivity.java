package com.example.montes8.demoretrofit2java.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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


 try {
     String nombrep = nombre.getText().toString();
     double preciop = Double.parseDouble(precio.getText().toString());
     int lotep = Integer.parseInt(lote.getText().toString());
     int stockp =Integer.parseInt(stock.getText().toString());
     String desccripcionp = descripcion.getText().toString();

      /*  Producto producto = new Producto(0,nombrep,preciop,lotep,stockp,desccripcionp);

        Retrofit retrofit = RetrofitCreator.getInstance();
        ProductoService service=retrofit.create(ProductoService.class);
        Call<Void> guardarProductoCallback = service.registrar(producto);

        guardarProductoCallback.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {

                Toast.makeText(FormularioProductoActivity.this,"Producto Guardado",Toast.LENGTH_SHORT).show();

                nombre.setText("");
                precio.setText("");
                lote.setText("");
                stock.setText("");
                descripcion.setText("");

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(FormularioProductoActivity.this,"error al guardar",Toast.LENGTH_SHORT).show();

            }
        });
*/
 }catch (NumberFormatException e){
     e.printStackTrace();
 }









    }
}
