package br.aula.trabalho1

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import kotlinx.android.synthetic.main.activity_jogos.*
import java.text.SimpleDateFormat
import java.util.*

class JogosActivity : AppCompatActivity() {

    var cal = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jogos)

        val myChildToolbar = toolbar_child
        setSupportActionBar(myChildToolbar)

        val ab = supportActionBar

        ab!!.setDisplayHomeAsUpEnabled(true)

        val dateSetListener = object : DatePickerDialog.OnDateSetListener {
            override fun onDateSet(view: DatePicker, year: Int, monthOfYear: Int,
                                   dayOfMonth: Int) {
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, monthOfYear)
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                updateDateInView()
            }
        }

        txtLancamento.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                DatePickerDialog(this@JogosActivity,
                    dateSetListener,
                    // set DatePickerDialog to point to today's date when it loads up
                    cal.get(Calendar.YEAR),
                    cal.get(Calendar.MONTH),
                    cal.get(Calendar.DAY_OF_MONTH)).show()
            }
        })
    }

    private fun updateDateInView() {
        val myFormat = "dd/MM/yyyy" // mention the format you need
        val sdf = SimpleDateFormat(myFormat, Locale.US)
        txtLancamento.text = sdf.format(cal.getTime())
    }
}