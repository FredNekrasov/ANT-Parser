package domain.repositories

interface IRepository<M, I> {
    fun getList(): List<M>
    fun insert(model: M)
    fun delete(id: I)
}