package item

import entity.item.Item
import entity.item.ItemCategory
import entity.item.ItemId
import repository.item.EquipmentRepository
import utils.EntitySerializer

class EquipmentRepositoryFile : EquipmentRepository {
    override fun find(
        category: ItemCategory,
        id: ItemId,
    ): Item? {
        val json = this::class.java.getResource("/item/equipment/${category.toString().lowercase()}/$id.json")?.readText()
        if (json.isNullOrEmpty()) {
            throw Exception("no equipment found. $category $id")
        }

        return EntitySerializer().parseEquipment(json)
    }
}
