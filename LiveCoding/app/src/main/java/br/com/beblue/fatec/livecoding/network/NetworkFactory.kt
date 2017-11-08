package br.com.beblue.fatec.livecoding.network

import br.com.beblue.fatec.livecoding.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by viking on 07/11/17.
 */
class NetworkFactory {

    companion object {
        fun <S> createService(serviceClass: Class<S>): S {

            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY

            val okHttpClient = OkHttpClient.Builder()
                    .connectTimeout(Constants.TIMEOUT, TimeUnit.SECONDS)
                    .readTimeout(Constants.TIMEOUT, TimeUnit.SECONDS)
                    .writeTimeout(Constants.TIMEOUT, TimeUnit.SECONDS)
                    .addInterceptor(interceptor)
                    .build()

            val retrofit = Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build()

            return retrofit.create(serviceClass)
        }
    }

}