package br.com.beblue.fatec.livecoding.ui.main

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import br.com.beblue.fatec.livecoding.R
import br.com.beblue.fatec.livecoding.domain.Company
import br.com.beblue.fatec.livecoding.network.ApiManager
import br.com.beblue.fatec.livecoding.ui.main.adapter.CompanyAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity(), MainActivityContract.View {

    private lateinit var mPresenter: MainActivityContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            mPresenter.onClickFab()
        }

        mPresenter = MainActivityPresenter(this, ApiManager.getInstance())
        mPresenter.start()
    }


    /*
        Contract
     */
    override fun showActivityRead() {
        val intent = Intent(this, ReadActivity::class.java)
        startActivity(intent)
    }

    override fun loadCompanyRecyclerView(cnpjList: List<Company>?) {

        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerCompany.layoutManager = layoutManager

        val adapter = CompanyAdapter(cnpjList)
        recyclerCompany.adapter = adapter
    }
}
