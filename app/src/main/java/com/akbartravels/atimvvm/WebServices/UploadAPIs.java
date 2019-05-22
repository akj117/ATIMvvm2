package com.akbartravels.atimvvm.WebServices;





import com.akbartravels.atimvvm.Models.ApiResponses;
import com.akbartravels.atimvvm.Models.ImageListResponse;
import com.akbartravels.atimvvm.Models.ImageUploadResponse;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

import static com.akbartravels.atimvvm.WebServices.Constants.CREATE_D_NO;
import static com.akbartravels.atimvvm.WebServices.Constants.LOGIN;
import static com.akbartravels.atimvvm.WebServices.Constants.RETRIEVE_D_NO;
import static com.akbartravels.atimvvm.WebServices.Constants.RETRIEVE_IMAGE;
import static com.akbartravels.atimvvm.WebServices.Constants.UPLOAD_IMAGE;


public interface  UploadAPIs {

    @Multipart
    @POST(UPLOAD_IMAGE)
    Call<ImageUploadResponse> uploadImage(@Part MultipartBody.Part file, @Part("user_id") RequestBody requestBody);


    @GET(RETRIEVE_IMAGE)
    Call<ImageListResponse> getImageList();


    @Headers("Content-Type: application/json")
    @POST(LOGIN)
    Observable<ApiResponses> loginUser(@Body String body);

    @Headers("Content-Type: application/json")
    @POST(CREATE_D_NO)
    Observable<ApiResponses> createDNO(@Body String body);

    @Headers("Content-Type: application/json")
    @POST(RETRIEVE_D_NO)
    Call<ApiResponses> retrieveDNO(@Body String body);
}