node {
    def DOCKERHUB_REPO = "sachinsharma31261/vehicle_reading_producer"
    def DOCKER_IMAGE_VERSION = "vehicle_reading_producer"

	
	environment {
        AWS_ACCESS_KEY_ID     = credentials('ACCESS_KEY')
        AWS_SECRET_ACCESS_KEY = credentials('SECRET_KEY')
        DB_URL  =  credentials('DB_URL ')
        DB_USER = credentials('DB_USER')
        DB_PASSWORD  = credentials('DB_PASSWORD')
        SQS_URL = credentials('SQS_URL')
        VEHICLE_ALERT_TOPIC = credentials('VEHICLE_ALERT_TOPIC')
    }
    

    stage("Clean Workspace") {
        deleteDir()
        echo DOCKERHUB_REPO
        echo DOCKER_IMAGE_VERSION
    }
    
    stage("Git Checkout") {
        checkout scm
        def GIT_COMMIT = sh(returnStdout: true, script: "git rev-parse HEAD").trim().take(7)
        DOCKER_IMAGE_VERSION = "${BUILD_NUMBER}-${GIT_COMMIT}"
    }
    
    stage("Build Docker Image") {
        sh "docker build -t ${DOCKERHUB_REPO}:${DOCKER_IMAGE_VERSION} ."
    }

    stage("Push Docker Image") {
        withDockerRegistry(credentialsId: "dockerhub") {
            sh "docker push ${DOCKERHUB_REPO}:${DOCKER_IMAGE_VERSION}"
        }
    }

    stage("Run Application on Docker Container") {
        try {
        	sh "docker run -e AWS_SECRET_KEY=${AWS_SECRET_KEY} -p 9040:9040 ${DOCKERHUB_REPO}:${DOCKER_IMAGE_VERSION}"
        }
        catch(e) {
        	echo e
			error "Docker Service Failed"
			echo "Deleting Created Images"
			sh "docker container prune -f"
            sh "docker image prune -af"
        }
    }
}