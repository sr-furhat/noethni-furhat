package furhatos.app.noethni.flow

import furhatos.flow.kotlin.*
import furhatos.app.noethni.flow.main.Sleeping
import furhatos.app.noethni.flow.wizardButtons.StartTheExperiment

val Parent: State = state {
    include(StartTheExperiment)
    onUserEnter(instant = true) {
        when { // "it" is the user that entered
            furhat.isAttendingUser -> furhat.glance(it.id) // Glance at new users entering
            !furhat.isAttendingUser -> furhat.attend(it) // Attend user if not attending anyone
        }
    }

    onUserLeave(instant = true) {
        when {
            !users.hasAny() -> { // last user left
                furhat.attendNobody()
                goto(Sleeping)
            }
            furhat.isAttending(it) -> furhat.attend(users.other) // current user left
            !furhat.isAttending(it) -> furhat.glance(it.head.location) // other user left, just glance
        }
    }

}
