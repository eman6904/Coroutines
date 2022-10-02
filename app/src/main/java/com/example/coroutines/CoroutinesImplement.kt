package com.example.coroutines

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.coroutines.databinding.FragmentCoroutinesImplementBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CoroutinesImplement : Fragment(R.layout.fragment_coroutines_implement) {
    private lateinit var binding: FragmentCoroutinesImplementBinding
    private lateinit var navController: NavController
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCoroutinesImplementBinding.bind(view)
        navController = Navigation.findNavController(view)
        //to hide action bar
        val activity = activity as MainActivity
        activity.supportActionBar?.hide()

        //you can run multiCoroutines at the same time
        //by pressing  startBtn
        var startBtn = false
        binding.start.setOnClickListener {
            startBtn = !startBtn
            if (startBtn) {
                binding.start.text = "stop"
                GlobalScope.launch()
                {
                    while (startBtn) {
                        binding.st1.alpha = 1f
                        delay(1000L)
                        binding.st1.alpha = 0f
                        delay(1000L)
                    }
                }
                GlobalScope.launch()
                {
                    while (startBtn) {
                        binding.st2.alpha = 0f
                        delay(1000L)
                        binding.st2.alpha = 1f
                        delay(1000L)
                    }
                }
                GlobalScope.launch()
                {
                    while (startBtn) {
                        binding.st3.alpha = 1f
                        delay(1000L)
                        binding.st3.alpha = 0f
                        delay(1000L)
                    }
                }
                GlobalScope.launch()
                {
                    while (startBtn) {
                        binding.st4.alpha = 0f
                        delay(1000L)
                        binding.st4.alpha = 1f
                        delay(1000L)
                    }
                }
                GlobalScope.launch()
                {
                    while (startBtn) {
                        binding.st5.alpha = 1f
                        delay(1000L)
                        binding.st5.alpha = 0f
                        delay(1000L)
                    }
                }
                GlobalScope.launch()
                {
                    while (startBtn) {
                        binding.st6.alpha = 0f
                        delay(1000L)
                        binding.st6.alpha = 1f
                        delay(1000L)
                    }
                }
                GlobalScope.launch()
                {
                    while (startBtn) {
                        binding.st7.alpha = 1f
                        delay(1000L)
                        binding.st7.alpha = 0f
                        delay(1000L)
                    }
                }
                GlobalScope.launch()
                {
                    while (startBtn) {
                        binding.st8.alpha = 0f
                        delay(1000L)
                        binding.st8.alpha = 1f
                        delay(1000L)
                    }
                }
                GlobalScope.launch()
                {
                    while (startBtn) {
                        binding.st9.alpha = 1f
                        delay(1000L)
                        binding.st9.alpha = 0f
                        delay(1000L)
                    }
                }
            } else {
                binding.start.text = "start"
                binding.st1.alpha = 0f
                binding.st2.alpha = 0f
                binding.st3.alpha = 0f
                binding.st4.alpha = 0f
                binding.st5.alpha = 0f
                binding.st6.alpha = 0f
                binding.st7.alpha = 0f
                binding.st8.alpha = 0f
                binding.st9.alpha = 0f
            }
        }
        binding.next.setOnClickListener {
            navController.navigate(R.id.action_coroutinesImplement_to_runBlockingUsing)
        }
    }
}
//type of coroutines
//1-main:
//GlobalScope.launch(Dispatchers.Main)
//{simple operation}
//2-IO:
//GlobalScope.launch(Dispatchers.Io)
//{Get data from a specific server}
//3-default:
//GlobalScope.launch(Dispatchers.Default)
//{Perform complex operations}
//4-unconfined:
//GlobalScope.launch(Dispatchers.unconfined)
//{type of coroutines is undefined}
//*****************8
//to change type of coroutines inside it:
//GlobalScope.launch(Dispatchers.Main)
//{
// for example---> binding. t.text="hhhhh"
// with context(Dispatchers.Io)
// {implementation......}
// }
