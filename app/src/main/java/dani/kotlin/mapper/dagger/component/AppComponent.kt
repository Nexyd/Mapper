package dani.kotlin.mapper.dagger.component

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dani.kotlin.mapper.dagger.module.LocationModule
import dani.kotlin.mapper.dagger.module.PermissionModule
import dani.kotlin.mapper.dagger.module.PlaceModule
import dani.kotlin.mapper.ui.presenter.MainPresenter
import javax.inject.Singleton

@Singleton
@Component(modules = [
    PermissionModule::class,
    LocationModule::class,
    PlaceModule::class
])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun getMainPresenter(): MainPresenter
}