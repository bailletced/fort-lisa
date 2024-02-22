package service.file

import org.junit.Test
import kotlin.test.assertNotNull

class TestFileReaderServiceResource {
    @Test
    internal fun testReadResource() {
        val content = FileReaderServiceResource().read("/item/equipment/helmet/LaurelCrown.json")
        assertNotNull(content)
    }
}
