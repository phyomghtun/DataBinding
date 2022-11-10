package apk.testing.databinding

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModel : ViewModel() {
    var textdata = MutableLiveData<String>()
    var btndata = MutableLiveData<String>()
    var editText = MutableLiveData<String>()

    fun onClick(view: View){
        textdata.value = editText.value.toString()+" Done"
        btndata.value = "Clicked"
    }
}