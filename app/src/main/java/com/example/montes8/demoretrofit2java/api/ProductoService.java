package com.example.montes8.demoretrofit2java.api;

import com.example.montes8.demoretrofit2java.model.Producto;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ProductoService {

    @GET("produtos/{idProducto}")
    Call<Producto> optenerProductoSegunId(@Path("idProducto")int idProducto);

    @GET("produtos")
    Call<ArrayList<Producto>> optenerProductosLista();

    @GET("produtos")
    Call<ArrayList<Producto>> optenerProductos(@Query("buscar")String buscarParam);

    @POST("productos")
    Call<Void>  registrar(@Body Producto producto);

    @PUT("productos/{idProducto}")
    Call<Void> actulizar(@Path("idProdcuto") int idProducto,@Body Producto producto);

    @DELETE("productos/{idProducto}")
    Call<Void> eliminar(@Path("idProducto") int idproducto);
}