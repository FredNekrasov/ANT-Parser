package parser.di

import dagger.Component
import parser.di.domainModule.DomainModule
import parser.di.menu.MenuBuilder

@Component(modules = [DataModule::class, DomainModule::class])
interface AppComponent {
    fun getMenu(): MenuBuilder
}