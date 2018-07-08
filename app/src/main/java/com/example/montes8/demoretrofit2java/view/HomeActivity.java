package com.example.montes8.demoretrofit2java.view;


import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
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

public class HomeActivity extends AppCompatActivity implements SearchView.OnQueryTextListener{

    private ProgressBar progressBar;
    private RecyclerView recyclerView;
    private ListaproductosAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


      ajustarToolbarHome();





       }
       public void ajustarToolbarHome(){

           progressBar = findViewById(R.id.pgCargando);
           Toolbar toolbar = (Toolbar) findViewById(R.id.homeToolbar);
           setSupportActionBar(toolbar);
           getSupportActionBar().setTitle("Lista de Productos");
       }

    @Override
    protected void onResume() {
        super.onResume();
        listarProductos("");
    }

    public void listarProductos(String buscador  ){

        recyclerView = findViewById(R.id.my_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new ListaproductosAdapter();

        Retrofit retrofit = RetrofitCreator.getInstance();
        ProductoService service=retrofit.create(ProductoService.class);
        Call<ArrayList<Producto>> listaProdcutoCallback = service.optenerProductos(buscador);

        listaProdcutoCallback.enqueue(new Callback<ArrayList<Producto>>() {
                                          @Override
                                          public void onResponse(Call<ArrayList<Producto>> call, Response<ArrayList<Producto>> response) {
                                              recyclerView.setVisibility(View.VISIBLE);
                                              progressBar.setVisibility(View.GONE);

                                              if(response.code()== 200){
                                              ArrayList<Producto> productoList =response.body();
                                              mAdapter.addList(productoList);
                                              recyclerView.setAdapter(mAdapter);
                                              Toast.makeText(HomeActivity.this," Lista cargada",Toast.LENGTH_SHORT).show();

                                              }else if(response.code() == 204 ){
                                                  Toast.makeText(HomeActivity.this," n hay lista",Toast.LENGTH_SHORT).show();
                                                  mAdapter.removerLista();
                                              }else{
                                                  Toast.makeText(HomeActivity.this," Ocurrio otro tipo de error",Toast.LENGTH_SHORT).show();

                                              }
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
        MenuItem item =  menu.findItem(R.id.item_buscador);
        SearchView searchView =(SearchView)MenuItemCompat.getActionView(item);

        searchView.setOnQueryTextListener(this);

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

    @Override
    public boolean onQueryTextSubmit(String query) {

        listarProductos(query.toString());
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {

        if(newText.isEmpty()){
            listarProductos("");
        }
        return false;
    }
}
