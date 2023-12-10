package com.example.socketsandroid

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.socketsandroid.databinding.ActivityMainBinding
import io.socket.client.IO
//import io.socket.client.Socket
import org.json.JSONException
import org.json.JSONObject
import java.net.URISyntaxException
import io.socket.emitter.Emitter
import com.example.socketsandroid.Socket

//class MainActivity : AppCompatActivity() {
//
//    private lateinit var binding: ActivityMainBinding
//
//    private var socket: Socket? = null
//    private lateinit var editTextCode: EditText
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//
//
////        try {
////            socket = IO.socket("http://192.168.1.134:7777")
////            socket?.connect()
////            binding.btnEnviar.setOnClickListener{
////                enviarCodigo()
////            }
////        } catch (e: URISyntaxException) {
////            e.printStackTrace()
////            println(e)
////        }
//    }
//
//    fun enviarCodigo() {
//        val codigoUsuario = binding.editTextCode.text.toString()
//
//        if (codigoUsuario != "") {
//            socket?.emit("verifyCode", codigoUsuario)
//        } else {
//            showToast("Introduce un código antes de enviarlo.")
//        }
//    }
//
//    private fun showToast(message: String) {
//        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        socket?.disconnect()
//    }
//}

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Socket.setSocket()
        Socket.establishConnection()

        val mSocket = Socket.getSocket()
        val codi = binding.editTextCode.text

//        mSocket.on("HOLA", Emitter.Listener { args ->
//            val message = args[0] as String
//            println("RECEIVED HOLA EVENT: $message")
//        })

        binding.btnEnviar.setOnClickListener{
            mSocket.emit("verifyCode", codi.toString())
            Toast.makeText(this, "Codi enviat!!! ", Toast.LENGTH_SHORT).show()
        }
    }
}
