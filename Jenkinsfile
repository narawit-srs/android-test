#!groovy
pipeline {
    agent { node { label 'master' } }

    parameters {
        choice(name: "ENVIRONMENT", choices: "NINGUNO\nDEV\nPRO", description: "The environment to be compiled")
        string(name: "EMAILS", defaultValue: "", description: "e-mails to send the builds")
        booleanParam(name: "UI_TESTS", defaultValue: false, description: "Do you want to want to run UI tests")
        string(name: "TAG_NAME", defaultValue: "", description: "The tag name of your code")
        string(name: "TAG_MESSAGE", defaultValue: "", description: "The message of your tag")
    }

    tool 'openjdk'

    stages {
        stage('Build') {
            steps {
                // slackSend color: "#2196F3", channel: "@carlos.vargas.huaman", message: "Build Started: ${env.JOB_NAME} ${env.BUILD_NUMBER}"
                sh "./gradlew assembleDebug"
            }
        }
        stage('Test') {
            parallel {
                stage('Unit Tests') {
                    steps {
                        // slackSend color: "#2196F3", channel: "@carlos.vargas.huaman", message: "Build Started: ${env.JOB_NAME} ${env.BUILD_NUMBER}"
                        sh "./gradlew testDebugUnitTest"
                    }
                }
                stage('UI Tests') {
                    steps {
                        // slackSend color: "#2196F3", channel: "@carlos.vargas.huaman", message: "Build Started: ${env.JOB_NAME} ${env.BUILD_NUMBER}"
                        sh './gradlew connectedDebugAndroidTest'
                    }
                }
            }
        }
        stage('Lint') {
            steps {
                // slackSend color: "#2196F3", channel: "@carlos.vargas.huaman", message: "Build Started: ${env.JOB_NAME} ${env.BUILD_NUMBER}"
                sh './gradlew lintDebug'
            }
        }
        stage('Deploy') {
            steps {
                // slackSend color: "#2196F3", channel: "@carlos.vargas.huaman", message: "Build Started: ${env.JOB_NAME} ${env.BUILD_NUMBER}"
                echo 'Deploying....'
            }
        }
        stage("Tag Code") {
            steps {
                echo 'Tagging code....'
            }
        }
    }
}