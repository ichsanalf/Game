package com.example.game;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserService {

    @POST("login")
    Call<LoginResponse> loginUser(@Body LoginRequest loginRequest);

    @POST("registration")
    Call<RegisterResponse> registerUsers(@Body RegisterRequest registerRequest);
}
