package dani.kotlin.mapper

import androidx.test.ext.junit.runners.AndroidJUnit4
import dani.kotlin.mapper.framework.listener.RetrofitAPI
import junit.framework.Assert.assertNotNull
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@RunWith(AndroidJUnit4::class)
class EndpointTest {
    @Test
    fun callEndpoint() {
        val service = Retrofit.Builder()
            .baseUrl("https://apidev.meep.me/")
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(RetrofitAPI::class.java)

        service.loadLocations().subscribe({ result ->
            assertNotNull(result)
        }, { error ->
            error.printStackTrace()
        })
    }
}