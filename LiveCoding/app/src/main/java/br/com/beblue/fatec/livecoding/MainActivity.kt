package br.com.beblue.fatec.livecoding

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import br.com.beblue.fatec.livecoding.domain.Cnpj
import br.com.beblue.fatec.livecoding.network.CnpjApiService
import br.com.beblue.fatec.livecoding.network.NetworkFactory

import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        searchCnpj("123")
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun searchCnpj(cnpj: String){
        val service = NetworkFactory.createService(CnpjApiService::class.java)

        service.getCnpj("27815245000123").enqueue(object : Callback<Cnpj> {

            override fun onFailure(call: Call<Cnpj>?, t: Throwable?) {

            }

            override fun onResponse(call: Call<Cnpj>?, response: Response<Cnpj>?) {
                onSuccess(response)
            }
        })
    }

    fun onSuccess(response: Response<Cnpj>?) {
        Toast.makeText(this, response!!.body().atividadePrincipal!![0].descricao, Toast.LENGTH_LONG).show()
    }
}
