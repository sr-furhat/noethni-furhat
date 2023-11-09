package furhatos.app.noethni.flow.main

import furhat.libraries.standard.GesturesLib
import furhatos.app.noethni.flow.Parent
import furhatos.flow.kotlin.State
import furhatos.flow.kotlin.furhat
import furhatos.flow.kotlin.onUserEnter
import furhatos.flow.kotlin.state
import furhatos.flow.kotlin.voice.Voice
import furhatos.app.noethni.flow.main.facesandvoices.DefaultFaceAndVoice

val Sleeping: State = state(Parent) {
    onEntry {
        furhat.character = DefaultFaceAndVoice["df"]
        furhat.voice = Voice(DefaultFaceAndVoice["dv"])
        furhat.attendNobody()
        furhat.gesture(GesturesLib.PerformFallAsleepPersist)
    }

    onUserEnter {
        furhat.gesture(GesturesLib.PerformWakeUpWithHeadShake)
        goto(Init2)
    }
}