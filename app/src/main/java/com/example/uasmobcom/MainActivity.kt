package com.example.uasmobcom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.getsource_btn)

        button.setOnClickListener {
            getData()
        }
    }

    private fun getData() {

        val sourcecode = findViewById<TextView>(R.id.tv_sc)
        val http = findViewById<Spinner>(R.id.listitem)
        val url_edit = findViewById<EditText>(R.id.url_edtxt)

        val url = (http.selectedItem.toString()+url_edit.text)
        val queue = Volley.newRequestQueue(this)

        val stringRequest =
            StringRequest(Request.Method.GET, url, Response.Listener<String> { response ->

                var result = response.substring(0,300)
                sourcecode.text = result

            }, Response.ErrorListener {sourcecode.text = "Failed!"})

        queue.add(stringRequest)
    }
}