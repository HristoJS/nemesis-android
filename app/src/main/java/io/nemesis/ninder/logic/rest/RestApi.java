package io.nemesis.ninder.logic.rest;

import java.util.List;
import java.util.Map;

import io.nemesis.ninder.logic.model.Product;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.http.QueryMap;

/**
 * @author Philip
 * @since 2015-11-24
 */
public interface RestApi {
    // XXX Retrofit supports synchronous and asynchronous request execution.
    // Users define the concrete execution by setting a return type (synchronous) or not (asynchronous) to service methods.

    @GET("/api/c/womens")
    List<Product> getProductList();

    @GET("/api/c/womens")
    List<Product> getProductList(@QueryMap Map<String, String> query);

    @GET("/api/c/womens")
    void getProductListAsync(retrofit.Callback<List<Product>> callback);

    @GET("/api/c/womens")
    void getProductListAsync(@QueryMap Map<String, String> query, retrofit.Callback<List<Product>> callback);

    @GET("/api/{productURL}")
    Product getProductDetail(@Path(value="productURL", encode=false) String url);

    @GET("/api{productURL}")
    void getProductDetailAsync(@Path(value="productURL", encode=false) String url, retrofit.Callback<Product> callback);

    @FormUrlEncoded
    @POST("/wishlist/entry/add")
    void addToWishlist(@QueryMap Map<String, String> query);

    @FormUrlEncoded
    @POST("/wishlist/entry/add")
    void addToWishlistAsync(@QueryMap Map<String, String> query, retrofit.Callback<Void> callback);
}
