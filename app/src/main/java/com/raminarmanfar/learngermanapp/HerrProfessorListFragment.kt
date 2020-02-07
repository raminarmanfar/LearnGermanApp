package com.raminarmanfar.learngermanapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.raminarmanfar.learngermanapp.models.DBHandler
import com.raminarmanfar.learngermanapp.models.HerrProfessorModel
import com.raminarmanfar.learngermanapp.models.HerrProffessorAdapter


/**
 * A simple [Fragment] subclass.
 */
class HerrProfessorListFragment : Fragment() {
    private val TAG = "HP Dialog"

    companion object {
        lateinit var dbHandler: DBHandler
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? { // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_herr_professor_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fab = view.findViewById<FloatingActionButton>(R.id.fabAddHp)
        fab.setOnClickListener {
            openDialog()

        }

        dbHandler = DBHandler(context, null, null, 1)
        viewHPs()
    }

    private fun openDialog() {
        val hpDetailDialog = HerrProfessorDetailDialog()
        hpDetailDialog.show(requireActivity().supportFragmentManager!!.beginTransaction(), "Add HP Dialog")
    }

    private fun viewHPs() {
        val hpsList: ArrayList<HerrProfessorModel> = dbHandler.getHps(context)
        val adapter = HerrProffessorAdapter(context, hpsList)
        val rv: RecyclerView = view!!.findViewById(R.id.rvHerrProfessor)
        rv.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        rv.adapter = adapter
    }

    override fun onResume() {
        viewHPs()
        super.onResume()
    }
}