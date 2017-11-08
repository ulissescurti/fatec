package br.com.beblue.fatec.livecoding.ui.main

import br.com.beblue.fatec.livecoding.domain.Company

/**
 * Created by Rafael on 07/11/2017.
 */

interface MainActivityContract {

    interface View {

        fun showActivityRead()

        fun loadCompanyRecyclerView(cnpjList : List<Company>?)
    }

    interface Presenter {

        fun start()

        fun onDestroy()

        fun onClickFab()

    }

}