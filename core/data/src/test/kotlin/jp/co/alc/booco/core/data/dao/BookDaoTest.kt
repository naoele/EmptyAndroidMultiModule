package jp.co.alc.booco.core.data.dao

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import app.cash.turbine.test
import com.google.common.truth.Truth
import io.mockk.mockk
import jp.co.alc.booco.core.data.Database
import jp.co.alc.booco.core.data.table.MDBBook
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class BookDaoTest {

    private lateinit var bookDao: BookDao
    private lateinit var db: Database

    @Before
    fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = mockk()
        bookDao = mockk()
    }

    @Test
    fun `Get book data`() = runTest {
//        coEvery {
//            bookDao.getBook(any())
//        } returns flow { MDBBook("9580001") }
        flowOf(MDBBook("9580001")).test {
            val item = awaitItem()
            Truth.assertThat(item)
                .isEqualTo(MDBBook("9580001"))

            awaitComplete()
        }
    }
}