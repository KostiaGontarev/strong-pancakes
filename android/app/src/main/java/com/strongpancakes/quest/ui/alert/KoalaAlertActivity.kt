package com.strongpancakes.quest.ui.alert

import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.strongpancakes.quest.OfficeMeApp
import com.strongpancakes.quest.R
import kotlinx.android.synthetic.main.activity_koalo_alert.*
import java.io.Serializable

/**
 * Created by dima_korolev on 18/06/2017.
 */

class KoalaAlertActivity : AppCompatActivity() {

    interface ActionClick: Serializable {
        fun clicked()
    }

    companion object {
        fun show(message: String, action: String?, callback: ActionClick?) {
            val intent = Intent(OfficeMeApp.instance, KoalaAlertActivity::class.java)
            intent.putExtras(Bundle().apply {
                putString("message", message)
                putString("action", action)
                putSerializable("callback", callback)
            })
            intent.addFlags(FLAG_ACTIVITY_NEW_TASK)
            OfficeMeApp.instance.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_koalo_alert)
        val arguments = intent.extras
        message.text = arguments.getString("message")
        val action = arguments.getString("action", "OK")
        confirm.text = action
        close.setOnClickListener { finish() }
        confirm.setOnClickListener {
            val callback = arguments.getSerializable("callback") as? ActionClick
            if (callback != null) callback.clicked()
            else finish()
        }
    }
}