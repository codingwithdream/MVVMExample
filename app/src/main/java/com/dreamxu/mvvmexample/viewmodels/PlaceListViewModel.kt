package com.dreamxu.mvvmexample.viewmodels

import android.annotation.SuppressLint
import android.os.AsyncTask
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dreamxu.mvvmexample.models.NicePlace
import com.dreamxu.mvvmexample.repositories.NicePlaceRepository

class PlaceListViewModel: ViewModel() {
    private var mNicePlaces: MutableLiveData<List<NicePlace>> = NicePlaceRepository.getNicePlaces()
    private var mIsUpdating: MutableLiveData<Boolean> = MutableLiveData()

    fun addPlace(mNicePlace: NicePlace) {
        mIsUpdating.value = true

        object: AsyncTask<Void?, Void?, Void?>() {
            override fun onPostExecute(aVoid: Void?) {
                super.onPostExecute(aVoid)
                var currentPlaces: MutableList<NicePlace>? = mNicePlaces.value as MutableList<NicePlace>?
                currentPlaces?.add(mNicePlace)
                mNicePlaces.postValue(currentPlaces)
                mIsUpdating.postValue(false)
            }

            override fun doInBackground(vararg p0: Void?): Void? {
                try {
                    Thread.sleep(2000)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
                return null
            }
        }.execute()
    }

    fun getNicePlaces(): LiveData<List<NicePlace>> {
        return mNicePlaces
    }

    fun getIsUpdating(): LiveData<Boolean> {
        return mIsUpdating
    }
}