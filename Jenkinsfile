pipeline {
   environment {
        registryCredential = 'Docker'
        TIMESTAMP = new Date().format("yyyyMMdd_HHmmss")
    }
   agent any
   tools {
    maven 'Maven 3.6.3'
}

   stages {
    stage('Maven Clean') {
            steps {
               script{
                sh 'mvn clean'
               }
            }
        }
        stage('Maven Install') {
            steps {
               script{
                sh 'mvn install'               
            }
            }
        }
      stage('Building Docker Image') {
         steps {
            script{
               docker.withRegistry('',registryCredential){
                  def customImage = docker.build("mihulsingh/assignmentthree:${env.TIMESTAMP}")
               }
            }
         }
      }

      stage('Pushing Image to Docker Hub') {
         steps {
            script{
               docker.withRegistry('',registryCredential){
                  sh "docker push mihulsingh/assignmentthree:${env.TIMESTAMP}"
               }
            }
         }
      }
      stage('Rancher Deployment') {
         steps {
            script{
               sh "kubectl set image deployment/assignment-three container-1=mihulsingh/assignmentthree:${env.TIMESTAMP} -n default"
            }
         }
      }
   }
}
