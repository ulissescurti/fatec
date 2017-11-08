package br.com.beblue.fatec.livecoding.ui.main

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.widget.Toast
import br.com.beblue.fatec.livecoding.R
import br.com.beblue.fatec.livecoding.network.ApiManager
import br.com.beblue.fatec.livecoding.ui.read.ReadActivityContract
import com.google.zxing.BarcodeFormat
import com.google.zxing.Result
import kotlinx.android.synthetic.main.activity_read.*
import me.dm7.barcodescanner.zxing.ZXingScannerView
import java.util.*


class ReadActivity : AppCompatActivity(), ReadActivityContract.View, ZXingScannerView.ResultHandler {
    private val REQUEST_CODE_PERMISSION = 10

    private lateinit var mPresenter: ReadActivityContract.Presenter

    private var mScannerView: ZXingScannerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_read)

        setSupportActionBar(toolbar_read)
        supportActionBar?.setTitle("Leitura")
        supportActionBar?.setHomeButtonEnabled(true)

        mPresenter = ReadActivityPresenter(this, ApiManager.getInstance())
        mPresenter.start()
    }

    override fun onOptionsItemSelected(menuItem: MenuItem): Boolean {
        if (menuItem.getItemId() === android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(menuItem)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == REQUEST_CODE_PERMISSION) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                mPresenter?.onPermissionGranted()
            } else {
                mPresenter?.onPermissionDenied()
            }
        }
    }

    override fun onDestroy() {
        mPresenter?.onDestroy()
        super.onDestroy()
    }


    /*
        Contract
     */
    override fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun hasPermission(): Boolean {
        return ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED
    }

    override fun requestPermissionRationale(): Boolean {
        return ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)
    }

    override fun requestPermission() {
        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), REQUEST_CODE_PERMISSION);
    }

    override fun closeActivity() {
        finish()
    }

    override fun showPermissionRationale() {
        TODO()
    }

    override fun startCamera() {
        if (mScannerView != null)
            return

        mScannerView = ZXingScannerView(this)
        frameLayout.addView(mScannerView)

        val formats = ArrayList<BarcodeFormat>()
        formats.add(BarcodeFormat.QR_CODE)

        mScannerView?.setFormats(formats)
        mScannerView?.setResultHandler(this)
        mScannerView?.setAutoFocus(true)
        mScannerView?.startCamera(-1)
    }

    override fun stopCamera() {
        if (mScannerView == null)
            return

        mScannerView?.stopCamera()
    }


    /*
        Callback
     */
    override fun handleResult(result: Result?) {
        mPresenter?.onReadQRCode(result?.getText());
    }

}
