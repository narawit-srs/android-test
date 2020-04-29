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
        stage('Unit Tests') {
            steps {
                slackSend color: "#2196F3", channel: "@carlos.vargas.huaman", message: "Build Started: ${env.JOB_NAME} ${env.BUILD_NUMBER}"
                sh "./gradlew testDebugUnitTest"
            }
        }
        stage('UI Tests') {
            steps {
                slackSend color: "#2196F3", channel: "@carlos.vargas.huaman", message: "Build Started: ${env.JOB_NAME} ${env.BUILD_NUMBER}"
                echo './gradlew connectedDebugAndroidTest'
            }
        }
        stage('Lint') {
            steps {
                slackSend color: "#2196F3", channel: "@carlos.vargas.huaman", message: "Build Started: ${env.JOB_NAME} ${env.BUILD_NUMBER}"
                echo './gradlew lintDebug'
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