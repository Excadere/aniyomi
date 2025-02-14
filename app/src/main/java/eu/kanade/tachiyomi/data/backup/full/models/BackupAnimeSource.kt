package eu.kanade.tachiyomi.data.backup.full.models

import eu.kanade.tachiyomi.animesource.AnimeSource
import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
data class BackupAnimeSource(
    @ProtoNumber(0) var name: String = "",
    @ProtoNumber(1) var sourceId: Long
) {
    companion object {
        fun copyFrom(source: AnimeSource): BackupAnimeSource {
            return BackupAnimeSource(
                name = source.name,
                sourceId = source.id
            )
        }
    }
}
