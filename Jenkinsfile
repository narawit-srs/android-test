#!groovy
pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                slackSend color: "#2196F3", channel: "@carlos.vargas.huaman", message: "Build Started: ${env.JOB_NAME} ${env.BUILD_NUMBER}"
                sh "./gradlew assembleDebug"
            }
        }
        stage('Test') {
            steps {
                slackSend color: "#2196F3", channel: "@carlos.vargas.huaman", message: "Build Started: ${env.JOB_NAME} ${env.BUILD_NUMBER}"
                sh "./gradlew testDebugUnitTest"
            }
        }
        stage('Deploy') {
            steps {
                slackSend color: "#2196F3", channel: "@carlos.vargas.huaman", message: "Build Started: ${env.JOB_NAME} ${env.BUILD_NUMBER}"
                echo 'Deploying....'
            }
        }
    }
}