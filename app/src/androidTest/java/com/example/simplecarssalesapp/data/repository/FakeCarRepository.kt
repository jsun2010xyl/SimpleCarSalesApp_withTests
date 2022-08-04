package com.example.simplecarssalesapp.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.simplecarssalesapp.data.db.entity.Car
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FakeCarRepository: CarRepository {

    private val carList: List<Car> = listOf()
    private val observableCarList = MutableLiveData<List<Car>>(carList)

    override suspend fun getCarList(): LiveData<List<Car>> {
        return withContext(Dispatchers.IO){
            return@withContext observableCarList
        }
    }

    fun updateCarList(newCarList: List<Car>){
        observableCarList.postValue(newCarList)
    }
}