package com.example.naka.lcoolougasolina

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalcular.setOnClickListener {calculaResposta()}
    }

    fun calculaResposta() {

        val precoAlcool = editTextPrecoAlcool.text.toString()
        val precoGasolina = editTextPrecoGasolina.text.toString()

        if (camposValidos(precoAlcool, precoGasolina)) {
            calculaMelhorPreco(precoAlcool, precoGasolina)
        } else {
            textViewResultado.text = "Campos preenchidos incorretamente!"
        }
    }

    private fun camposValidos(precoAlcool: String, precoGasolina: String): Boolean {
        if (precoAlcool == "") return false
        if (precoGasolina == "") return false

        return true
    }

    fun calculaMelhorPreco(precoAlcool : String, precoGasolina : String){
        val alcool = precoAlcool?.toDouble()
        val gasolina = precoGasolina?.toDouble()

        if ( alcool/gasolina >= 0.7){
            textViewResultado.text = "Utilize Gasolina"
        } else {
            textViewResultado.text = "Utilize Álcool"
        }
    }
}
