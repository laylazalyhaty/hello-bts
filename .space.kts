/**
* JetBrains Space Automation
* This Kotlin-script file lets you automate build activities
* For more info, see https://www.jetbrains.com/help/space/automation.html
*/

job("Hello World!") {
    container(displayName = "Say Hello", image = "hello-world")
}

job("Hello BTS!") {
    container(displayName = "Say Hello KNJ", image = "hello-knj")
    container(displayName = "Say Hello KSJ", image = "hello-ksj")
}
