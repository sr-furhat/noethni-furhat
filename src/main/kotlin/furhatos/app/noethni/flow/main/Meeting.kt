package furhatos.app.noethni.flow.main

import furhat.libraries.standard.GesturesLib
import furhatos.app.noethni.flow.Parent
import furhatos.flow.kotlin.*
import furhatos.flow.kotlin.voice.Voice
import furhatos.app.noethni.flow.main.facesandvoices.DefaultFaceAndVoice
import furhatos.app.noethni.flow.main.facesandvoices.DutchVoice
import furhatos.app.noethni.flow.main.facesandvoices.DifferentVoice

val MeetingLastCheck = listOf(
    "Now that we have met, we can start our learning part.",
    "I'll try to teach you a topic from history, The Ottoman commander Gazi Osman Pasha. Please give your full attention to me.",
    "After I finish my teaching you'll tested by ten questions.",
    "We will give you a paper and ask you to answer those questions so be prepared for than and listen me with the knowledge that you'll be tested with those knowledge.",
    "So again. Give your full attention to me.",
    "Are you ready?",
)

val Meeting: State = state(Parent) {
    onEntry {
        goto(FirstContact)
    }
}

val FirstContact: State = state(Parent) {
    onEntry {
        furhat.say("First of all hi! I'm Furhat")
        delay(200)
        furhat.attend(users.other)
        furhat.say("I'm one of the most advanced social robots out there!")
        furhat.gesture(GesturesLib.ExpressSmileCongratulatory1(), async = false)
        furhat.attend(users.other)
        furhat.say("I can change my face in a second like this")
        furhat.attend(users.other)
        delay(400)
        furhat.character = "Kione"
        delay(1000)
        furhat.say("let me give another example")
        furhat.attend(users.other)
        delay(300)
        furhat.character = "Nazar"
        delay(1000)
        furhat.say("How about this one?")
        delay(500)
        furhat.attend(users.other)
        furhat.character = DefaultFaceAndVoice["df"]
        delay(500)

        furhat.say("The only thing that I can change is not my face. At the same time ")
        furhat.attend(users.other)
        furhat.voice = Voice(DifferentVoice)
        furhat.say("I can change my voice and language too!")
        delay(100)

        furhat.voice = Voice(DutchVoice)
        furhat.say {
            +GesturesLib.ExpressEmpathy()
            +"Hallo daar, ik ben een sociaal intelligente robot."
        }
        furhat.attend(users.other)
        furhat.say("Ik spreek vloeiend Nederlands!")

        delay(200)

        furhat.character = DefaultFaceAndVoice["df"]
        furhat.voice = Voice(DefaultFaceAndVoice["dv"])

        furhat.say("These were a couple of my features but let's start talking about the real deal")
        furhat.gesture(GesturesLib.PerformTripleBlink)
        furhat.attend(users.other)
        delay(250)
        furhat.say("I'm here as a History Teacher and I will teach you a topic that I though you will be interested in!")
        furhat.gesture(GesturesLib.PerformSmile1)
        furhat.gesture(GesturesLib.ExpressThinking())
        delay(1000)
        furhat.say("Yeah I think this should be enough for now.")
        goto(LastCheck)
    }
}

val LastCheck: State = state(Parent) {
    onEntry {
        for (element in MeetingLastCheck) {
            delay(250)
            furhat.attend(users.other)
            furhat.say(element)
        }
        furhat.gesture(GesturesLib.ExpressThinking())
    }
}