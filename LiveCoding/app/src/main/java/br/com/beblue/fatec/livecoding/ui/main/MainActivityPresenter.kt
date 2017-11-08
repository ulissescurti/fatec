package br.com.beblue.fatec.livecoding.ui.main

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

    }

    override fun onDestroy() {
        mView = null
    }

    override fun onClickFab() {
        mView?.showActivityRead()
    }

    private fun getCompanyList() {

        mView?.loadCompanyRecyclerView(null)
    }
}