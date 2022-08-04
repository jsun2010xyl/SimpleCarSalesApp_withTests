package com.example.simplecarssalesapp.viewmodels

import com.example.simplecarssalesapp.data.db.entity.Car
import com.example.simplecarssalesapp.data.repository.FakeCarRepository
import org.junit.Assert.*
import org.junit.Test

class CarViewModelTest{

    private lateinit var viewModel: CarViewModel

    @Test
    fun testIfCarListIsNotEmpty() {
        val newCarList: List<Car> = listOf(
            Car("","",20000.0,"","","",
            "","","",0,"","","","vin1",
            2019,"Tacoma","WA","123-456-7890"),
            Car("","",20000.0,"","","",
                "","","",0,"","","","vin2",
                2018,"Auburn","WA","123-456-7890")
        )

        val fakeCarRepo = FakeCarRepository()
        fakeCarRepo.updateCarList(newCarList)

        viewModel = CarViewModel(fakeCarRepo)

        // TODO: test code



    }



}