package br.com.beblue.fatec.livecoding.ui.read

/**
 * Created by Rafael on 07/11/2017.
 */

interface ReadActivityContract {

    interface View {

        fun showToast(message: String)

        fun hasPermission(): Boolean

        fun requestPermissionRationale(): Boolean

        fun requestPermission()

        fun closeActivity()

        fun showPermissionRationale()

        fun startCamera()

        fun stopCamera()

    }

    interface Presenter {

        fun start()

        fun onStart()

        fun onResume()

        fun onPause()

        fun onStop()

        fun onDestroy()

        fun onPermissionGranted()

        fun onPermissionDenied()

        fun onReadQRCode(text: String?)

    }

}