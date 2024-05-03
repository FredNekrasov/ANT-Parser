package domain.interactors.contents

import domain.interactors.contents.delete.DeleteContentInteractor
import domain.interactors.contents.get.GetContentsInteractor
import domain.interactors.contents.insert.InsertContentInteractor

data class ContentInteractors(
    val getContent: GetContentsInteractor,
    val deleteContent: DeleteContentInteractor,
    val insertContent: InsertContentInteractor
)