package com.android.ommy

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration

/**
 * Created by kombo on 14/03/2018.
 */
class App: Application() {

    companion object {
        lateinit var instance: App
    }

    init {
        instance = this
    }

    override fun onCreate() {
        super.onCreate()

        Realm.init(this)
        Realm.setDefaultConfiguration(realmConfig())
    }

    private fun realmConfig(): RealmConfiguration {
        return RealmConfiguration.Builder()
                .name("Ommy") //hardcoded string just in case app name may change and thus preserve Realm's integrity and data
                .schemaVersion(1)
                .deleteRealmIfMigrationNeeded()
                .build()
    }
}