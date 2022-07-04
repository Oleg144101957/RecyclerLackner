package com.vishnevskiypro.recyclerlackner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.vishnevskiypro.recyclerlackner.databinding.ActivityMainBinding
import com.vishnevskiypro.recyclerlackner.databinding.ItemTodoBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }

        var todoList = mutableListOf(
            ToDo("Follow Android Dev", false),
            ToDo("Learn about Recycler View", true),
            ToDo("Study method onBindViewHolder", false),
            ToDo("Study method getItemCount", false),
            ToDo("Study method onCreateViewHolder", false)
        )

        val adapter = ToDoAdapter(todoList)
        binding.rvTodo.adapter = adapter
        binding.rvTodo.layoutManager = LinearLayoutManager(this)


        binding.buttonAddTodo.setOnClickListener {
            val title = binding.editText.text.toString()
            todoList.add(ToDo(title, false))
            adapter.notifyItemInserted(todoList.size -1)
        }


    }
}