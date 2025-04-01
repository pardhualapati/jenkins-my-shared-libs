def call(String credId, String ImageName ){ 
                withCredentials([usernamePassword(
                    credentialsId:"${credId}",
                    passwordVariable: "dockerHubpass",
                    usernameVariable: "dockerHubuser"
                )]){    
                    sh "docker login -u ${env.dockerHubuser} -p ${env.dockerHubpass}"
                    sh "docker image tag ${ImageName} ${env.dockerHubuser}/${Imagename}"
                    sh "docker push ${env.dockerHubuser}/${Imagename}:latest"
                }
}
