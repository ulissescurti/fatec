package br.com.beblue.fatec.livecoding.ui.main

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import br.com.beblue.fatec.livecoding.R
import br.com.beblue.fatec.livecoding.network.ApiManager
import kotlinx.android.synthetic.main.activity_main.*

class ReadActivity : AppCompatActivity(), ReadActivityContract.View {

    private lateinit var mPresenter: ReadActivityContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_read)
        setSupportActionBar(toolbar)

        mPresenter = ReadActivityPresenter(this, ApiManager.getInstance())
        mPresenter.start()
    }


    /*
        Contract
     */
    override fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

}
