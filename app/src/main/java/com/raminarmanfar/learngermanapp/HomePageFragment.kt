package com.raminarmanfar.learngermanapp

import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI

/**
 * A simple [Fragment] subclass.
 */
class HomePageFragment : Fragment(), View.OnClickListener {
    private lateinit var navController: NavController

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? { // Inflate the layout for this fragment
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_home_page, container, false)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.overflow_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item!!,
                Navigation.findNavController(view!!))
                || super.onOptionsItemSelected(item)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.btnHerrProfessor).setOnClickListener(this)
        view.findViewById<Button>(R.id.btnVerbs).setOnClickListener(this)
        view.findViewById<Button>(R.id.btnNouns).setOnClickListener(this)
        view.findViewById<Button>(R.id.btnAdjectives).setOnClickListener(this)
        view.findViewById<Button>(R.id.btnSettings).setOnClickListener(this)
        view.findViewById<Button>(R.id.btnAboutMe).setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v!!.id) {
            R.id.btnHerrProfessor -> navController!!.navigate(R.id.action_homePage_to_herrProfessorList)
            R.id.btnVerbs -> navController!!.navigate(R.id.action_homePage_to_verbsListPage)
            R.id.btnNouns -> navController!!.navigate(R.id.action_homePage_to_nounsListFragment)
            R.id.btnAdjectives -> navController!!.navigate(R.id.action_homePage_to_adjectivesListFragment)
            R.id.btnSettings -> navController!!.navigate(R.id.action_homePage_to_settingsFragment)
            R.id.btnAboutMe -> navController!!.navigate(R.id.action_homePage_to_aboutMeFragment)
        }
    }
}