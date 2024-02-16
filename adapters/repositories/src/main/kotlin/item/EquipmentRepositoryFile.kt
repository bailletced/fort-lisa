package item

import entity.item.IItem
import entity.item.IItemCategory
import entity.item.IItemId
import repository.item.EquipmentRepository
import utils.EntitySerializer

class EquipmentRepositoryFile : EquipmentRepository {
    override fun find(
        category: IItemCategory,
        id: IItemId,
    ): IItem? {
        val json = this::class.java.getResource("/item/equipment/${category.toString().lowercase()}/$id.json")?.readText()
        if (json.isNullOrEmpty()) {
            throw Exception("no equipment found. $category $id")
        }

        return EntitySerializer().parseEquipment(json)
    }
}
