package br.com.beblue.fatec.livecoding.ui.main

import android.widget.Toast
import br.com.beblue.fatec.livecoding.db.DBManager
import br.com.beblue.fatec.livecoding.domain.Company
import br.com.beblue.fatec.livecoding.domain.Coupon
import br.com.beblue.fatec.livecoding.network.ApiManager
import br.com.beblue.fatec.livecoding.ui.read.ReadActivityContract
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by Rafael on 07/11/2017.
 */

class ReadActivityPresenter(private var mView: ReadActivityContract.View?,
                            private var mApiManager: ApiManager) : ReadActivityContract.Presenter {

    var c : Coupon? = null

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
        mView?.stopCamera()

        val split = text?.replace("CFe", "")?.split("|")

        if(split?.size != null){
            c = Coupon()
            c?.key = split[0]
            c?.date = split[1]
            c?.amount = split[2].toFloat()
            c?.cpf = split[3]

            searchCompany(c?.key?.substring(6,20)!!)
            return
        }

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
            return
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
                mView?.showToast("Falha")
            }

            override fun onResponse(call: Call<Company>?, response: Response<Company>?) {
                onSuccess(response)
            }
        })
    }

    fun onSuccess(response: Response<Company>?) {
        val o = Company();
        o.nome = response!!.body().nome!!

        c?.company = o

        DBManager.insert(c)
        mView?.showToast("Cupom registrado.")
        mView?.closeActivity()
    }

}