package furhatos.app.noethni.flow

import furhatos.app.noethni.flow.main.Sleeping
import furhatos.app.noethni.setting.DISTANCE_TO_ENGAGE
import furhatos.app.noethni.setting.MAX_NUMBER_OF_USERS
import furhatos.flow.kotlin.State
import furhatos.flow.kotlin.furhat
import furhatos.flow.kotlin.state
import furhatos.flow.kotlin.users
import furhatos.flow.kotlin.voice.Voice
import furhatos.app.noethni.flow.main.facesandvoices.DefaultFaceAndVoice


val Init: State = state {
    init {
        /** Set our default interaction parameters */
        users.setSimpleEngagementPolicy(DISTANCE_TO_ENGAGE, MAX_NUMBER_OF_USERS)
        furhat.character = DefaultFaceAndVoice["df"]
        furhat.voice = Voice(DefaultFaceAndVoice["dv"])
    }
    onEntry {
        goto(Sleeping)
    }
}
