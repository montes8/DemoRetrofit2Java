package com.example.montes8.demoretrofit2java.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.montes8.demoretrofit2java.R;
import com.example.montes8.demoretrofit2java.adapter.ListaproductosAdapter;
import com.example.montes8.demoretrofit2java.api.ProductoService;
import com.example.montes8.demoretrofit2java.api.RetrofitCreator;
import com.example.montes8.demoretrofit2java.model.Producto;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class HomeActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private ListaproductosAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        recyclerView = findViewById(R.id.my_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new ListaproductosAdapter();

       listarProductos();




    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public void listarProductos(){
        Retrofit retrofit = RetrofitCreator.getInstance();
        ProductoService service=retrofit.create(ProductoService.class);
        Call<ArrayList<Producto>> listaProdcutoCallback = service.optenerProductosLista();

        listaProdcutoCallback.enqueue(new Callback<ArrayList<Producto>>() {
                                          @Override
                                          public void onResponse(Call<ArrayList<Producto>> call, Response<ArrayList<Producto>> response) {
                                              ArrayList<Producto> productoList =response.body();
                                              mAdapter.addList(productoList);
                                              recyclerView.setAdapter(mAdapter);
                                              Log.d("lista productos","lista ="+productoList);
                                              Toast.makeText(HomeActivity.this,"llegaste aqui",Toast.LENGTH_SHORT).show();
                                          }

                                          @Override
                                          public void onFailure(Call<ArrayList<Producto>> call, Throwable t) {
                                              Toast.makeText(HomeActivity.this,"error aqui",Toast.LENGTH_SHORT).show();
                                          }
                                      }


        );

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.option_agregar:
                Intent intent = new Intent(HomeActivity.this,FormularioProductoActivity.class);
                startActivity(intent);
                return true;

        }
        return super.onOptionsItemSelected(item);
    }
}
