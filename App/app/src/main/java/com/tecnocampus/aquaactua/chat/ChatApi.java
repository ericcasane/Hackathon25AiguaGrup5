package com.tecnocampus.aquaactua.chat;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ChatApi {
    @POST("chat")
    Call<ChatResponse> sendQuestion(@Body RequestBody body);
}
