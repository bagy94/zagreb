package hr.factory.zagreb_now_and_then

import hr.factory.base_module.utils.getCurrentLanguage
import org.koin.dsl.module

val applicationModule = module {
    factory { getCurrentLanguage(get()) }
}