package id.xxx.example.presentation.home

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import id.xxx.example.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        binding.clickMe.setOnClickListener {
            Toast.makeText(it.context, "Thank For The Click", Toast.LENGTH_SHORT).show()
        }
    }
}