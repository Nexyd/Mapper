package dani.kotlin.mapper.dagger.module

import dagger.Binds
import dagger.Module
import dani.kotlin.data.listener.PlaceListener
import dani.kotlin.mapper.framework.PlaceSource

@Module
abstract class PlaceModule {
    @Binds
    abstract fun getPlaceListener(source: PlaceSource): PlaceListener
}