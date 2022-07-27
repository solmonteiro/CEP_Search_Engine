package com.example.cep_search_engine

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var btnSend:Button
    lateinit var etCep:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSend=findViewById(R.id.btnSend)
        etCep=findViewById(R.id.etCep)

        btnSend.setOnClickListener {
            if(etCep.text.toString().length==8){
                val intent = Intent(this,RespActivity::class.java)
                intent.putExtra("cep",etCep.text.toString()) //Passa a informação capturada no Edit Text de Main para a RespActivity
                startActivity(intent)
            }else{
                Toast.makeText(this,"O CEP contém 8 números",Toast.LENGTH_SHORT).show()
            }
        }
    }
}