package ir.glorysys.myapplication

import android.content.Context
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import java.lang.Exception

class WebApi(var context: Context) {


    fun getData(onGetData: onGetData) {
        val url = "https://jsonplaceholder.typicode.com/comments"
        var jsonArrayRequest = JsonArrayRequest(Request.Method.GET, url, null,
            Response.Listener {
               var i=0
                val list: MutableList<DataModel> = mutableListOf()
                while (i<it.length()){
                    try {
                        var json=it.getJSONObject(i)
                        val dataModel=DataModel()
                        dataModel.name= json.getString("name")
                        dataModel.email= json.getString("email")
                        list.add(dataModel)
                    }catch (e:Exception){e.stackTrace}
                    i++
                }
                    onGetData.onGetDataSuccessfull(list)
            },
            Response.ErrorListener {
                onGetData.onGetDataError()
            })
        val volleySingleton =VolleySingleton()
        volleySingleton.getInstance(context)?.add(jsonArrayRequest)
    }
    interface onGetData{
        fun onGetDataSuccessfull(list: MutableList<DataModel>)
        fun onGetDataError()
    }
}