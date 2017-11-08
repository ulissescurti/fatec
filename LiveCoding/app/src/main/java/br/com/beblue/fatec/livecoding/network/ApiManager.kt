package br.com.beblue.fatec.livecoding.network

/**
 * Created by Rafael on 07/11/2017.
 */
class ApiManager {

    private var companyService: CompanyService? = null

    private constructor()

    companion object {

        private var apiManager: ApiManager? = null

        fun getInstance(): ApiManager {
            if (apiManager == null) {
                apiManager = ApiManager()
            }
            return apiManager!!
        }

    }

    public fun getCompanyService(): CompanyService {
        if (companyService == null) {
            companyService = NetworkFactory.createService(CompanyService::class.java)
        }
        return companyService!!
    }

}