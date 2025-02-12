package ru.otus.daggerhomework.producer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import ru.otus.daggerhomework.R
import ru.otus.daggerhomework.activity.MainActivity
import javax.inject.Inject

class FragmentProducer : Fragment() {

    private lateinit var producerComponent: FragmentProducerComponent

    @Inject
    lateinit var viewModel: IViewModelProducer

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as MainActivity)
            .activityComponent
            .plusProducerComponent()
            .injectToFragmentProducer(this)
        view.findViewById<Button>(R.id.button).setOnClickListener {
            viewModel.generateColor()
        }
    }
}