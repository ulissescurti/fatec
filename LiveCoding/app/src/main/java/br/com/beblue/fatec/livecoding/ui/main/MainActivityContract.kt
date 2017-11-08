package br.com.beblue.fatec.livecoding.ui.main

/**
 * Created by Rafael on 07/11/2017.
 */

interface MainActivityContract {

    interface View {

        fun showToast(message: String)

    }

    interface Presenter {

        fun start()

        fun onStart()

        fun onResume()

        fun onPause()

        fun onStop()

        fun onDestroy()

    }

}