package domain.repositories

interface IRepository<M, I> {
    suspend fun getList(): List<M>
    suspend fun insert(model: M)
    suspend fun delete(id: I)
}