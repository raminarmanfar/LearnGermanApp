package com.raminarmanfar.learngermanapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.raminarmanfar.learngermanapp.models.DBHandler
import com.raminarmanfar.learngermanapp.models.HerrProfessorModel
import com.raminarmanfar.learngermanapp.models.HerrProffessorAdapter


/**
 * A simple [Fragment] subclass.
 */
class HerrProfessorListFragment : Fragment() {

    companion object {
        lateinit var dbHandler: DBHandler
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? { // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_herr_professor_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dbHandler = DBHandler(context, null, null, 1)
        viewHPs(view)
    }
    private fun viewHPs(view: View) {
        val hpsList: ArrayList<HerrProfessorModel> = dbHandler.getHps(context)
        val adapter = HerrProffessorAdapter(context, hpsList)
        val rv: RecyclerView = view.findViewById(R.id.rvHerrProfessor)
        rv.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        rv.adapter = adapter
    }
}