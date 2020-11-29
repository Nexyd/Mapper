package dani.kotlin.mapper.dagger.module

import dagger.Binds
import dagger.Module
import dani.kotlin.data.listener.PermissionListener
import dani.kotlin.mapper.framework.PermissionCheckerSource

@Module
abstract class PermissionModule {
    @Binds
    abstract fun getPermissionListener(checker: PermissionCheckerSource): PermissionListener
}