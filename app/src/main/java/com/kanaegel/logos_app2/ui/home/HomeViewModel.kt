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
//    {
//        value = StrongsEntry(
//            0, "H0430G","אֱלֹהִים","God","(e-lo-him)","God, usually refers to the one true God; " +
//                    "\n in a very few contexts it refers to a (pagan) god or goddess. The \"Son of God\" as a title of Jesus emphasizes his unique relationship to the Father. \"The god of this age\" refers to the devil\n" +
//                    "a deity, Acts 7:43; 1Cor. 8:5; an idol, Acts 7:40; God, the true God, Mt. 3:9, and frequently ;\n" +
//                    "God, possessed of true godhead, Jn. 1:1; Rom. 9:5; from the Hebrew, applied to potentates, Jn. 10:34, 35;\n" +
//                    "τῶ θεῶ, an intensive term, from the Hebrew, exceedingly, Acts 7:20, and, perhaps, 2Cor. 10:4\n",
//            listOf("without God (atheos - ἄθεος)",
//                "goddess (thea - θεά)",
//                "divine (theios - θεῖος)",
//                "to fight God (theomacheō - θεομαχέω)",
//                "opposing God (theomachos - θεομάχος)",
//                "God-breathed (theopneustos - θεόπνευστος)",
//                "God-hating (theostugēs - θεοστυγής)",
//                "deity"),
//            listOf("חֲשׁוֹךְ", "חָשַׁךְ", "חָשֹׁךְ"),
//            listOf("cha.shokh", "cha.shakh", "cha.shokh")
//        )
//        value = _strongsEntryService.toStrongsEntryFromSimpleEntry(_apiData.value!!)
//    }

    val text: LiveData<String> = _text

    val json: LiveData<StrongsEntry> = _json


}