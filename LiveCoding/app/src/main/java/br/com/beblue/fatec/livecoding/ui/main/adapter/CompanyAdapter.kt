package br.com.beblue.fatec.livecoding.ui.main.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import br.com.beblue.fatec.livecoding.R
import br.com.beblue.fatec.livecoding.domain.Coupon


/**
 * Created by viking on 08/11/17.
 */
class CompanyAdapter(private var companyList : List<Coupon>?) : RecyclerView.Adapter<CompanyAdapter.CompanyViewHolder>() {

    override fun onBindViewHolder(holder: CompanyViewHolder?, position: Int) {

        val company = companyList?.get(position)

        holder?.companyName?.text = company?.uuid
    }

    override fun getItemCount(): Int {
        return companyList?.size!!
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CompanyViewHolder {
        val v = LayoutInflater.from(parent?.context)
                .inflate(R.layout.company_list_item, parent, false)
        return CompanyViewHolder(v)
    }

    class CompanyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

        var companyName = itemView?.findViewById<TextView>(R.id.textViewCompanyName)
    }
}