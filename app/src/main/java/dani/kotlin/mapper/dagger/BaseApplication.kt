package dani.kotlin.mapper.dagger

import android.app.Application
import dani.kotlin.mapper.dagger.component.AppComponent
import dani.kotlin.mapper.dagger.component.DaggerAppComponent

open class BaseApplication : Application() {

    val appComponent by lazy {
        initializeComponent()
    }

    open fun initializeComponent(): AppComponent {
        return DaggerAppComponent.factory().create(applicationContext)
    }
}