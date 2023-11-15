pipeline {
    agent any

    environment {
        // Define registry credentials and repository
   
        DOCKER_IMAGE = 'nguyentinh215/car-service'
        DOCKER_REGISTRY_CREDENTIALS = 'Docker'
        
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
                dir('carmanage') {
                    // All subsequent commands will be run inside the 'helloworld' directory
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                // Building Docker Image
                script {
                    docker.build("$DOCKER_IMAGE")
                }
            }
        }

        stage('Push Docker Image') {
            steps {
                // Pushing Image to Docker Registry
                script {
                    // Login to Docker Hub and push the Docker image
                    docker.withRegistry('', DOCKER_REGISTRY_CREDENTIALS) {
                        docker.image("$DOCKER_IMAGE").push()
                    }
                }
            }
        }

        stage('Pull Docker Image') {
            steps {
                // Pulling Image from Docker Registry
                script {
                     // First, remove the existing container if it exists
                    bat "docker rm -f carmanage || true"

                      // Pull the latest Docker image and run it
                    bat "docker pull $DOCKER_IMAGE"
                }
            }
        }
        

        stage('Run Docker Container') {
            steps {
                // Running Docker Container
                script {
                    bat "docker run -d --name car_service_app -p 8083:8082 $DOCKER_IMAGE"
                }
            }
        }
    }

    post {
        always {
            // Cleanup action (example: deleting temporary files)
            // Replace this with actual cleanup commands
            echo 'Performing cleanup actions'

            // Sending notifications (example: sending an email)
            // Replace this with actual notification commands
            echo 'Sending notifications'
        }
    }
}
