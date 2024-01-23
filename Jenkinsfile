pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                
                mvn package
               
            }
        }

        stage('Test') {
            steps {
               
                mvn clean install
               
            }
        }

        post {
            success {
                echo 'Pipeline succeeded! Notify or perform additional actions here.'
            }
            failure {
                echo 'Pipeline failed! Notify or perform additional actions here.'
            }
        }
    }
}
