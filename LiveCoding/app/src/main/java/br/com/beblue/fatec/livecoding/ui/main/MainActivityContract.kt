package br.com.beblue.fatec.livecoding.ui.main

import br.com.beblue.fatec.livecoding.domain.Coupon

/**
 * Created by Rafael on 07/11/2017.
 */

interface MainActivityContract {

    interface View {

        fun showActivityRead()

        fun loadCompanyRecyclerView(list: List<Coupon>?)
    }

    interface Presenter {

        fun start()

        fun onDestroy()

        fun onClickFab()

    }

}