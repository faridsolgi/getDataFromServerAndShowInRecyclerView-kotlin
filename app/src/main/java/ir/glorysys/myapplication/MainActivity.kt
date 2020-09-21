package ir.glorysys.myapplication

import android.database.Cursor
import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),WebApi.onGetData{

val TAG="main"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //
        var recyclerView=recyclearview_main_adapter
        recyclerView?.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        var api=WebApi(applicationContext)
        api.getData(this)


    }




    override fun onGetDataSuccessfull(list: MutableList<DataModel>) {
        val adapter=Adapter(list)
        var i=0
        var recyclerView=recyclearview_main_adapter
        recyclerView?.adapter=adapter
        Log.i("receved","${list.size}")

    }

    override fun onGetDataError(){
        Log.i("receved","error")
    }


}