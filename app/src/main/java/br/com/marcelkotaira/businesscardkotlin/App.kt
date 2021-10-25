package br.com.marcelkotaira.businesscardkotlin

import android.app.Application
import br.com.marcelkotaira.businesscardkotlin.data.AppDatabase
import br.com.marcelkotaira.businesscardkotlin.data.BusinessCardRepository

class App : Application() {
    val database by lazy { AppDatabase.getDatabase(this) }
    val repository by lazy { BusinessCardRepository(database.businessDao()) }
}