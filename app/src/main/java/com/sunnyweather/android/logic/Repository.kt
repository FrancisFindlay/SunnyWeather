package com.sunnyweather.android.logic

import androidx.lifecycle.liveData
import com.sunnyweather.android.logic.model.Place
import com.sunnyweather.android.logic.network.SunnyWeatherNetwork
import kotlinx.coroutines.Dispatchers
import java.lang.Exception
import java.lang.RuntimeException

object Repository {

    fun searchPlaces(query: String) = liveData(Dispatchers.IO) {
        // 指定为IO后，代码就运行在子线程了
        val result = try {
            val placeResponse = SunnyWeatherNetwork.searchPlaces(query)
            when (placeResponse.status) {
                "ok" -> {
                    val places = placeResponse.places
                    Result.success(places)
                }
                else -> {
                    Result.failure(RuntimeException("response status is ${placeResponse.status}"))
                }
            }
        } catch (e: Exception) {
            Result.failure<List<Place>>(e)
        }
        // 类似 liveData 的 setValue
        emit(result)
    }
}