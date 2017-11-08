package br.com.beblue.fatec.livecoding.ui.main

/**
 * Created by Rafael on 07/11/2017.
 */

interface MainActivityContract {

    interface View {

        fun showActivityRead()

    }

    interface Presenter {

        fun start()

        fun onDestroy()

        fun onClickFab()

    }

}