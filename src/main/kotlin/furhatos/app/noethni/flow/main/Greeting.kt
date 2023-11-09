package furhatos.app.noethni.flow.main

import furhat.libraries.standard.GesturesLib
import furhatos.app.noethni.flow.Parent
import furhatos.flow.kotlin.State
import furhatos.flow.kotlin.users
import furhatos.flow.kotlin.furhat
import furhatos.flow.kotlin.state

val Init2: State = state(Parent) {
    onEntry {
        furhat.say("Wuuh. Good morning.")
    }

    onTime(repeat = 3000..5000) {
        furhat.attend(users.other)
    }

    onTime(repeat = 15000..20000) {
        furhat.say {
            random{
                + "Just waiting to everyone is set."
                + "Take your time."
                + "I'll start right after everything is set."
            }
        }
    }
}

val Greeting: State = state(Parent) {
    onEntry {
        when (users.count) {
            in 1..2 -> {
                for (user in users.all) {
                    delay(200)
                    furhat.attend(user)
                    GesturesLib.PerformBigSmile1
                    GesturesLib.ExpressEmpathy()
                    furhat.say {
                        random {
                            + "Hi!"
                            + "Hello!"
                            + "Hello there!"
                            + "Welcome!"
                        }
                    }
                    delay(200)
                }
            }
            else -> {
                furhat.say {
                    random {
                        +"Hello everyone!"
                        +"Hi everyone!"
                        +"Wow! Welcome everyone!"
                    }
                }
            }
        }
        delay(150)
        furhat.say{
            + GesturesLib.ExpressPleased1()
            + "First of all. "
        }
        furhat.attend(users.other)
        furhat.say{
            + GesturesLib.ExpressHappiness1()
            + "I just want to say a big thank you from the bottom of my chip because you are helping us by joining our experiment."
        }
        furhat.attend(users.other)
        goto(Meeting)
    }
}