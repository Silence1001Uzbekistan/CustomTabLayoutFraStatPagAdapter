package uz.silence.fragmentpagerpracticecontinue

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.google.android.material.tabs.TabLayout
import uz.silence.fragmentpagerpracticecontinue.Adapter.CategoryAdapter
import uz.silence.fragmentpagerpracticecontinue.CLASS.Category
import uz.silence.fragmentpagerpracticecontinue.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var categoryList: ArrayList<Category>
    lateinit var imageList: ArrayList<Int>

    lateinit var categoryAdapter: CategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        imageList = ArrayList()

        imageList.add(R.drawable.a)
        imageList.add(R.drawable.b)
        imageList.add(R.drawable.ic_launcher_foreground)
        imageList.add(R.drawable.ic_launcher_background)

        categoryList = ArrayList()
        categoryList.add(Category("Billie ellish", imageList))
        categoryList.add(Category("Billie ellish boom", imageList))
        categoryList.add(Category("Silence", imageList))
        categoryList.add(Category("Kotlin", imageList))

        categoryAdapter = CategoryAdapter(categoryList, supportFragmentManager)
        binding.viewPager.adapter = categoryAdapter
        binding.tabLayout.setupWithViewPager(binding.viewPager)

        setTabs()

        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                val customView = tab?.customView
                customView?.findViewById<LinearLayout>(R.id.circle_layout)?.visibility =
                    View.VISIBLE
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                val customView = tab?.customView
                customView?.findViewById<LinearLayout>(R.id.circle_layout)?.visibility =
                    View.INVISIBLE
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })

    }

    private fun setTabs() {

        val tabCount = binding.tabLayout.tabCount

        for (i in 0 until tabCount) {

            val tabView = LayoutInflater.from(this).inflate(R.layout.tab_item, null, false)
            val tab = binding.tabLayout.getTabAt(i)
            tab?.customView = tabView
            tabView.findViewById<TextView>(R.id.title_tv).text = categoryList[i].title


            if (i == 0) {

                tabView.findViewById<LinearLayout>(R.id.circle_layout).visibility = View.VISIBLE

            } else {

                tabView.findViewById<LinearLayout>(R.id.circle_layout).visibility = View.INVISIBLE

            }

        }

    }
}