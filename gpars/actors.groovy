import groovyx.gpars.dataflow.Promise 
import groovyx.gpars.actor.Actors

def richFriend = Actors.actor{
    loop {
        react { msg ->
            println "Got: $msg";
            Thread.sleep(2000)
            reply "10"
        }
    }
}

Promise loan = richFriend.sendAndPromise 'Mi presti qualche euro?'

//asynchronous waiting
loan.whenBound {money -> println "Evviva! ${money} euro"}  

println '...'

loan.join() // loan.get() sync waiting 