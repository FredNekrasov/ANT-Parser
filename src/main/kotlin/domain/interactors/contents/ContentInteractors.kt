package domain.interactors.contents

import domain.interactors.contents.delete.DeleteContentInteractor
import domain.interactors.contents.get.GetContentsInteractor
import domain.interactors.contents.insert.InsertContentInteractor

data class ContentInteractors(
    val get: GetContentsInteractor,
    val delete: DeleteContentInteractor,
    val insert: InsertContentInteractor
)