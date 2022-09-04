/**
* JetBrains Space Automation
* This Kotlin-script file lets you automate build activities
* For more info, see https://www.jetbrains.com/help/space/automation.html
*/

job("Build, push and deploy") {
    container(displayName = "Say Hello", image = "hello-world")

	startOn {
        gitPush {enabled = true}
    }

	container( 
         displayName = "Sending announcement to channel Deployments",
    ) {
    
    kotlinScript { api -> 
        println("Running in branch: "+ api.gitBranch())
        api.gradlew("build")
        
        api.space().chats.messages.sendMessage(
            MessageRecipient.Channel(ChatChannel.FromName("CI-Channel")),
            ChatMessage.Text("Build has completed - build numer" + api.executionNumber()) 
        )
    }
}
}
    
