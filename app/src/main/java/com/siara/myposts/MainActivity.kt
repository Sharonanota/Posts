package com.siara.myposts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.ApiClient
import com.ApiInterface
import com.Retrofits
import com.siara.myposts.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.POST

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fetchPosts()
    }
    fun fetchPosts(){
        val apiClient = ApiClient.buildApiClient(ApiInterface::class.java)
        val request = apiClient.getPosts()

        request.enqueue(object:Callback<List<POST>>{
            override fun onResponse(call: Call<List<POST>>, response: Response<List<POST>>) {
                if(response.isSuccessful){
                    var posts = response.body()
                    Toast.makeText(baseContext,"fetched ${posts!!.size}posts",Toast.LENGTH_LONG)
                        .show()
                    var commentAdapter = Retrofits(baseContext,posts)
                    binding.rvComments.layoutManager=LinearLayoutManager(baseContext)
                    binding.rvComments.adapter = commentAdapter
                }
            }

            override fun onFailure(call: Call<List<POST>>, t: Throwable) {

            }

        })
    }
}