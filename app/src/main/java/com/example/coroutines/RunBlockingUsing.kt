package com.example.coroutines

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.coroutines.databinding.FragmentCoroutinesImplementBinding
import com.example.coroutines.databinding.FragmentRunBlokingUsingBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class RunBlockingUsing : Fragment(R.layout.fragment_run_bloking_using) {
    private lateinit var binding: FragmentRunBlokingUsingBinding
    private lateinit var navController: NavController
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRunBlokingUsingBinding.bind(view)
        navController = Navigation.findNavController(view)
        //to hide action bar
        val activity = activity as MainActivity
        activity.supportActionBar?.hide()

       //here code in main thread is executed first after that
       //code in worker thread(coroutines-->globalScope)  is executed
        var counter = 0
        binding.runByGlobalScope.setOnClickListener {
            counter++
            binding.first.text = counter.toString()//->in main thread
            GlobalScope.launch {
                counter++
                binding.second.text = counter.toString()
                counter = 0
            }
            counter++
            binding.third.text = counter.toString()//->in main thread
        }
        //here code is executed line by line
        //because of using runBlocking(coroutines)
        var counter2 = 0
        binding.runByRunBlocking.setOnClickListener {
            counter2++
            binding.first.text = counter2.toString()
            runBlocking {
                counter2++
                binding.second.text = counter2.toString()
            }
            counter2++
            binding.third.text = counter2.toString()
            counter2 = 0
        }
    }
}
//another way to implement coroutines-->job concept
//val my job:job=GlobalScope.launch()
//{binding.t.text="eman"}
//runBlocking{
//my job.join()}
//====================================
// note that :
//coroutines can be ==> GlobalScope.launch(){}
//or ===>launch(){}
//or runBlocking{}
//or LifeCycleScope.launch(){}
//=======================================
//lifecycleScope is better than GlobalScope
//because globalScope is on level of application
//and when move from fragment to anther if there is globalScope coroutines running
//it will not stop
//but if there is lifeCycle coroutines running
// it will stop because it is on level of fragment only