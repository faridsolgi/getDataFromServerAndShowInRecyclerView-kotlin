package ir.glorysys.myapplication.model

import android.content.Context
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley

class VolleySingleton() {
     var instance: RequestQueue? =null

     fun  getInstance(context: Context): RequestQueue? {
        if (instance == null)
        {
            instance = Volley.newRequestQueue(context)
        }
        return instance
    }
}

