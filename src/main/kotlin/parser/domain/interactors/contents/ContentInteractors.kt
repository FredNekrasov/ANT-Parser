package parser.domain.interactors.contents

import parser.domain.interactors.contents.delete.DeleteContentInteractor
import parser.domain.interactors.contents.get.GetContentsInteractor
import parser.domain.interactors.contents.insert.InsertContentInteractor

data class ContentInteractors(
    val getContent: GetContentsInteractor,
    val deleteContent: DeleteContentInteractor,
    val insertContent: InsertContentInteractor
)