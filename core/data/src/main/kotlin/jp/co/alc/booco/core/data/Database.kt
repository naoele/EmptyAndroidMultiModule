package jp.co.alc.booco.core.data

import jp.co.alc.booco.core.data.dao.BookDao

internal abstract class Database {
    abstract fun bookDao(): BookDao
}