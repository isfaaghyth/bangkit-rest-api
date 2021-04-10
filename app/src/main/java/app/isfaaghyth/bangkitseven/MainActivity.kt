package app.isfaaghyth.bangkitseven

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import com.loopj.android.http.ResponseHandlerInterface
import cz.msebera.android.httpclient.Header

class MainActivity : AppCompatActivity() {

    private var rvPerson: RecyclerView? = null
    private val urlApi = "https://reqres.in/api/users?page=1"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvPerson = findViewById(R.id.rv_person)
        rvPerson?.layoutManager = LinearLayoutManager(this)

        getUserRegres()
    }

    private fun getUserRegres() {
        val client = AsyncHttpClient()
        client.get(urlApi, object : AsyncHttpResponseHandler() {
            override fun onSuccess(
                    statusCode: Int,
                    headers: Array<out Header>?,
                    responseBody: ByteArray
            ) {
                // it will be preventing the app crash
                if (statusCode == 200) {
                    // first, convert from byteArray into string
                    val response = String(responseBody)

                    // second, convert from string json into java object
                    val regresResponse = Gson().fromJson(response, Regres::class.java)

                    // getting the list of person "data": []
                    val personList = regresResponse.data

                    rvPerson?.adapter = PersonAdapter(personList)
                }
            }

            override fun onFailure(
                    statusCode: Int,
                    headers: Array<out Header>?,
                    responseBody: ByteArray,
                    error: Throwable?
            ) {

            }
        })
    }

}