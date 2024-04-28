package parser.di

import dagger.Component

@Component(modules = [DataModule::class])
interface AppComponent {
    fun getMenu()
}