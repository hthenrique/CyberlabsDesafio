package com.hthenrique.cyberlabsdesafio.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.postDelayed
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.hthenrique.cyberlabsdesafio.R
import com.hthenrique.cyberlabsdesafio.adapter.AuthorAdapter
import com.hthenrique.cyberlabsdesafio.adapter.AuthorGroupAdapter
import com.hthenrique.cyberlabsdesafio.databinding.ActivityMainBinding
import com.hthenrique.cyberlabsdesafio.model.Author
import com.hthenrique.cyberlabsdesafio.ui.presenter.MainContract
import com.hthenrique.cyberlabsdesafio.ui.presenter.MainPresenter
import com.hthenrique.cyberlabsdesafio.util.ConnectionUtil

class MainActivity : AppCompatActivity(), MainContract.View {

    private lateinit var binding: ActivityMainBinding
    private lateinit var authorAdapter: AuthorAdapter
    private lateinit var authorGroupAdapter: AuthorGroupAdapter
    private lateinit var authorListener: MainContract.AuthorActionListener

    private val connectionUtil: ConnectionUtil by lazy { ConnectionUtil() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        authorListener = MainPresenter(this, this)
        authorListener.loadAuthors()

        setupNormalAdapter()
        setupGroupAdapter()
        setNormalButtonPressed()
        setConnectionVisible()
        setupButtonsClick()
    }

    private fun setupButtonsClick() {
        binding.groupByNoneButton.setOnClickListener {
            setNormalButtonPressed()
        }

        binding.groupByAuthorButton.setOnClickListener {
            setAuthorButtonPressed()
        }
    }

    private fun setupNormalAdapter() {
        authorAdapter = AuthorAdapter(ArrayList(0))
        binding.authostListRecyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false )
        binding.authostListRecyclerView.adapter = authorAdapter

    }

    private fun setupGroupAdapter(){
        authorGroupAdapter = AuthorGroupAdapter(ArrayList(0))
        binding.groupRecyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.groupRecyclerView.adapter = authorGroupAdapter

    }

    override fun onResume() {
        super.onResume()
        authorListener.loadAuthors()
    }

    override fun showAuthors(authorList: List<Author>) {
        authorAdapter.replaceList(authorList)
        authorGroupAdapter.replaceGroupList(authorList.sortedBy { it.author })
    }

    override fun showFailure(errorMessage: String?) {
        Snackbar.make(binding.mainParent, errorMessage.toString(), Snackbar.LENGTH_LONG).show()
    }

    private fun setNormalButtonPressed(){
        binding.groupRecyclerView.visibility = View.GONE
        binding.authostListRecyclerView.visibility = View.VISIBLE
        binding.groupByNoneButton.isEnabled = false
        binding.groupByAuthorButton.isEnabled = true
    }

    private fun setAuthorButtonPressed(){
        binding.groupRecyclerView.visibility = View.VISIBLE
        binding.authostListRecyclerView.visibility = View.GONE
        binding.groupByNoneButton.isEnabled = true
        binding.groupByAuthorButton.isEnabled = false
    }

    @SuppressLint("ResourceAsColor")
    private fun setConnectionVisible() {
        if (connectionUtil.hasInternetConnection(this)){
            binding.connectionTextView.text = "Connected"
            binding.connectionTextView.setBackgroundColor(android.R.color.holo_green_light)
            binding.connectionTextView.visibility = View.VISIBLE
            val handler = Handler()
            handler.postDelayed(5000){
                binding.connectionTextView.visibility = View.GONE
            }
        }else{
            binding.connectionTextView.text = "Not connected"
            binding.connectionTextView.setTextColor(R.color.white)
            binding.connectionTextView.setBackgroundColor(android.R.color.holo_red_light)
            binding.connectionTextView.visibility = View.VISIBLE
        }
    }
}