package br.com.beblue.fatec.livecoding.ui.main

import br.com.beblue.fatec.livecoding.db.DBManager
import br.com.beblue.fatec.livecoding.domain.Coupon
import br.com.beblue.fatec.livecoding.network.ApiManager

/**
 * Created by Rafael on 07/11/2017.
 */

class MainActivityPresenter(private var mView: MainActivityContract.View?,
                            private var mApiManager: ApiManager) : MainActivityContract.Presenter {


    /*
        Contract
     */
    override fun start() {
        getCompanyList()
    }

    override fun onDestroy() {
        mView = null
    }

    override fun onClickFab() {
        mView?.showActivityRead()
    }

    private fun getCompanyList() {
        mView?.loadCompanyRecyclerView(DBManager.listAll(Coupon::class.java) as List<Coupon>?)
    }
}