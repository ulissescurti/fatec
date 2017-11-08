package br.com.beblue.fatec.livecoding.ui.main

import br.com.beblue.fatec.livecoding.domain.Company
import br.com.beblue.fatec.livecoding.network.ApiManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by Rafael on 07/11/2017.
 */

class ReadActivityPresenter(private var mView: ReadActivityContract.View?,
                            private var mApiManager: ApiManager) : ReadActivityContract.Presenter {


    /*
        Contract
     */
    override fun start() {
//        searchCnpj("27815245000123")

        checkPermissions();
    }

    override fun onStart() {

    }

    override fun onResume() {

    }

    override fun onPause() {

    }

    override fun onStop() {

    }

    override fun onDestroy() {
        mView?.stopCamera()
        mView = null
    }

    override fun onPermissionGranted() {
        mView?.startCamera()
    }

    override fun onPermissionDenied() {
//        if (mView!!.requestPermissionRationale()) {
//            mView?.showPermissionRationale();
//        } else {
        mView?.closeActivity()
//        }
    }

    override fun onReadQRCode(text: String?) {
        mView?.showToast(text!!);
        mView?.stopCamera()
        mView?.closeActivity()
    }


    /*
        Util
     */
    private fun checkPermissions() {
        if (mView == null) {
            return
        }

        // Verifica se já possui permissão
        if (mView!!.hasPermission()) {
            mView?.startCamera()
            return;
        }

//        // Verifica se deve justificar a permissão
//        if (mView!!.requestPermissionRationale()) {
//            return;
//        }

        // Requisita a permissão
        mView?.requestPermission()
    }


    /*
        Company request
     */
    fun searchCompany(cnpj: String) {
        val service = mApiManager.getCompanyService()

        service.getCompany(cnpj).enqueue(object : Callback<Company> {

            override fun onFailure(call: Call<Company>?, t: Throwable?) {

            }

            override fun onResponse(call: Call<Company>?, response: Response<Company>?) {
                onSuccess(response)
            }
        })
    }

    fun onSuccess(response: Response<Company>?) {
        mView?.showToast(response!!.body().atividadePrincipal!![0].descricao!!)
    }

}