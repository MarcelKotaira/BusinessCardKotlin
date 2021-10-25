package br.com.marcelkotaira.businesscardkotlin.ui

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.activity.viewModels
import br.com.marcelkotaira.businesscardkotlin.App
import br.com.marcelkotaira.businesscardkotlin.R
import br.com.marcelkotaira.businesscardkotlin.colorspinner.ColorList
import br.com.marcelkotaira.businesscardkotlin.colorspinner.ColorObject
import br.com.marcelkotaira.businesscardkotlin.colorspinner.ColorSpinnerAdapter
import br.com.marcelkotaira.businesscardkotlin.data.BusinessCard
import br.com.marcelkotaira.businesscardkotlin.databinding.ActivityAddBusinessCardBinding

class AddBusinessCardActivity : AppCompatActivity() {

    private val binding by lazy { ActivityAddBusinessCardBinding.inflate(layoutInflater)}
    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }
    lateinit var selectedColor: ColorObject

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        insertListener()
        loadColorSpinner()
    }

    private fun insertListener() {
        binding.btnClose.setOnClickListener {
            finish()
        }

        binding.btnConfirm.setOnClickListener {
            val businessCard = BusinessCard(
                nome = binding.tilNome.editText?.text.toString(),
                empresa = binding.tilEmpresa.editText?.text.toString(),
                telefone = binding.tilTelefone.editText?.text.toString(),
                email = binding.tilEmail.editText?.text.toString(),
                fundoPersonalizado = selectedColor.hexHashAlpha
            )
            mainViewModel.insert(businessCard)
            Toast.makeText(this, R.string.label_show_success, Toast.LENGTH_SHORT).show()
            finish()
        }
    }

    private fun loadColorSpinner()
    {
        selectedColor = ColorList().defaultColor
        binding.colorSpinner.apply {
            adapter = ColorSpinnerAdapter(applicationContext, ColorList().basicColors())
            setSelection(ColorList().colorPosition(selectedColor), true)
            onItemSelectedListener = object : AdapterView.OnItemSelectedListener
            {
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long)
                {
                    selectedColor = ColorList().basicColors()[position]
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {}
            }
        }
    }
}