package furhatos.app.noethni

import furhatos.app.noethni.flow.Init
import furhatos.flow.kotlin.Flow
import furhatos.skills.Skill

class NoethniSkill : Skill() {
    override fun start() {
        Flow().run(Init)
    }
}

fun main(args: Array<String>) {
    Skill.main(args)
}
