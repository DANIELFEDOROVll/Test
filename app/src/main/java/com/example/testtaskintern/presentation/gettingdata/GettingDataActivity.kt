package com.example.testtaskintern.presentation.gettingdata


import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.testtaskintern.R
import com.example.testtaskintern.databinding.ActivityMainBinding
import com.example.testtaskintern.presentation.history.HistoryActivity
import com.example.testtaskintern.presentation.model.InformationItem
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


class GettingDataActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModel<GettingDataViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        observe()
        setClickListenerButtons()
        setClickListenerTextViews()
    }

    private fun setClickListenerButtons(){
        binding.btGetData.setOnClickListener{
            getInformation()
        }
        binding.btToHistory.setOnClickListener{
            toHistoryActivity()
        }
    }

    private fun setClickListenerTextViews(){
        binding.textElem4.setOnClickListener {
            val bankUrl = binding.textElem6.text.toString().removePrefix("Bank url: ")
            openUrl(bankUrl)
        }

        binding.textElem7.setOnClickListener {
            val bankPhone = binding.textElem7.text.toString().removePrefix("Bank phone: ")
            openDialer(bankPhone)
        }

        binding.textElem2.setOnClickListener {
            val latitude = binding.textElem2.text.toString().removePrefix("Latitude: ")
            val longitude = binding.textElem3.text.toString().removePrefix("Longitude: ")

            openMaps(latitude.trim(), longitude.trim())
        }
    }
    private fun openUrl(url: String) {
        val intent = Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse(url)
        }
        startActivity(intent)
    }

    private fun openDialer(phoneNumber: String) {
        val intent = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:$phoneNumber")
        }
        startActivity(intent)
    }

    private fun openMaps(latitude: String, longitude: String) {
        val uri = "geo:$latitude,$longitude"
        val intent = Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse(uri)
        }
        startActivity(intent)
    }

    private fun observe(){
        lifecycleScope.launch {
            viewModel.information.collect{
                setText(it)
            }
        }

        viewModel.message.observe(this){
            toastMessage(it)
        }
    }

    private fun setText(information: InformationItem?){
        binding.textElem1.text = getString(R.string.country, information?.country)
        binding.textElem2.text = getString(R.string.latitude, information?.latitude.toString())
        binding.textElem3.text = getString(R.string.longitude, information?.longitude.toString())
        binding.textElem4.text = getString(R.string.cardType, information?.cardType)
        binding.textElem5.text = getString(R.string.bankName, information?.bankName)
        binding.textElem6.text = getString(R.string.bankUrl, information?.bankUrl)
        binding.textElem7.text = getString(R.string.bankPhone, information?.bankPhone)
        binding.textElem8.text = getString(R.string.bankCity, information?.bankCity)
    }

    private fun getInformation(){
        val bin = binding.edBin.text.toString()
        viewModel.loadInformation(bin)
    }

    private fun toHistoryActivity(){
        val intent = Intent(this, HistoryActivity::class.java)
        startActivity(intent)
    }

    private fun toastMessage(message: String){
        Toast.makeText(this, message, LENGTH_SHORT).show()
    }
}