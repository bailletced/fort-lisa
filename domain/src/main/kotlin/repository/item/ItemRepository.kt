package repository.item

interface ItemRepository {
    suspend fun findById(id: ID): Entity?
    suspend fun findAll(): List<Entity>
    suspend fun findAll(pagination: Pagination): PaginationResult<Entity>
    suspend fun create(entity: Entity): Entity
    suspend fun update(entity: Entity): Entity
    suspend fun delete(id: ID)
    suspend fun count(pagination: Pagination? = null): Long
}