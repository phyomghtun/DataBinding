package apk.testing.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import apk.testing.databinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    lateinit var viewModel: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        viewModel = ViewModelProvider(this)[ViewModel::class.java]
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this

        viewModel.editText.observe(this, Observer {
            viewModel.textdata.value = it.toString()
            Log.d("Text Watcher",it.toString())
        })

        viewModel.textdata.value = "My Bind Text"
        viewModel.btndata.value = "OK"

    }
}