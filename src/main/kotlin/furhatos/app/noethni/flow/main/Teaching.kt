package furhatos.app.noethni.flow.main

import furhatos.app.noethni.flow.Parent
import furhatos.flow.kotlin.*

val teachingScript = listOf(
    "Ladies and Gentlemen.",
    "Today, we'll learn about a brave and skilled leader from the Ottoman Empire named Gazi Osman Pasha.",
    "He became very famous because of a battle called the \"Battle of Plevna\". Let's dive into his story!",
    "So, Who was Gazi Osman Pasha.",
    "Gazi Osman Pasha was a military leader or \"pasha\" from the Ottoman Empire.",
    "He was born in 1832. As he grew up, he showed great skill in military strategy and leadership. ",
    "And let's talk a little bit about the foundation of The Russo-Turkish war",
    "In the late 1800s, the Ottoman Empire and the Russian Empire had disagreements. ",
    "This led to a big war called the Russo-Turkish War in 1877-1878. ",
    "Many battles happened during this war, but the most famous one is the Battle of Plevna. ",
    "Finally, we came to the real deal, The Battle of Plevna",
    "In 1877, Russian troops wanted to capture a town called Plevna in modern-day Bulgaria. ",
    "The reason? It was a key place to control if they wanted to move towards the Ottoman capital, Istanbul. ",
    "But, Gazi Osman Pasha and his soldiers were there to defend it. ",
    "They built strong defenses around the town and prepared for the Russian attack. ",
    "The Russians tried many times to take Plevna, but Osman Pasha's strategies and the brave Ottoman soldiers stopped them every time. ",
    "The battle went on for months!",
    "But everything has an end right?",
    "After a long and hard fight, in December 1877, the Ottomans ran out of supplies. ",
    "Gazi Osman Pasha had to make a tough choice. Instead of surrendering in a usual way, he handed over his sword to the Russian leader as a sign of respect. ",
    "This action showed his bravery and honor. ",
    "Even though the Ottomans lost Plevna, Osman Pasha became a hero. ",
    "The title \"Gazi\" was given to him, which means \"warrior\" or \"veteran.\"",
    "Lasly, I would like to talk a little about the legacy of Osman Pasha",
    "The story of Gazi Osman Pasha reminds us of the bravery and skills of Ottoman military leaders. ",
    "Even in difficult times, they showed honor and determination. ",
    "Osman Pasha's tactics in Plevna are studied in military schools even today.",
    "In conclusion, Gazi Osman Pasha is a symbol of bravery and honor in the history of the Ottoman Empire.",
    "His leadership at Plevna showed the world the spirit and determination of the Ottoman soldiers.",
    "The next time you hear about the Russo-Turkish War, remember the hero of Plevna, Gazi Osman Pasha!",
    "And if you ever come across a war song called the \"Plevna Anthem,\" know that it was composed in honor of this very hero and his valiant stand."
)

val Teaching: State = state(Parent) {
    onEntry {
        furhat.attend(users.random)
        for (element in teachingScript) {
            delay(250)
            furhat.attend(users.other)
            furhat.say(element)
        }
        goto(Thanks)
    }
}