pipeline {
    agent any
	
	stage('Environment') {
    steps {
        bat 'java -version'
        bat 'mvn -version'
    }
}

    stages {
        stage('Build') {
            steps {
                bat 'mvn clean compile'
            }
        }

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