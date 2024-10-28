package jp.co.alc.booco.core.db

import jp.co.alc.booco.core.db.dao.BookDao

internal abstract class Database {
    abstract fun bookDao(): BookDao
}