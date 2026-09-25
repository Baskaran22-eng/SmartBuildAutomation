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
            publishTestNGResults testResultsPattern: 'target/surefire-reports/testng-results.xml'
        }
    }
}