pipeline {
    agent any

    stages {
        stage('Test') {
            steps {
                bat 'mvn clean test'
            }
        }
    }

    post {
        always {
            step([$class: 'Publisher', reportFilenamePattern: 'target/surefire-reports/testng-results.xml'])
        }
    }
}