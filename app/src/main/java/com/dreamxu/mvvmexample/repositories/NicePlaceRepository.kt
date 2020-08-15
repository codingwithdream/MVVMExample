package com.dreamxu.mvvmexample.repositories

import androidx.lifecycle.MutableLiveData
import com.dreamxu.mvvmexample.models.NicePlace

object NicePlaceRepository {
    private var dataSet: ArrayList<NicePlace> = ArrayList();

    // Pretend to get data from a webservice or online source
    fun getNicePlaces(): MutableLiveData<List<NicePlace>> {
        setNicePlaces()
        var data: MutableLiveData<List<NicePlace>> = MutableLiveData()
        data.value = dataSet
        return data
    }

    private fun setNicePlaces() {
        dataSet.add(
            NicePlace(
                "https://i.redd.it/tpsnoz5bzo501.jpg", "Havasu Falls"
            )
        )
        dataSet.add(
            NicePlace(
                "https://i.redd.it/tpsnoz5bzo501.jpg", "Trondheim"
            )
        )
        dataSet.add(
            NicePlace(
                "https://i.redd.it/qn7f9oqu7o501.jpg", "Portugal"
            )
        )
        dataSet.add(
            NicePlace(
                "https://i.redd.it/j6myfqglup501.jpg", "Rocky Mountain National Park"
            )
        )
        dataSet.add(
            NicePlace(
                "https://i.redd.it/0h2gm1ix6p501.jpg", "Havasu Falls"
            )
        )
        dataSet.add(
            NicePlace(
                "https://i.redd.it/k98uzl68eh501.jpg", "Mahahual"
            )
        )
        dataSet.add(
            NicePlace(
                "https://i.redd.it/tpsnoz5bzo501.jpg", "Frozen Lake"
            )
        )
        dataSet.add(
            NicePlace(
                "https://i.redd.it/obx4zydshg601.jpg", "Austrailia"
            )
        )
    }
}