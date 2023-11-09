package furhatos.app.noethni.flow.wizardButtons

import furhat.libraries.standard.GesturesLib
import furhatos.app.noethni.flow.main.Greeting
import furhatos.app.noethni.flow.main.MeetingLastCheck
import furhatos.app.noethni.flow.main.Teaching
import furhatos.flow.kotlin.Color
import furhatos.flow.kotlin.Section
import furhatos.flow.kotlin.furhat
import furhatos.flow.kotlin.partialState

val StartTheExperiment = partialState {
    onButton("Start Greeting - No Ethni", section = Section.LEFT, color = Color.Green) {
        goto(Greeting)
    }
    onButton("Start Teaching - No Ethni", section = Section.LEFT, color = Color.Yellow) {
        furhat.gesture(GesturesLib.ExpressHappiness1())
        furhat.say("Then let's begin! Good luck!")
        goto(Teaching)
    }
}