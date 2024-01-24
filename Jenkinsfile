pipeline {
    agent any

    environment {
        // Define any environment variables needed for your build
        MAVEN_HOME = tool 'Maven'
    }

    stages {
        stage('Checkout') {
            steps {
                // Checkout the source code from the Git repository
                checkout scm
            }
        }

        stage('Build') {
            steps {
                // Use Maven to build the project
                sh "${MAVEN_HOME}/bin/mvn clean install"
            }
        }

        // Add more stages as needed, such as testing, deploying, etc.
    }

    post {
        success {
            // Actions to be taken if the build is successful
            echo 'Build successful!'

            // You can trigger other jobs, send notifications, etc.
        }

        failure {
            // Actions to be taken if the build fails
            echo 'Build failed!'

            // You can send notifications, collect artifacts, etc.
        }
    }
}


