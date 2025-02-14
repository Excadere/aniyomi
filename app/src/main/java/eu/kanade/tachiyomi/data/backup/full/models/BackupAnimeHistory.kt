package eu.kanade.tachiyomi.data.backup.full.models

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
data class BackupAnimeHistory(
    @ProtoNumber(0) var url: String,
    @ProtoNumber(1) var lastSeen: Long
)
