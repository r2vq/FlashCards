package com.keanequibilan.layer_db.impl.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.keanequibilan.layer_db.impl.dao.CardSessionDao
import com.keanequibilan.layer_db.impl.dao.CardSessionViewDao
import com.keanequibilan.layer_db.impl.dao.FlashCardDao
import com.keanequibilan.layer_db.impl.dao.SessionDao
import com.keanequibilan.layer_db.impl.entity.CardSessionEntity
import com.keanequibilan.layer_db.impl.entity.CardSessionView
import com.keanequibilan.layer_db.impl.entity.FlashCardEntity
import com.keanequibilan.layer_db.impl.entity.SessionEntity

@Database(
    entities = [
        FlashCardEntity::class,
        SessionEntity::class,
        CardSessionEntity::class
    ],
    views = [
        CardSessionView::class
    ],
    version = 1
)
/**
 * @startuml
 * hide circle
 * skinparam linetype ortho
 *
 * entity "FlashCardTable" as card {
 *  *id : int <<generated>>
 * --
 *  *front : text
 *  *back : text
 * }
 *
 * entity "SessionTable" as session {
 *  *id : number <<generated>>
 * }
 *
 * entity "CardSessionTable" as cardSession {
 *  *cardId : int <<FK>>
 *  *sessionId : int <<FK>>
 * --
 *  *correct : int
 *  *incorrect : int
 *  *skip : int
 * }
 *
 * entity "CardSessionView" as cardSessionView {
 *  *cardId : int <<FK>>
 *  *sessionId : int <<FK>>
 * --
 *  *front : text
 *  *back : text
 *  *correct : int
 *  *incorrect : int
 *  *skip : int
 * }
 *
 * note bottom: This shows only the CardSessions\nwith the most recent session. If any\nFlashCards aren't in the most recent\nCardSessionTable, it will still show\nthe FlashCard values but it will\ndefault "correct", "incorrect",and\n"skip" to 0.
 *
 * card ||..o{ cardSession
 * cardSession }o..|| session
 * cardSessionView |o--|| cardSession
 * cardSessionView |o--|| card
 * @enduml
 */
internal abstract class FlashCardDatabase : RoomDatabase() {
    abstract fun flashCardDao(): FlashCardDao
    abstract fun sessionDao(): SessionDao
    abstract fun cardSessionDao(): CardSessionDao
    abstract fun cardSessionViewDao(): CardSessionViewDao
}
