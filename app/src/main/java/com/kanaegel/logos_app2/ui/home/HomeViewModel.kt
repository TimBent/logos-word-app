package com.kanaegel.logos_app2.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kanaegel.logos_app2.StrongsEntry
import com.kanaegel.logos_app2.core.RetrofitClient
import com.kanaegel.logos_app2.core.StrongsEntryService
import com.kanaegel.logos_app2.data.StrongsApiResponseData
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException


class HomeViewModel : ViewModel() {

    private val _apiData = MutableLiveData<StrongsApiResponseData?>()
    val apiData: LiveData<StrongsApiResponseData?> = _apiData

    private val _errorMessage = MutableLiveData<String?>()
    val errorMessage: LiveData<String?> = _errorMessage

    private val _apiService = RetrofitClient.instance

    private val _strongsEntryService = StrongsEntryService();
    

    fun fetchApiData() {
        viewModelScope.launch {
            try {
                val response = _apiService.getApiResponse()
                _apiData.postValue(response)
                _errorMessage.value = null
                _json.postValue(_strongsEntryService.toStrongsEntryFromSimpleEntry(response))
            } catch (e: IOException) {
                _errorMessage.postValue("Network Error: Check connection. ${e.message}")
                _apiData.postValue(null)
            } catch (e: HttpException) {
                _errorMessage.postValue("HTTP Error: ${e.code()} - ${e.message()}")
                _apiData.postValue(null)
            } catch (e: Exception) {
                _errorMessage.postValue("An unexpected error occurred: ${e.message}")
                _apiData.postValue(null)
            }
        }
    }

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
        value = _apiData.value?.stepGloss
    }

    private val _json = MutableLiveData<StrongsEntry>()

    val text: LiveData<String> = _text

    val json: LiveData<StrongsEntry> = _json


}