package com.example.image_search_0201

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils.replace
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.image_search_0201.databinding.ActivityMainBinding
import com.example.image_search_0201.feature.search.SearchFragment
import com.example.image_search_0201.feature.storage.StorageFragment
import com.example.image_search_0201.model.SearchItemModel

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding

    val likedItems: ArrayList<SearchItemModel> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.run {
            searchButton.setOnClickListener {
                setFragment(SearchFragment())
            }
            storageButton.setOnClickListener {
                setFragment(StorageFragment())
            }
        }

        // 앱 시작 시 기본적으로 SearchFragment를 표시합니다.
        setFragment(SearchFragment())
    }

    private fun setFragment(frag: Fragment) {
        supportFragmentManager.commit {
            replace(R.id.frameLayout, frag)
            setReorderingAllowed(true)
            addToBackStack(null)
        }
    }

    fun addLikedItem(item: SearchItemModel) {
        if (!likedItems.contains(item)) {
            likedItems.add(item)
        }
    }

    fun removeLikedItem(item: SearchItemModel) {
        likedItems.remove(item)
    }
}
