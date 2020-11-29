package dani.kotlin.mapper.dagger.module

import dagger.Binds
import dagger.Module
import dani.kotlin.data.listener.LocationListener
import dani.kotlin.mapper.framework.GeoLocatorSource

@Module
abstract class LocationModule {
    @Binds
    abstract fun getLocationListener(checker: GeoLocatorSource): LocationListener
}