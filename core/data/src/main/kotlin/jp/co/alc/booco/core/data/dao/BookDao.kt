package jp.co.alc.booco.core.data.dao

import jp.co.alc.booco.core.data.table.MDBBook
import kotlinx.coroutines.flow.Flow

interface BookDao {
    fun getBook(alcSkuId: String): Flow<MDBBook>
}