package ir.glorysys.myapplication.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import ir.glorysys.myapplication.model.DataModel
import ir.glorysys.myapplication.R
import ir.glorysys.myapplication.webapi.WebApi
import ir.glorysys.myapplication.adapter.Adapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), WebApi.onGetData {

val TAG="main"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //
        var recyclerView=recyclearview_main_adapter
        recyclerView?.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        var api= WebApi(applicationContext)
        api.getData(this)


    }




    override fun onGetDataSuccessfull(list: MutableList<DataModel>) {
        val adapter= Adapter(list)
        var i=0
        var recyclerView=recyclearview_main_adapter
        recyclerView?.adapter=adapter
        Log.d(TAG,"${list.size}")

    }

    override fun onGetDataError(){
        Log.d(TAG,"error")
    }


}