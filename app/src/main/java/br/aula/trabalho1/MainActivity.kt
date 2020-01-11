package br.aula.trabalho1

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

import android.view.MenuItem
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);

        val myToolbar = toolbar
        myToolbar.setTitleTextColor(Color.WHITE)
        setSupportActionBar(myToolbar)


        val contatos = arrayOf("Persona 5", ".HACK // G.U.", "Shadow of the Colossus", "Undertale", "Stardew Valley")
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, contatos)

        var listaContatos = lista
        listaContatos.setAdapter(adapter);
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.novo -> {
                val intent = Intent(this, JogosActivity::class.java)
                startActivity(intent)
                return false
            }

            R.id.novo -> {
                Toast.makeText(this, "Enviar", Toast.LENGTH_LONG).show()
                return false
            }

            R.id.lista -> {
                Toast.makeText(this, "Receber", Toast.LENGTH_LONG).show()
                return false
            }

            else -> return super.onOptionsItemSelected(item)
        }
    }

}
