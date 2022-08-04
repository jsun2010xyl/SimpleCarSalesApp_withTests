package com.example.simplecarssalesapp.data.repository

import androidx.lifecycle.LiveData
import com.example.simplecarssalesapp.data.db.entity.Car
import android.os.Build
import androidx.annotation.RequiresApi
import com.example.simplecarssalesapp.data.db.CarDao
import com.example.simplecarssalesapp.data.models.Item
import com.example.simplecarssalesapp.data.network.NetworkDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.time.ZonedDateTime

class CarRepositoryImpl(
    private val carDao : CarDao,
    private val carNetworkDataSource : NetworkDataSource
) : CarRepository {

    init{
        carNetworkDataSource.downloadedData.observeForever { newCurrentCarList ->
            persistFetchedCurrentCarList(newCurrentCarList)
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun getCarList(): LiveData<List<Car>> {
        return withContext(Dispatchers.IO){
            initCarList()
            return@withContext carDao.getCars()
        }
    }

    private fun persistFetchedCurrentCarList(fetchedItem: Item){
        GlobalScope.launch(Dispatchers.IO) {
            carDao.upsert(getCarList(fetchedItem))
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private suspend fun initCarList(){
        // TODO
        if (true){
            fetchCarList()
        }
    }

    private suspend fun fetchCarList(){
        carNetworkDataSource.fetchData()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun isFetchedItemListNeeded(lastFetchTime: ZonedDateTime): Boolean{
        val twoHrsAgo = ZonedDateTime.now().minusMinutes(120)
        return lastFetchTime.isBefore(twoHrsAgo)
    }
}