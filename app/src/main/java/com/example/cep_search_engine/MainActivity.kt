package com.example.cep_search_engine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var btnJSON:Button
    lateinit var etCep:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnJSON=findViewById(R.id.btnJSON)
        etCep=findViewById(R.id.etCep)

        /* Buscar por CEP via JSON*/
        btnJSON.setOnClickListener {

            /* Realizar a chamada da API passando o caminho do EditText */
            val call = RetrofitInitializer().apiRetrofitServiceJSON().getEnderecoByJSON(etCep.text.toString())

            /* A chamada deve implementar dois metodos: onResponse e onFailure */
            call.enqueue(object : Callback<CEP> {

                /* Caso a resposta seja positiva extraimos o objeto da resposta e exibimos o resultado na tela */
                override fun onResponse(call: Call<CEP>, response: Response<CEP>) {

                    response.let {
                        val CEPs: CEP? = it.body()

                        if (CEPs == null) {
                            txtResult.text = "Cep inválido!"

                        } else {
                            txtResult.text =
                                "Consumo via JSON" + "\n" +
                                        "Cep: " + CEPs.cep + "\n" +
                                        "Logradouro: " + CEPs.logradouro + "\n" +
                                        "Bairro: " + CEPs.bairro + "\n" +
                                        "Cidade: " + CEPs.localidade + "\n" +
                                        "UF: " + CEPs.uf
                        }
                    }
                }

                /* Caso ocorra uma falha na resposta lançamos um erro no log */
                override fun onFailure(call: Call<CEP>?, t: Throwable?) {
                    Log.e("Erro", t?.message.toString())
                }
            })
        }
    }
}
