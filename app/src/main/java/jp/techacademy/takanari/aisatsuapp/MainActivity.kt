package jp.techacademy.takanari.aisatsuapp

import android.app.TimePickerDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.button1) {
            textView.text = editText.text.toString()
        } else if (v.id == R.id.button2) {
            showAlertDialog()
        } else if (v.id == R.id.button3) {
            showTimePickerDialog()
        }
    }

    private fun showAlertDialog() {
        // AlertDialog.Builderクラスを使ってAlertDialogの準備をする
        val alertDialogBuilder = AlertDialog.Builder(this)
        alertDialogBuilder.setTitle("タイトル")
        alertDialogBuilder.setMessage("メッセージ")

        // 肯定ボタンに表示される文字列、押したときのリスナーを設定する
        alertDialogBuilder.setPositiveButton("肯定"){dialog, which ->
            Log.d("UI_PARTS", "肯定ボタン")
        }

        // 中立ボタンに表示される文字列、押したときのリスナーを設定する
        alertDialogBuilder.setNeutralButton("中立"){_,_ ->
            Log.d("UI_PARTS", "中立ボタン")
        }

        // 否定ボタンに表示される文字列、押したときのリスナーを設定する
        alertDialogBuilder.setNegativeButton("否定"){_,_ ->
            Log.d("UI_PARTS", "否定ボタン")
        }

        // AlertDialogを作成して表示する
        val alertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }

    private fun showTimePickerDialog() {
        val timePickerDialog = TimePickerDialog(
            this,
            TimePickerDialog.OnTimeSetListener { view, hour, minute ->
              if (hour >= 2 && (hour < 10) ) {
                  Log.d("UI_PARTS", "おはよう")
              }
              else if(hour >= 10 && hour < 18){
                  Log.d("UI_PARTS", "こんにちは")
              }
              else if((hour >= 18 && hour <= 24) || (hour >= 0 && hour < 2)) {
                  Log.d("UI_PARTS", "こんばんは")
              }
            },
            13, 0, true)
        timePickerDialog.show()
    }
}