package dani.kotlin.mapper.dagger.component

import dagger.Component
import dani.kotlin.mapper.dagger.module.PermissionModule
import dani.kotlin.mapper.framework.PermissionCheckerSource

@Component(modules = [PermissionModule::class])
interface PermissionComponent {
    fun inject(checkerSource: PermissionCheckerSource)
}